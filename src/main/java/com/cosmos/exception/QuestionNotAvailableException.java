package com.cosmos.exception;

public class QuestionNotAvailableException extends RuntimeException {
    public QuestionNotAvailableException() {
        super();
    }

    public QuestionNotAvailableException(String Question_is_available) {
        super(Question_is_available);
    }

    public QuestionNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionNotAvailableException(Throwable cause) {
        super(cause);
    }

    protected QuestionNotAvailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
