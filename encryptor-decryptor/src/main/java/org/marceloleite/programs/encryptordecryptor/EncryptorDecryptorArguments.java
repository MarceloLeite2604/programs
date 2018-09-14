package org.marceloleite.programs.encryptordecryptor;

import java.util.Optional;

public class EncryptorDecryptorArguments {

	private String cryptographicAlgorithm;

	private String feedbackMode;

	private String paddingScheme;

	private Optional<String> key;

	private Optional<String> keyEnvironmentVariableName;
	
	private boolean encrypt;

	private String text;

	private EncryptorDecryptorArguments(Builder builder) {
		this.cryptographicAlgorithm = builder.cryptographicAlgorithm;
		this.feedbackMode = builder.feedbackMode;
		this.paddingScheme = builder.paddingScheme;
		this.key = builder.key;
		this.keyEnvironmentVariableName = builder.keyEnvironmentVariableName;
		this.encrypt = builder.encrypt;
		this.text = builder.text;
	}

	public String getCryptographicAlgorithm() {
		return cryptographicAlgorithm;
	}

	public String getFeedbackMode() {
		return feedbackMode;
	}

	public String getPaddingScheme() {
		return paddingScheme;
	}

	public Optional<String> getKey() {
		return key;
	}

	public Optional<String> getKeyEnvironmentVariableName() {
		return keyEnvironmentVariableName;
	}
	
	public boolean isEncrypt() {
		return encrypt;
	}

	public String getText() {
		return text;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String cryptographicAlgorithm;
		private String feedbackMode;
		private String paddingScheme;
		private Optional<String> key = Optional.empty();
		private Optional<String> keyEnvironmentVariableName = Optional.empty();
		private boolean encrypt;
		private String text;

		private Builder() {
		}

		public Builder cryptographicAlgorithm(String cryptographicAlgorithm) {
			this.cryptographicAlgorithm = cryptographicAlgorithm;
			return this;
		}

		public Builder feedbackMode(String feedbackMode) {
			this.feedbackMode = feedbackMode;
			return this;
		}

		public Builder paddingScheme(String paddingScheme) {
			this.paddingScheme = paddingScheme;
			return this;
		}

		public Builder key(Optional<String> key) {
			this.key = key;
			return this;
		}

		public Builder keyEnvironmentVariableName(Optional<String> keyEnvironmentVariableName) {
			this.keyEnvironmentVariableName = keyEnvironmentVariableName;
			return this;
		}
		
		public Builder encrypt(boolean encrypt) {
			this.encrypt = encrypt;
			return this;
		}

		public Builder text(String text) {
			this.text = text;
			return this;
		}

		public EncryptorDecryptorArguments build() {
			return new EncryptorDecryptorArguments(this);
		}
	}
}
