package com.cjc.main.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<BaseResponse<Student>> savestudent(@RequestBody Student s) throws StudentNotFound {

		Student student = hs.savestudent(s);

		return new ResponseEntity<BaseResponse<Student>>(
				new BaseResponse<Student>(201, "Student Added", new Date(), student), HttpStatus.OK);
	}

	@GetMapping("/getalldata/{pageNumber}")
	public ResponseEntity<BaseResponse<Iterable<Student>>> getallData(@PathVariable int pageNumber) {

		Iterable<Student> gd=hs.getAllData(pageNumber);
		return new ResponseEntity<BaseResponse<Iterable<Student>>>
		(new BaseResponse<Iterable<Student>>(200, "Data Found!!", new Date(), gd),HttpStatus.OK);

	}
	@DeleteMapping("/deletestudent/{id}")
	public ResponseEntity<BaseResponse<Student>> deletestudent(@PathVariable int id)
	{
		
		hs.deletestudent(id);
		
		return new ResponseEntity<BaseResponse<Student>>(new BaseResponse<Student>(201, "DELETE SUCCESS",
						new Date(), null),HttpStatus.OK);
				
	}

}
