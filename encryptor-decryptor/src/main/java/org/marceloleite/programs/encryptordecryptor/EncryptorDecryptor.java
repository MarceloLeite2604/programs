package org.marceloleite.programs.encryptordecryptor;

import org.marceloleite.libs.crypt.Crypt;

public class EncryptorDecryptor {

	public void execute(String[] args) {
		EncryptorDecryptorArguments arguments = new EncryptorDecryptorArgumentChecker().check(args);

		System.out.println(encryptDecrypt(arguments));
	}

	private String encryptDecrypt(EncryptorDecryptorArguments arguments) {
		if (arguments.isEncrypt()) {
			return encrypt(arguments);
		} else {
			return decrypt(arguments);
		}
	}

	private String decrypt(EncryptorDecryptorArguments arguments) {
		Crypt crypt = createCrypt(arguments);

		if (arguments.getKey()
				.isPresent()) {
			return crypt.decrypt(arguments.getText(), arguments.getKey()
					.get());
		} else {
			return crypt.decrypt(arguments.getText());
		}
	}

	private String encrypt(EncryptorDecryptorArguments arguments) {
		Crypt crypt = createCrypt(arguments);

		if (arguments.getKey()
				.isPresent()) {
			return crypt.encrypt(arguments.getText(), arguments.getKey()
					.get());
		} else {
			return crypt.encrypt(arguments.getText());
		}
	}

	private Crypt createCrypt(EncryptorDecryptorArguments arguments) {
		return Crypt.builder()
				.cryptographicAlgorythm(arguments.getCryptographicAlgorithm())
				.feedbackMode(arguments.getFeedbackMode())
				.paddingScheme(arguments.getPaddingScheme())
				.keyEnvironmentVariableName(arguments.getKeyEnvironmentVariableName())
				.build();
	}
}
