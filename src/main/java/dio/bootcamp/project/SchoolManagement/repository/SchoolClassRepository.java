package dio.bootcamp.project.SchoolManagement.repository;

import dio.bootcamp.project.SchoolManagement.entity.SchoolClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository extends CrudRepository<SchoolClass, Long> { }
