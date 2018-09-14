package org.marceloleite.programs.crypt.keygenerator;

import org.marceloleite.libraries.argumentsutils.ArgumentsUtils;

public class KeyGeneratorArgumentsChecker {

	private static final String DEFAULT_CRYPTOGRAPHIC_ALGORITHM = "DESede";

	public KeyGeneratorArguments check(String[] args) {
		
		ArgumentsUtils argumentsUtils = new ArgumentsUtils();
		String cryptographicAlgorithm = argumentsUtils.retrieveArgument(args, "-c")
				.orElse(DEFAULT_CRYPTOGRAPHIC_ALGORITHM);

		return new KeyGeneratorArguments(cryptographicAlgorithm);
	}
}
