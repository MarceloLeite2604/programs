package org.marceloleite.programs.encryptordecryptor;

import java.util.Optional;

import org.marceloleite.libraries.argumentsutils.ArgumentsUtils;

public class EncryptorDecryptorArgumentChecker {

	private static final String DEFAULT_CRYPTOGRAPHIC_ARGORITHM = "DESede";

	private static final String DEFAULT_PADDING_SCHEME = "PKCS5Padding";

	private static final String DEFAULT_FEEDBACK_MODE = "CBC";

	private ArgumentsUtils argumentsUtils;

	public EncryptorDecryptorArgumentChecker() {
		this.argumentsUtils = new ArgumentsUtils();
	}

	public EncryptorDecryptorArguments check(String[] args) {

		if (args == null || args.length == 0) {
			throw new IllegalArgumentException("No arguments informed.");
		}

		String cryptographicAlgorithm = argumentsUtils.retrieveArgument(args, "-c", DEFAULT_CRYPTOGRAPHIC_ARGORITHM);

		String paddingScheme = argumentsUtils.retrieveArgument(args, "-p", DEFAULT_PADDING_SCHEME);

		String feedbackMode = argumentsUtils.retrieveArgument(args, "-f", DEFAULT_FEEDBACK_MODE);

		String text = args[args.length - 1];

		Optional<String> keyEnvironmentVariableName = argumentsUtils.retrieveArgument(args, "-n");

		Optional<String> key = argumentsUtils.retrieveArgument(args, "-k");

		boolean encrypt = checkEncryptArgument(args);

		return EncryptorDecryptorArguments.builder()
				.cryptographicAlgorithm(cryptographicAlgorithm)
				.feedbackMode(feedbackMode)
				.paddingScheme(paddingScheme)
				.key(key)
				.keyEnvironmentVariableName(keyEnvironmentVariableName)
				.encrypt(encrypt)
				.text(text)
				.build();

	}

	private boolean checkEncryptArgument(String[] args) {

		if (argumentsUtils.checkArgument(args, "-e")) {
			return true;
		} else if (argumentsUtils.checkArgument(args, "-d")) {
			return false;
		}

		throw new IllegalArgumentException("Must inform either encrypt (-e) or decrypt (-d).");
	}

	public static String listParameters() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\nUsage:");
		stringBuilder.append("\n\t{-e|-d} [-c <value>] [-p <value>] [-f <value>] [-k <value> | -n <value>] <text>.");
		stringBuilder.append("\n\nArguments:");
		stringBuilder.append("\n\t-e Encrypt text.");
		stringBuilder.append("\n\t-d Decrypt text.");
		stringBuilder.append("\n\t-c Cryptographic algorithm (default \"" + DEFAULT_CRYPTOGRAPHIC_ARGORITHM + "\").");
		stringBuilder.append("\n\t-p Padding scheme (default \"" + DEFAULT_PADDING_SCHEME + "\").");
		stringBuilder.append("\n\t-f Feedback mode (default \"" + DEFAULT_FEEDBACK_MODE + "\").");
		stringBuilder.append("\n\t-k Encryption key.");
		stringBuilder.append("\n\t-n Environment variable name which contains the encryption key.");
		return stringBuilder.toString();
	}
}
