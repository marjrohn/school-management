package dio.bootcamp.project.SchoolManagement.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="teacher")
public class Teacher {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable=false)
	private String name;
	private String lastName;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dateOfBirth;

	@Column(nullable=false)
	private String subject;

	/*
	@OneToMany(
		mappedBy="teacher",
		cascade=CascadeType.ALL,
		orphanRemoval=true
	) private List<SchoolClass> schoolClass;
	*/

	public Teacher(
		String name,
		String lastName,
		Date dateOfBirth,
		String subject,
		List<SchoolClass> schoolClass
	) {
		this.name = name;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.subject = subject;
	}

	public Teacher() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
