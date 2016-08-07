package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.StudentDao;
import com.test.entity.Student;

@Service
@Transactional
@Component("studService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Student> findAllStudentByClass(String className, String colName, String sortBy) {
		return studentDao.findAllStudentByClass(className, colName, sortBy);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Student> findStudentByName(String studentName, String colName, String sortBy) {
		return studentDao.findStudentByName(studentName, colName, sortBy);
	}

	@Override
	@Transactional(readOnly=true)
	public Integer totalStudentCount() {
		return studentDao.totalStudentCount();
	}

}
