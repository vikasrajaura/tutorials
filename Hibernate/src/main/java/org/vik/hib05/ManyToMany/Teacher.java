package org.vik.hib05.ManyToMany;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "TEACHER05")
@Table(name = "TEACHER05")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TEACHER_ID")
	private int teacherId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@ManyToMany // (mappedBy="teachers")
	@JoinTable(name = "TEACHER_STUDENT", joinColumns = @JoinColumn(name = "STUDENT_ID"), inverseJoinColumns = @JoinColumn(name = "TEACHER_ID"))
	Collection<Student> students = new ArrayList<>();

	public Teacher() {
		super();
	}

	public Teacher(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Collection<Student> getStudents() {
		return students;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setStudents(Collection<Student> students) {
		this.students = students;
	}

	public static Teacher getTeacher() {
		Random random = new Random();
		int randomNum = random.nextInt(99999);
		return new Teacher("first name" + randomNum, "last name..");
	}

}
