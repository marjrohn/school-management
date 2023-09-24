package dio.bootcamp.project.SchoolManagement.controller;

import dio.bootcamp.project.SchoolManagement.entity.SchoolClass;
import dio.bootcamp.project.SchoolManagement.entity.Teacher;
import dio.bootcamp.project.SchoolManagement.repository.SchoolClassRepository;
import dio.bootcamp.project.SchoolManagement.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/classes")
public class SchoolClassController {

	@Autowired private SchoolClassRepository schoolClassRepo;
	@Autowired private TeacherRepository teacherRepo;

	@GetMapping("/")
	public ResponseEntity<Iterable<SchoolClass>> findAll() {
		return ResponseEntity.ok(
			schoolClassRepo.findAll()
		);
	}

	@GetMapping("/{id}")
	public ResponseEntity<SchoolClass> findById(@PathVariable Long id) {
		return ResponseEntity.ok(
			schoolClassRepo.findById(id).get()
		);
	}

	@PostMapping("/")
	public ResponseEntity<SchoolClass> insert(
		@RequestBody SchoolClass schoolClass
	) {
		Teacher teacher = teacherRepo.findById(
			schoolClass
				.getTeacher()
				.getId()
		).get();

		schoolClass.setTeacher(teacher);
		schoolClassRepo.save(schoolClass);

		return ResponseEntity.ok(schoolClass);
	}

	@PutMapping("/{id}")
	public ResponseEntity<SchoolClass> update(
		@PathVariable Long id,
		@RequestBody SchoolClass schoolClass
	) {
		if (id == schoolClass.getId() && schoolClassRepo.findById(id).isPresent()) {
			Teacher teacher = teacherRepo.findById(
				schoolClass
					.getTeacher()
					.getId()
			).get();

			schoolClass.setTeacher(teacher);
			schoolClassRepo.save(schoolClass);
		}

		return ResponseEntity.ok(schoolClass);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<SchoolClass> delete(@PathVariable Long id) {
		schoolClassRepo.deleteById(id);

		return ResponseEntity.ok().build();
	}
}
