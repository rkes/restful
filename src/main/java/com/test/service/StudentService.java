package com.test.service;

import java.util.List;

import com.test.entity.Student;

public interface StudentService {

	
	/**
	 * @return List<Student>
	 */
	public List<Student> findAllStudentByClass(String className, String sort, String by);
	
	/**
	 * @param title
	 * @return List<Student>
	 */
	public List<Student>  findStudentByName(String studentName,  String sort, String by);
	
	/**
	 * @return Integer
	 */
	public Integer totalStudentCount();

}
