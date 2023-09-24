package dio.bootcamp.project.SchoolManagement.controller;

import dio.bootcamp.project.SchoolManagement.entity.Teacher;
import dio.bootcamp.project.SchoolManagement.repository.SchoolClassRepository;
import dio.bootcamp.project.SchoolManagement.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

	@Autowired private TeacherRepository teacherRepo;
	@Autowired private SchoolClassRepository schoolClassRepo;

	@GetMapping("/")
	public ResponseEntity<Iterable<Teacher>> findAll() {
		return ResponseEntity.ok(
			teacherRepo.findAll()
		);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Teacher> findById(@PathVariable Long id) {
		return ResponseEntity.ok(
			teacherRepo.findById(id).get()
		);
	}

	@PostMapping("/")
	public ResponseEntity<Teacher> insert(@RequestBody Teacher teacher) {
		teacherRepo.save(teacher);

		return ResponseEntity.ok(teacher);
	}

	@PutMapping("/")
	public ResponseEntity<Teacher> update(
		@PathVariable Long id,
		@RequestBody Teacher teacher
	) {
		if(teacherRepo.findById(id).isPresent())
			teacherRepo.save(teacher);

		return ResponseEntity.ok(teacher);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Teacher> delete(@PathVariable Long id) {
		teacherRepo.deleteById(id);

		return ResponseEntity.ok().build();
	}
}
