package in.cdac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cdac.entity.Student;
import in.cdac.repo.StudentRepo;

@Service
public class StdService {
	@Autowired
	private StudentRepo repo;
	
	public Student saveStudentDetails(Student std) {
	
		Student newObj = repo.save(std);
		System.out.println(""+ newObj.toString());
		
		//repo.save(std)		
		//repo.findById(1)
		//repo.findAll();
		//repo.delete(std);
		return newObj;
	}	
}
