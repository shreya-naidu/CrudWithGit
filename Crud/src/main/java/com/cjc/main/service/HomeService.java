package com.cjc.main.service;

import com.cjc.main.entity.Student;
import com.cjc.main.exceptions.StudentNotFound;

public interface HomeService {

	Student savestudent(Student s) throws StudentNotFound;

	Iterable<Student> getAllData(int pageNumber);

	void deletestudent(int id);

}
