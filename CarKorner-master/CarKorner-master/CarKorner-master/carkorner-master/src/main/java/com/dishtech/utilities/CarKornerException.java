package com.dishtech.utilities;

public class CarKornerException extends Exception {
    /**
     *
     */
    public CarKornerException() {
        super();
    }

    /**
     * @param message
     */
    public CarKornerException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param cause
     */
    public CarKornerException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause
     */
    public CarKornerException(Throwable cause) {
        super(cause);
    }

    /*
     * @see java.lang.Throwable#getMessage()
     */
    public String getMessage() {
        return super.getMessage();
    }
}
