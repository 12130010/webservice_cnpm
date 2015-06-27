package com.nhuocquy.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nhuocquy.model.Student;
import com.nhuocquy.model.Subject;

@Service
public class StudentService {
	List<Student> listStudent ;
	public StudentService() {
		listStudent = new ArrayList<Student>();
		List<Subject> listSubject = new ArrayList<Subject>();
		Student st = new Student();
		st.setSBD("NLSA0001");
		st.setName("Nguyễn Văn A");
		st.setBirthday(new Date());
		st.setAddress("Tây Ninh");
		st.setSex(true);
		st.setSchoolCode("42.001");
		st.setSchoolName("THPT Nguyễn Chí Thanh");
		st.setSchoolRegisterCode("NLS");
		st.setSchoolRegisterName("Nong Lam University");
		listSubject.add(new Subject("Toán", 10));
		listSubject.add(new Subject("Lý", 9.5));
		listSubject.add(new Subject("Hóa", 9));
		st.setSubjects(listSubject);
		listStudent.add(st);
		//
		st = new Student();
		st.setSBD("NLSA0002");
		st.setName("Trần Thị B");
		st.setBirthday(new Date());
		st.setAddress("Khánh Hòa");
		st.setSex(true);
		st.setSchoolCode("42.002");
		st.setSchoolName("THPT Lý Thường Kiệt");
		st.setSchoolRegisterCode("NLS");
		st.setSchoolRegisterName("Nong Lam University");
		listSubject = new ArrayList<Subject>();
		listSubject.add(new Subject("Toán", 1));
		listSubject.add(new Subject("Lý", 2));
		listSubject.add(new Subject("Hóa", 3));
		st.setSubjects(listSubject);
		listStudent.add(st);
		//
		st = new Student();
		st.setSBD("NLSA0003");
		st.setName("Nguyễn Văn C");
		st.setBirthday(new Date());
		st.setAddress("Tây Ninh");
		st.setSex(true);
		st.setSchoolCode("42.003");
		st.setSchoolName("THPT Nguyễn Trung Trực");
		st.setSchoolRegisterCode("NLS");
		st.setSchoolRegisterName("Nong Lam University");
		listSubject = new ArrayList<Subject>();
		listSubject.add(new Subject("Toán", 4));
		listSubject.add(new Subject("Lý", 5));
		listSubject.add(new Subject("Hóa", 6));
		st.setSubjects(listSubject);
		listStudent.add(st);
	}
	public List<Student> findStudent(String value){
		List<Student> list = new ArrayList<Student>();
		for (Student st : listStudent) {
			if(st.getSBD().equals(value) || st.getName().contains(value) || st.getAddress().contains(value) || st.getSchoolName().contains(value))
				list.add(st);
		}
		return list;
	}
	public Student findBySBD(String sbd){
		for (Student st : listStudent) {
			if(st.getSBD().equals(sbd))
				return st;
		}
		return null;
	}
}
