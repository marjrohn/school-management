package dio.bootcamp.project.SchoolManagement.repository;

import dio.bootcamp.project.SchoolManagement.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
