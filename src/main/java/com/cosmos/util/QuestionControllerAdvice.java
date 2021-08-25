package com.cosmos.util;

import com.cosmos.exception.QuestionError;
import com.cosmos.exception.QuestionNotAvailableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class QuestionControllerAdvice {
    @ExceptionHandler(QuestionNotAvailableException.class)
    public ResponseEntity<QuestionError> errorCreator(QuestionNotAvailableException ex){
        log.error("Question not available: "+ex.getMessage());
        QuestionError QuestionError = new QuestionError(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
        return new ResponseEntity(QuestionError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
