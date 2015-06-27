package com.nhuocquy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nhuocquy.model.Student;
import com.nhuocquy.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;
	@RequestMapping(value = "/findstudent", produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
	public @ResponseBody  List<Student> findStudent(@RequestParam String value){
		return studentService.findStudent(value); 
	}
	@RequestMapping(value = "/findbysbd", produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
	public @ResponseBody Student findBySBD(@RequestParam String sbd){
		return studentService.findBySBD(sbd);
	}
}
