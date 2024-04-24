package com.internaldemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internaldemo.entities.Student;
import com.internaldemo.repository.StudentRepo;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentRepo studentRepo;
	
	@PostMapping("/addstudent")
	public Student addStudent(@RequestBody Student student)
	{
		studentRepo.save(student);
		return student;
	}
	
	@GetMapping("/viewstudents")
	public List<Student> viewStudents()
	{
		List<Student> students = (List<Student>) studentRepo.findAll();
		return students;
	}
	
	@DeleteMapping("/deletestudent/{sid}")
	public String deleteStudent(@PathVariable int sid)
	{
		System.out.println("Check Student");
//		studentRepo.deleteById(sid);
//		return sid + " deleted";
		Student s = studentRepo.findById(sid).get();
		System.out.println("Student : " + s);
		if(s!=null)
		{
			studentRepo.delete(s);
			return sid + " id student delete";
		}
		else
		{
			return sid + " id student not found";
		}
	}
	
	@PutMapping("/updatestudent/{sid}")
	public Student updateStudent(@PathVariable int sid,@RequestBody Student std)
	{
		Student s = studentRepo.findById(sid).get();
		s.setName(std.getName());
		s.setCity(std.getCity());
//		s.setLaptop(std.getLaptop());
		studentRepo.save(s);
		return s;
	}
}
