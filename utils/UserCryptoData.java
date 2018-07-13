package synergix.th6.business.action.service.ac;

import java.io.Serializable;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

import synergix.th6.business.util.CryptoUtils;
import synergix.th6.framework.util.SynStringUtils;



public class UserCryptoData implements Serializable {
	public static final String SESSION_KEY = UserCryptoData.class.getName();

	private RSAPublicKey publicKey;
	private String publicKeyBase64String;
	private RSAPrivateKey privateKey;
	private String encryptedPrivateKeyBase64String;
	private byte[] passwordHashSHA256;


	public RSAPublicKey getPublicKey() {
		return this.publicKey;
	}

	public String getPublicKeyBase64String() {
		return this.publicKeyBase64String;
	}

	public RSAPrivateKey getPrivateKey() {
		return this.privateKey;
	}

	public String getEncryptedPrivateKeyBase64String() {
		return this.encryptedPrivateKeyBase64String;
	}

	public byte[] getPasswordHashSHA256() {
		return this.passwordHashSHA256;
	}

	// static utility and factory methods
	public static UserCryptoData verifyPassword(final String password, final String encryptedPrivateKey, final String publicKeyBase64) {
		if (SynStringUtils.isNotEmpty(encryptedPrivateKey) && SynStringUtils.isNotEmpty(publicKeyBase64)) {
			final byte[] passwordHashSHA256 = CryptoUtils.generateSHA256Hash(password);

			final RSAPrivateKey privateKey = UserCryptoData.decryptPrivateKey(passwordHashSHA256, encryptedPrivateKey);
			final RSAPublicKey publicKey = UserCryptoData.decodePublicKeyBase64(publicKeyBase64);

			if (CryptoUtils.verifyPublicPrivateKeyPair(publicKey, privateKey)) {
				return new UserCryptoData(publicKey, privateKey, passwordHashSHA256);
			}
		}

		return null;
	}

	public static UserCryptoData createNew(final String password) {
		final KeyPair key = CryptoUtils.generateRSAKeyPair();
		final RSAPublicKey publicKey = (RSAPublicKey) key.getPublic();
		final RSAPrivateKey privateKey = (RSAPrivateKey) key.getPrivate();
		final byte[] passwordHashSHA256 = CryptoUtils.generateSHA256Hash(password);

		return new UserCryptoData(publicKey, privateKey, passwordHashSHA256);
	}

	// public keys are simply stored as Base64 encoded string. No encryption is required
	public static RSAPublicKey decodePublicKeyBase64(final String publicKeyBase64String) {
		return CryptoUtils.generatePublicKeyFromEncodedBytes(Base64.getMimeDecoder().decode(publicKeyBase64String));
	}

	public static String encodePublicKeyBase64(final RSAPublicKey publicKey) {
		return Base64.getMimeEncoder().encodeToString(publicKey.getEncoded());
	}

	// private keys are encrypted with user's password, and then encoded into Base64 string for storage
	public static RSAPrivateKey decryptPrivateKey(final byte[] passwordHashSHA256, final String encryptedPrivateKeyBase64) {
		final byte[] decryptedPk = CryptoUtils.decryptWithAES(passwordHashSHA256, Base64.getMimeDecoder().decode(encryptedPrivateKeyBase64));
		return CryptoUtils.generatePrivateKeyFromEncodedBytes(decryptedPk);
	}

	public static String encryptPrivateKey(final byte[] passwordHashSHA256, final RSAPrivateKey privateKey) {
		return Base64.getMimeEncoder().encodeToString(CryptoUtils.encryptWithAES(passwordHashSHA256, privateKey.getEncoded()));
	}

	public static String encryptPrivateKeyWithNewPassword(final String encryptedPrivateKey, final String currentPassword, final String newPassword) {
		// decrypt PrivateKey with old password
		final RSAPrivateKey decryptedPrivateKey = UserCryptoData.decryptPrivateKey(CryptoUtils.generateSHA256Hash(currentPassword), encryptedPrivateKey);
		// encrypt PrivateKey with new password
		return UserCryptoData.encryptPrivateKey(CryptoUtils.generateSHA256Hash(newPassword), decryptedPrivateKey);
	}


	/**
	 * Private constructor. SynAuthenticator should only be created by factory methods above
	 */
	private UserCryptoData(final RSAPublicKey publicKey, final RSAPrivateKey privateKey, final byte[] passwordHashSHA256) {
		this.publicKey = publicKey;
		this.privateKey = privateKey;
		this.passwordHashSHA256 = passwordHashSHA256;
		this.publicKeyBase64String = UserCryptoData.encodePublicKeyBase64(publicKey);
		this.encryptedPrivateKeyBase64String = UserCryptoData.encryptPrivateKey(passwordHashSHA256, privateKey);
	}


	// testing
	public static void main(final String... args) {
		final UserCryptoData testData = UserCryptoData.createNew("mypassword2");

		final UserCryptoData tryVerify = UserCryptoData.verifyPassword("mypassword2", testData.getEncryptedPrivateKeyBase64String(), testData.getPublicKeyBase64String());

		System.out.println(tryVerify);
	}
}
