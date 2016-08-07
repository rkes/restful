package com.test.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.test.entity.Student;

@Component("studDao")
public class StudentDaoImpl  extends HibernateSessionDao implements StudentDao{

	@Override
	public List<Student> findAllStudentByClass(String className, String colName, String sortBy) {
		return findStudentsByCriteria(className, colName, sortBy);
	}

	@Override
	public List<Student> findStudentByName(String studentName, String colName, String sortBy) {
		return findStudentsByCriteria(studentName, colName, sortBy);
	}
	@Override
	public Integer totalStudentCount() {
		Object countObj =  getSession().createCriteria(Student.class).setProjection(Projections.rowCount()).uniqueResult();

		if(countObj != null ){
			return	((Long)countObj).intValue();
		}
		return 0;
		}
	
	private List<Student> findStudentsByCriteria(String name, String colName, String sortBy) {
		Criteria crt = getSession().createCriteria(Student.class);
		if(! StringUtils.isEmpty(colName) &&  ! StringUtils.isEmpty(sortBy)){
			if("desc".equalsIgnoreCase(sortBy)){
				crt.addOrder(Order.desc(colName));
			}else{
				crt.addOrder(Order.asc(colName));
			}
		}

		@SuppressWarnings("unchecked")
		List<Student> courses = crt.list();
		return courses;

	}


}
