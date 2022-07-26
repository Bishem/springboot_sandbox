package fr.diginamic.sandbox.utils.exceptions;

public class ArgumentNullException extends RuntimeException {

	private static final long serialVersionUID = 7276723296821649683L;

	public ArgumentNullException() {
	}

	public ArgumentNullException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ArgumentNullException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ArgumentNullException(final String message) {
		super(message);
	}

	public ArgumentNullException(final Throwable cause) {
		super(cause);
	}

}
