package com.cjc.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.main.entity.Student;

@Repository
public interface HomeRepository extends JpaRepository<Student, Integer>{

}
