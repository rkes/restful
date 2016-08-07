package com.test.core;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.test.service.StudentService;

public class Main {
	public static void main(String []args) throws IOException{
		String configLocation="C:\\Users\\Rakesh\\Desktop\\eclipse_workspaces\\restful\\src\\main\\webapp\\WEB-INF\\spring_mvc-servlet.xml";
		ApplicationContext appContext=new FileSystemXmlApplicationContext(configLocation);
	
		StudentService studService=	(StudentService) appContext.getBean("studService");
		
		
		System.out.println(studService.totalStudentCount());
		
	}
}
