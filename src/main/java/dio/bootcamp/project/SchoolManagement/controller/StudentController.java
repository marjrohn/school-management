package dio.bootcamp.project.SchoolManagement.controller;

import dio.bootcamp.project.SchoolManagement.entity.SchoolClass;
import dio.bootcamp.project.SchoolManagement.entity.Student;
import dio.bootcamp.project.SchoolManagement.repository.SchoolClassRepository;
import dio.bootcamp.project.SchoolManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired private StudentRepository studentRepo;
	@Autowired private SchoolClassRepository schoolClassRepo;

	@GetMapping("/")
	public ResponseEntity<Iterable<Student>> findAll() {
		return ResponseEntity.ok(
			studentRepo.findAll()
		);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> findById(@PathVariable Long id) {
		return ResponseEntity.ok(
			studentRepo.findById(id).get()
		);
	}

	@PostMapping("/")
	public ResponseEntity<Student> insert(@RequestBody Student student) {
		SchoolClass schoolClass = schoolClassRepo.findById(
			student
				.getSchoolClass()
				.getId()
		).get();

		student.setSchoolClass(schoolClass);
		studentRepo.save(student);

		return ResponseEntity.ok(student);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> update(
		@PathVariable Long id,
		@RequestBody Student student
	) {
		if(studentRepo.findById(id).isPresent()) {
			SchoolClass schoolClass = schoolClassRepo.findById(
				student
					.getSchoolClass()
					.getId()
			).get();

			student.setSchoolClass(schoolClass);
			studentRepo.save(student);
		}

		return ResponseEntity.ok(student);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Student> delete(@PathVariable Long id) {
		studentRepo.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
