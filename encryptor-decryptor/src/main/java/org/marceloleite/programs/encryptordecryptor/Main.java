package org.marceloleite.programs.encryptordecryptor;

public class Main {

	public static void main(String[] args) {

		try {
		new EncryptorDecryptor().execute(args);
		} catch(IllegalArgumentException exception) {
			System.err.println(exception.getMessage());
			System.err.println(EncryptorDecryptorArgumentChecker.listParameters());
			
		}
		
	}

	

	

}
