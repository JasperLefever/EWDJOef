package com.springboot.restExample1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import exceptions.DuplicateEmployeeException;
import exceptions.EmployeeNotFoundException;

@RestControllerAdvice
class EmployeeErrorAdvice {

  @ResponseBody
  @ExceptionHandler(EmployeeNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String employeeNotFoundHandler(EmployeeNotFoundException ex) {
    return ex.getMessage();
  }
  
  @ResponseBody
  @ExceptionHandler(DuplicateEmployeeException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  String duplicateEmployeeHandler(DuplicateEmployeeException ex) {
    return ex.getMessage();
  }
}
