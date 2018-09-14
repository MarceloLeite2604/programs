package org.marceloleite.programs.crypt.keygenerator;

public class KeyGeneratorArguments {

	private String cryptographicAlgorithm;

	public KeyGeneratorArguments(String cryptographicAlgorithm) {
		this.cryptographicAlgorithm = cryptographicAlgorithm;
	}
	
	public String getCryptographicAlgorithm() {
		return cryptographicAlgorithm;
	}
}
