package synergix.th6.business.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.AESFastEngine;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;

public class CryptoUtils {
	public static final String RSA = "RSA";
	public static final String SHA256 = "SHA-256";

	public static KeyPair generateRSAKeyPair() {
		try {
			final KeyPairGenerator keyGen = KeyPairGenerator.getInstance(CryptoUtils.RSA);
			keyGen.initialize(2048);
			return keyGen.generateKeyPair();
		}
		catch (final Throwable t) {
			throw new RuntimeException(t);
		}
	}


	public static byte[] generateSHA256Hash(final String text) {
		try {
			final MessageDigest md = MessageDigest.getInstance(CryptoUtils.SHA256);
			md.update(text.getBytes());
			return md.digest();
		}
		catch (final Throwable t) {
			throw new RuntimeException(t);
		}
	}

	public static byte[] encryptWithAES(final byte[] key, final byte[] plainTextContent) {
		return CryptoUtils.processBouncyCastleAES(Mode.ENCRYPT, key, plainTextContent);
	}

	public static byte[] decryptWithAES(final byte[] key, final byte[] encryptedContent) {
		return CryptoUtils.processBouncyCastleAES(Mode.DECRYPT, key, encryptedContent);
	}


	public static RSAPublicKey generatePublicKeyFromEncodedBytes(final byte[] bytes) {
		if (bytes == null) {
			return null;
		}

		try {
			return (RSAPublicKey) KeyFactory.getInstance(CryptoUtils.RSA).generatePublic(new X509EncodedKeySpec(bytes));
		}

		catch (final Throwable t) {
			throw new RuntimeException(t);
		}
	}

	public static RSAPrivateKey generatePrivateKeyFromEncodedBytes(final byte[] bytes) {
		if (bytes == null) {
			return null;
		}

		try {
			return (RSAPrivateKey) KeyFactory.getInstance(CryptoUtils.RSA).generatePrivate(new PKCS8EncodedKeySpec(bytes));
		}

		catch (final Throwable t) {
			throw new RuntimeException(t);
		}
	}

	//http://stackoverflow.com/questions/11345346/how-to-get-a-rsa-publickey-by-giving-a-privatekey
	public static boolean verifyPublicPrivateKeyPair(final RSAPublicKey publicKey, final RSAPrivateKey privateKey) {
		if (publicKey == null || privateKey == null) {
			return false;
		}

		final BigInteger publicModulus = publicKey.getModulus();
		final BigInteger publicExponent = publicKey.getPublicExponent();

		final BigInteger privateModulus = privateKey.getModulus();
		final BigInteger privateExponent = privateKey.getPrivateExponent();

		// (publicModulus == privateModulus) && (2.pow(publicExponent*privateExponent-1).mod(publicModulus) == 1)
		return publicModulus.equals(privateModulus) && BigInteger.valueOf(2).modPow(publicExponent.multiply(privateExponent).subtract(BigInteger.ONE), publicModulus).equals(BigInteger.ONE);
	}


	// Using Bouncy Castle Crypto library to avoid Key Strength limitation
	public static enum Mode {
		ENCRYPT, DECRYPT
	}

	public static byte[] processBouncyCastleAES(final Mode cipherMode, final byte[] key, final byte[] data) {
		try {
			// prepare IO
			final ByteArrayInputStream bis = new ByteArrayInputStream(data);
			final ByteArrayOutputStream bos = new ByteArrayOutputStream(512);

			final byte[] ibuffer = new byte[16];
			final byte[] obuffer = new byte[512];

			int bytesRead = 0;
			int bytesProcessed = 0;

			// initialization. first arg: true for ENCRYPTION, false for decryption
			final boolean cipherModeBoolean = (cipherMode == Mode.ENCRYPT);
			final PaddedBufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new AESFastEngine());
			cipher.init(cipherModeBoolean, new KeyParameter(key));

			// processing
			while ((bytesRead = bis.read(ibuffer)) >= 0) {
				bytesProcessed = cipher.processBytes(ibuffer, 0, bytesRead, obuffer, 0);
				bos.write(obuffer, 0, bytesProcessed);
			}

			// finalize
			bytesProcessed = cipher.doFinal(obuffer, 0);
			bos.write(obuffer, 0, bytesProcessed);

			return bos.toByteArray();
		}

		catch (final InvalidCipherTextException e) {
			return null;
		}

		catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static byte[] decryptWithRSAKey(final RSAKey rsaKey, final byte[] data) {
		try {
			final Cipher cipher = Cipher.getInstance(CryptoUtils.RSA);
			cipher.init(Cipher.DECRYPT_MODE, (Key) rsaKey);
			return cipher.doFinal(data);
		}
		catch (final Throwable e) {
			return null;
		}
	}
}
