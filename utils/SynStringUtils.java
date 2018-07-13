package synergix.th6.framework.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.deltaspike.core.util.ArraysUtils;

import com.google.common.base.Joiner;

import synergix.th6.framework.util.collections.SynArrayUtils;
import synergix.th6.framework.util.collections.SynCollectionUtils;
import synergix.th6.framework.util.i18n.Messages;

/**
 * Should only contain methods that's not available in commons.lang3.StringUtils
 *
 * @author HUGH
 *
 */
public abstract class SynStringUtils extends StringUtils {

	/******************************** CONSTANTS *********************************************/
	public static final String COMMA = ", ";
	public static final String COMMA_QUOTES = "', '";
	public static final String DASH = "-";
	public static final String DASH_WITH_SPACE = " - ";
	public static final String DOT_CHAR = ".";
	public static final String LEFT_BRACKET = "(";
	public static final String RIGHT_BRACKET = ")";
	public static final String APOSTROPHE = "'";
	public static final String COMMA_NO_SPACE = ",";
	public static final String ALL = "all";
	public static final String SLASH = "/";
	public static final String COLON_SPACE = ": ";
	public static final String BREAK_LINE = System.getProperty("line.separator");
	public static final String UNDERSCORE = "_";
	public static final String EQUAL = "=";
	public static final String AT_SIGN = "@";
	public static final String SEMICOLON = ";";
	public static final String ZERO = "0";

	// ================ IMPORTANT =============================
	// DON'T CREATE METHODS THAT DUPLICATE FUNCTIONALITIES IN org.apache.commons.lang3.StringUtils
	// example: equals, isEmpty(), trim(), repeat(char ch, int repeat), leftPad(), rightPad(), deleteWhitespace(), normalizeSpace()
	// capitalize(),


	public static String idTrim(final String s) {
		return SynStringUtils.upperCase(SynStringUtils.trimToNull(s));
	}

	public static boolean idEquals(final String s1, final String s2) {
		return StringUtils.equals(SynStringUtils.idTrim(s1), SynStringUtils.idTrim(s2));
	}

	public static boolean equalsIgnoreCaseAfterTrimToNull(final String s1, final String s2) {
		return StringUtils.equalsIgnoreCase(StringUtils.trimToNull(s1), StringUtils.trimToNull(s2));
	}

	public static int compare(final String firstString, final String secondString) {
		if (firstString == null && secondString == null) {
			return 0;
		}

		if (firstString == null && secondString != null) {
			return -1;
		}

		if (firstString != null && secondString == null) {
			return 1;
		}

		return firstString.compareTo(secondString);
	}



	public static String buildLikeValueExpression(final String value) {
		if (value == null) {
			return "%%";
		}

		if (value.contains("%")) {
			return value;
		}

		return "%" + value + "%";
	}

	public static boolean in(final String value, final String... others) {
		for (final String s : others) {
			if (StringUtils.equals(value, s)) {
				return true;
			}
		}
		return false;
	}

	// escapeSql(String) is copied from Apache Common Lang 2.x. The method was removed from Lang 3 because it was misleading developers to not use PreparedStatement.
	// All credits go to Apache.

	/**
	 * <p>
	 * Escapes the characters in a <code>String</code> to be suitable to pass to an SQL query.
	 * </p>
	 *
	 * <p>
	 * For example,
	 *
	 * <pre>
	 * statement.executeQuery(&quot;SELECT * FROM MOVIES WHERE TITLE='&quot; + StringEscapeUtils.escapeSql(&quot;McHale's Navy&quot;) + &quot;'&quot;);
	 * </pre>
	 *
	 * </p>
	 *
	 * <p>
	 * At present, this method only turns single-quotes into doubled single-quotes (<code>"McHale's Navy"</code> => <code>"McHale''s Navy"</code>). It does not handle the cases of percent (%) or
	 * underscore (_) for use in LIKE clauses.
	 * </p>
	 *
	 * see http://www.jguru.com/faq/view.jsp?EID=8881
	 *
	 * @param str the string to escape, may be null
	 * @return a new String, escaped for SQL, <code>null</code> if null string input
	 */
	public static String escapeSql(final String str) {
		if (str == null) {
			return null;
		}
		return org.apache.commons.lang3.StringUtils.replace(str, "'", "''");
	}



