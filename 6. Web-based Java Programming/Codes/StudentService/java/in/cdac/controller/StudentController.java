package in.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.cdac.entity.Book;
import in.cdac.entity.Student;
import in.cdac.service.StdService;

@RestController
public class StudentController {
	@Autowired
	private StdService service;	
	
	@Autowired
	RestTemplateBuilder restBuilder;
	
		
	@PostMapping("/save")
	public Student saveStdDetails(@RequestBody Student std) {
		
		Book bk = restBuilder.build().getForObject("http://localhost:8082/book/2",Book.class);
		System.out.println("---"+bk.toString());
		
		return service.saveStudentDetails(std);
	}
	
	@GetMapping("/student/{id}")
	public Student getSelectedStudent(@PathVariable int id) {
		return null;
	}
	
	@PutMapping("/update")
	public Student updateStdDetails(@RequestBody Student std) {		
		return service.saveStudentDetails(std);
	}
	
	@GetMapping("/all")
	public List<Student> getAllStudent() {
		return null;
	}
}
