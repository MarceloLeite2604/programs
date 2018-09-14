package org.marceloleite.programs.crypt.keygenerator;

import org.marceloleite.libs.crypt.KeyGenerator;

public class CryptKeyGenerator {

	public void generate(String[] args) {
		KeyGeneratorArguments keyGeneratorArguments = new KeyGeneratorArgumentsChecker().check(args);
		String key = new KeyGenerator().generate(keyGeneratorArguments.getCryptographicAlgorithm());
		System.out.println("Cryptiographic algorythm: " + keyGeneratorArguments.getCryptographicAlgorithm());
		System.out.println("Key: " + key);
	}
}
