package com.zara.zaratest.exception;

import com.zara.zaratest.exception.domain.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = { Exception.class } )
    public ResponseEntity<ErrorMessage> handleAnyException(Exception exception) {
        String errorMessageDescription = getLocalizedMessage(exception);
        ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), errorMessageDescription);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = { SQLException.class } )
    public ResponseEntity<ErrorMessage> handlePriceServiceException(PriceServiceException exception) {
        String errorMessageDescription = getLocalizedMessage(exception);
        ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), errorMessageDescription);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String getLocalizedMessage(final Exception exception) {
        return Optional.ofNullable(exception.getLocalizedMessage())
                .orElse(exception.toString());
    }
}
