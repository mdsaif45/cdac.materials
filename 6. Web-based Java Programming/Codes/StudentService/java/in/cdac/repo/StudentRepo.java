package in.cdac.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.cdac.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}