package com.test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.entity.Student;
import com.test.service.StudentService;

@Controller
@RequestMapping("Rest")
public class StudentController {
	
	@Autowired
	StudentService studDaoService;
	
	@ResponseBody
	@RequestMapping(value={"/student"}, method=RequestMethod.GET,produces="application/json" )
	public ResponseEntity<List<Student>> fetchAllStudentByName(@RequestParam(required=false) String studentName,@RequestParam(required=false) String sortBy){
		
		List<Student> studentList = studDaoService.findStudentByName(studentName, "name", sortBy);
		
		if(studentList==null){
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value={"/class"}, method=RequestMethod.GET,produces="application/json" )
	public ResponseEntity<List<Student>> findAllStudentByClass(@RequestParam(required=false) String className,@RequestParam(required=false) String sortBy){
		
		List<Student> studentList = studDaoService.findStudentByName(className, "name", sortBy);
		
		if(studentList==null){
			return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
	}
	
	
	@ResponseBody
	@RequestMapping(value={"/cnt"}, method=RequestMethod.GET,produces="application/json" )
	public ResponseEntity<Integer> fetchStudentCount(){
		
		return new ResponseEntity<Integer>(studDaoService.totalStudentCount(), HttpStatus.OK);
	}
}
