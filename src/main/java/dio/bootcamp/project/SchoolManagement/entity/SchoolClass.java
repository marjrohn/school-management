package dio.bootcamp.project.SchoolManagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name="school_class")
public class SchoolClass {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "class_name", nullable = false)
	private String className;

	@ManyToOne
	private Teacher teacher;

	/*
	@OneToMany(
		mappedBy = "schoolClass",
		cascade = CascadeType.ALL,
		orphanRemoval = true
	)
	private List<Student> students;
	*/

	public SchoolClass() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