	public static void writeToFile(final String s, final File file) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(file));
			out.write(s);
		}
		catch (final Throwable e) {
			throw new RuntimeException(e);
		}
		finally {
			if (out != null) {
				try {
					out.close();
				}
				catch (final IOException ignored) {
				}
			}
		}
	}



	public static String makeUpperCamelCaseForDashDelimitedString(String s) {
		s = s.trim().toLowerCase();

		final String[] fragments = s.split("\\-");
		String result = "";

		for (final String fragment : fragments) {
			result += SynStringUtils.capitalize(fragment);
		}

		return result;
	}

	public static String replaceUnderscoreBySpaceByUpperCaseFirstChar(final String str) {
		if (SynStringUtils.isEmpty(str)) {
			return str;
		}
		else {
			final StringTokenizer tokenizer = new StringTokenizer(str, "_");
			final StringBuilder strBuilder = new StringBuilder();
			while (tokenizer.hasMoreTokens()) {
				strBuilder.append(SynStringUtils.capitalize(tokenizer.nextToken()) + " ");
			}
			strBuilder.deleteCharAt(strBuilder.length() - 1);
			return strBuilder.toString();
		}
	}

	public static String convertPropertyPathToGetterChain(final String s) {
		final String[] pathComponents = s.split("\\.");
		String result = "this";
		for (final String component : pathComponents) {
			result += ".get" + SynStringUtils.capitalize(component) + "()";
		}

		return result;
	}


	public static String buildEntityDescriptor(final String tableName, final Object... pkColumnValues) {
		final String tableNameDesc = Messages.get(tableName);
		final StringBuilder sb = new StringBuilder(tableNameDesc + "(");

		int columnCount = 0;
		for (final Object o : pkColumnValues) {
			columnCount++;
			if (columnCount > 1) {
				sb.append(",");
			}
			sb.append(o == null ? "null" : o.toString());
		}

		sb.append(")");

		return sb.toString();
	}



	/**
	 * Convert formatted IDs string into normalized ID array.
	 * <p>
	 * Eg. formatted IDs string = "MT00001","MT00002","MT00003" <br/>
	 * normalized ID array = [MT00001,MT00002,MT00003]
	 *
	 * @param formattedString
	 * @return normalized ID array
	 *
	 * @see {@link #toFormattedString(String[])}
	 */
	public static String[] toIdArray(String formattedString) {
		formattedString = SynStringUtils.trim(formattedString);
		if (formattedString == null) {
			return null;
		}
		final String[] idArray = formattedString.split("\",\"");
		for (int i = 0; i < idArray.length; i++) {
			String temp = SynStringUtils.trim(idArray[i]);
			/* Replace \" with " */
			temp = temp.replaceAll("\\\\\"", "\"");
			/* Remove preceding and subceding " */
			if (temp.startsWith("\"")) {
				temp = temp.substring(1);
			}
			if (temp.endsWith("\"")) {
				temp = temp.substring(0, temp.length() - 1);
			}
			idArray[i] = SynStringUtils.trim(temp);
		}
		return idArray;
	}

	/**
	 * Convert formatted IDs string "CODE1,CODE2,CODE3" (list-of-code) into normalized list of code.
	 *
	 * @param listOfCodeString
	 * @return normal list of code
	 */
	public static List<String> convertListOfCodeStringToList(final String listOfCodeString) {
		return Arrays.asList(SynStringUtils.convertListOfCodeStringToArray(listOfCodeString));
	}

	/**
	 * Convert formatted IDs string "CODE1,CODE2,CODE3" (list-of-code) into normalized array of code.
	 *
	 * @param listOfCodeString
	 * @return normal array of code
	 */
	public static String[] convertListOfCodeStringToArray(final String listOfCodeString) {
		return SynStringUtils.splitAndTrim(listOfCodeString, SynStringUtils.COMMA_NO_SPACE);
	}

	public static String[] splitAndTrim(final String str, final String separator) {
		return SynArrayUtils.removeElements(SynStringUtils.stripAll(SynStringUtils.split(str, separator)), "", null);
	}

	/**
	 * Convert List of Codes to String with format "CODE1,CODE2,CODE3"
	 */
	public static String convertToListOfCodeString(final Collection<String> codes) {
		if (SynCollectionUtils.isEmpty(codes)) {
			return null;
		}
		return SynStringUtils.join(codes, SynStringUtils.COMMA_NO_SPACE);
	}

	/**
	 * Convert Array of Codes to String with format "CODE1,CODE2,CODE3"
	 */
	public static String joinComma(final String... codes) {
		if (ArraysUtils.isEmpty(codes)) {
			return null;
		}
		return SynStringUtils.join(codes, SynStringUtils.COMMA_NO_SPACE);
	}

	/**
	 * Convert the given <code>String</code> value to specific type and return.
	 *
	 * @param input String
	 * @param type to convert
	 * @return converted value
	 */
	public static Object convertToObject(final String input, final Class<?> type) {
		if (Integer.class.equals(type) || int.class.equals(type)) {
			return Integer.valueOf(input);
		}
		else if (Double.class.equals(type) || double.class.equals(type)) {
			return Double.valueOf(input);
		}
		/* TODO: to continue when other types like java.util.Date is required */
		return input;
	}



	// for testing
	public static void main(final String... args) {
		System.out.println(SynStringUtils.convertPropertyPathToGetterChain("abc_def.aba_dfd.drr"));
	}

	private static String getRegexToValidate(final int atLeastUpperCaseLetters, final int atLeastLowerCaseLetters, final int atLeastNumbers, final int atLeastSpecialChars) {
		//String ALPHA_NUMERIC_PASSWORD_REGEX = "^((?=.*[^a-zA-Z])(?=.*[a-z])(?=.*[A-Z]).{2,})$";
		final String REGEX_START = "^(";
		final String REGEX_END = ".*)$";
		final String REGEX_SUB_START = "(?=";
		final String REGEX_ANY_CHAR_AT_LEAST_ONE_OR_NONE_FOLLOWED = ".*";
		final String REGEX_UPPER_CASE_LETTER = "[A-Z]";
		final String REGEX_LOWER_CASE_LETTER = "[a-z]";
		final String REGEX_NUMERIC_DIGIT = "[0-9]";
		final String REGEX_SPECIAL_CHARACTERS = "[^a-zA-Z0-9]";

		String regex = REGEX_START;
		if (atLeastUpperCaseLetters > 0) {
			String subRegex = REGEX_SUB_START;
			for (int i = 0; i < atLeastUpperCaseLetters; i++) {
				subRegex += REGEX_ANY_CHAR_AT_LEAST_ONE_OR_NONE_FOLLOWED + REGEX_UPPER_CASE_LETTER;
			}
			subRegex += ")";
			regex += subRegex;
		}

		if (atLeastLowerCaseLetters > 0) {
			String subRegex = REGEX_SUB_START;
			for (int i = 0; i < atLeastLowerCaseLetters; i++) {
				subRegex += REGEX_ANY_CHAR_AT_LEAST_ONE_OR_NONE_FOLLOWED + REGEX_LOWER_CASE_LETTER;
			}
			subRegex += ")";
			regex += subRegex;
		}

		if (atLeastNumbers > 0) {
			String subRegex = REGEX_SUB_START;
			for (int i = 0; i < atLeastNumbers; i++) {
				subRegex += REGEX_ANY_CHAR_AT_LEAST_ONE_OR_NONE_FOLLOWED + REGEX_NUMERIC_DIGIT;
			}
			subRegex += ")";
			regex += subRegex;
		}

		if (atLeastSpecialChars > 0) {
			String subRegex = REGEX_SUB_START;
			for (int i = 0; i < atLeastSpecialChars; i++) {
				subRegex += REGEX_ANY_CHAR_AT_LEAST_ONE_OR_NONE_FOLLOWED + REGEX_SPECIAL_CHARACTERS;
			}
			subRegex += ")";
			regex += subRegex;
		}

		regex += REGEX_END;
		return regex;
	}

	public static boolean isValidPassword(final String str, final int atLeastUpperCaseLetters, final int atLeastLowerCaseLetters, final int atLeastNumbers, final int atLeastSpecialChars) {
		// No Whitespace
		//String ALPHA_NUMERIC_PASSWORD_REGEX = "^((?=.*[^a-zA-Z])(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).{" + minLength + ",})$";
		// Allow Whitespaces
		//String ALPHA_NUMERIC_PASSWORD_REGEX = "^((?=.*[^a-zA-Z])(?=.*[a-z])(?=.*[A-Z]).{" + minLength + ",})$";
		if (atLeastUpperCaseLetters > 0 || atLeastLowerCaseLetters > 0 || atLeastNumbers > 0 || atLeastSpecialChars > 0) {
			final String regex = SynStringUtils.getRegexToValidate(atLeastUpperCaseLetters, atLeastLowerCaseLetters, atLeastNumbers, atLeastSpecialChars);
			return Pattern.matches(regex, str);
		}
		else {
			return true;
		}
	}

	public static String removeFileExtension(final String fileName) {
		return fileName.substring(0, fileName.lastIndexOf("."));
	}

	public static String mapToURLQueryString(final Map<String, String> map) {
		final StringBuilder stringBuilder = new StringBuilder();

		for (final String key : map.keySet()) {
			if (stringBuilder.length() > 0) {
				stringBuilder.append("&");
			}
			final String value = map.get(key);
			try {
				stringBuilder.append((key != null ? URLEncoder.encode(key, "UTF-8") : ""));
				stringBuilder.append("=");
				stringBuilder.append(value != null ? URLEncoder.encode(value, "UTF-8") : "");
			}
			catch (final UnsupportedEncodingException e) {
				throw new RuntimeException("This method requires UTF-8 encoding support", e);
			}
		}

		return stringBuilder.toString();
	}


	/*
	 * The general rules for constructing names
	 * 1. Names can contain letters, digits, underscores, and dollar signs.
	 */
	public static String makeValidJavaScriptIdentifier(final String src) {
		final String NON_LETTER_DIGIT_UNDER_SCORE_DOLLAR = "[^a-zA-Z0-9_$]";
		return src.replaceAll(NON_LETTER_DIGIT_UNDER_SCORE_DOLLAR, "");
	}


	public static String joinIfNotEmpty(final String delimiter, final String... parts) {
		// practising Java 8 :)
		return Arrays.stream(parts).filter(s -> !StringUtils.isEmpty(s)).collect(Collectors.joining(delimiter));
	}


	public static String coerceToString(final Object o) {
		return o == null ? "" : o.toString();
	}


	public static int getUTF8Length(final String s) {
		//return s == null ? 0 : s.getBytes(StandardCharsets.UTF_8).length;

		// less readable, but more efficient implementation. Read Java String unicode specs for details
		return s.chars().map(c -> c < 0x80 ? 1 : c < 0x800 ? 2 : c < 0xD800 ? 3 : c < 0xE000 ? 2 : 3).sum();
	}

	public static String nullTrim(final String s) {
		return s == null ? "" : s.trim();
	}

	public static String join(final String separator, final String... chunks) {
		String result = "";
		for (final String chunk : chunks) {
			if (StringUtils.isNotEmpty(result) && StringUtils.isNotEmpty(chunk)) {
				result += separator;
			}
			result += SynStringUtils.nullTrim(chunk);
		}
		return result;
	}


	public static String join(final String separator, final Collection<String> chunks) {
		String result = "";
		if (SynCollectionUtils.isNotEmpty(chunks)) {
			for (final String chunk : chunks) {
				if (StringUtils.isNotEmpty(result) && StringUtils.isNotEmpty(chunk)) {
					result += separator;
				}
				result += SynStringUtils.nullTrim(chunk);
			}
		}
		return result;
	}

	public static String replaceFileNameSpace(String fileName) {
		if (fileName != null) {
			fileName = fileName.replaceAll(" ", "_");
			if (fileName.length() > 120) {
				/* Cutting file name not to exceed max length 120 */
				fileName = fileName.substring(0, 114) + ".." + fileName.substring(fileName.length() - 4);
			}
		}
		return fileName;
	}

	public static String joinComma(final List<String> list) {
		return Joiner.on(SynStringUtils.COMMA).join(list);
	}

	public static boolean isNotEmptyWhitespace(final CharSequence cs) {
		return StringUtils.isWhitespace(cs) && cs.length() > 0;
	}

	public static String removeStartAndEndNewLines(String string) {
		if (StringUtils.isEmpty(string)) {
			return string;
		}
		while (string.startsWith("\n") || string.startsWith("\r") || string.endsWith("\n") || string.endsWith("\r")) {
			string = StringUtils.strip(string, "\n\r");
		}
		return string;
	}


	// break string by whitespace, then prefix and suffix them with one space character, and join them with \n
	public static String formatWhiteSpace(final String str) {
		if (str == null) {
			return null;
		}
		else if (str.trim().isEmpty()) {
			return "";
		}
		else {
			final String[] splits = str.split("\\s+");

			String result = "";
			for (int i = 0; i < splits.length; i++) {
				result += " " + splits[i] + " \n";
			}

			return result;
		}
	}

	/**
	 * Trim all SPACE, - , and / symbols
	 *
	 * @param input
	 * @return trimmed string
	 */
	public static String removeUnnecessarySymbolsForBankExport(final String input) {
		if (input == null) {
			return null;
		}
		String output = input.replaceAll("-", "");
		output = output.replaceAll("/", "");
		output = output.replaceAll(" ", "");
		return output;
	}

	public static String left(final String text, final int length) {
		if (text.length() <= length) {
			return text;
		}
		return text.substring(0, length);
	}

	public static String right(final String text, final int length) {
		if (text.length() <= length) {
			return text;
		}
		return text.substring(text.length() - length, text.length());
	}


	public static String subSameStr(final String str1, final String str2) {
		final StringBuffer str = new StringBuffer("");

		for (int i = 0; i < str1.length(); ++i) {
			if (str1.charAt(i) != str2.charAt(i)) {
				break;
			}
			str.append(str1.charAt(i));
		}
		return str.toString();
	}


	public static String concatNullTrim(final String separator, final String... chunks) {
		String result = "";
		for (final String chunk : chunks) {
			if (StringUtils.isNotEmpty(result) && StringUtils.isNotEmpty(chunk)) {
				result += separator;
			}
			result += SynStringUtils.nullTrim(chunk);
		}
		return result;
	}

	public static int hashCode(final Object... objects) {
		final StringBuilder sb = new StringBuilder();
		for (final Object s : objects) {
			if (s != null) {
				sb.append(s);
			}
		}
		return sb.toString().hashCode();
	}

	public static String toFormattedString(final String[] idArray) {
		if (idArray == null) {
			return null;
		}
		final StringBuffer buf = new StringBuffer();
		for (int i = 0; i < idArray.length; i++) {
			String temp = SynStringUtils.nullTrim(idArray[i]);
			temp = temp.replace("\"", "\\\\\"");

			temp = "\"" + temp + "\"";
			final String comma = (i >= (idArray.length - 1)) ? SynStringUtils.EMPTY : ",";
			buf.append(temp + comma);
		}
		return buf.toString();
	}
}
