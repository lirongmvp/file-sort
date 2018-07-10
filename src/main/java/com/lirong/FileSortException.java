package com.lirong;

/**
 * @author LiRong
 */
public class FileSortException extends Exception {
    public FileSortException() {
        super();
    }

    public FileSortException(String message) {
        super(message);
    }

    public FileSortException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileSortException(Throwable cause) {
        super(cause);
    }

    protected FileSortException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
