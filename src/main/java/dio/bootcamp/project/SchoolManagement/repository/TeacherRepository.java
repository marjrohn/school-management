package dio.bootcamp.project.SchoolManagement.repository;

import dio.bootcamp.project.SchoolManagement.entity.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> { }
