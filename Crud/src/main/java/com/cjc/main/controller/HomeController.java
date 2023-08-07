package com.cjc.main.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.entity.BaseResponse;
import com.cjc.main.entity.Student;
import com.cjc.main.exceptions.StudentNotFound;
import com.cjc.main.service.HomeService;

@RestController
@RequestMapping("/Student")
public class HomeController {

	@Autowired
	HomeService hs;
	
	@PostMapping("/savestudent")
	public ResponseEntity<BaseResponse<Student>> savestudent(@RequestBody Student s) throws StudentNotFound
	{
		
		Student student = hs.savestudent(s);
		
	return new ResponseEntity<BaseResponse<Student>>(new BaseResponse<Student>(201, "Student Added",
			  new Date(), student),HttpStatus.OK);	
	}
}
