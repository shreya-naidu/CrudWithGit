package com.cjc.main.exceptionresponse;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cjc.main.entity.BaseResponse;
import com.cjc.main.entity.Student;
import com.cjc.main.exceptions.StudentNotFound;

@RestControllerAdvice
public class MyExceptionhandler {

	@ExceptionHandler(value=StudentNotFound.class)
	public ResponseEntity<BaseResponse<Student>>handleStudentNotFound()
	{
		return new ResponseEntity<BaseResponse<Student>>(new BaseResponse<Student>(404, "STUDENT NOT FOUND",
				new Date(), null),HttpStatus.NOT_FOUND);
	}

}
