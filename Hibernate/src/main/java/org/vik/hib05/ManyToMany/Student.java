package org.vik.hib05.ManyToMany;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "STUDENT05")
@Table(name = "STUDENT05")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STUDENT_ID")
	private int studentId;

	@Column(name = "FIRST_NAME")
	private String firstName;
	
	
	@ManyToMany(/*mappedBy="students", */cascade= {CascadeType.ALL})
	@JoinTable(name = "TEACHER_STUDENT", joinColumns = @JoinColumn(name = "TEACHER_ID"), inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
	Collection<Teacher> teachers = new HashSet<Teacher>();

	public Student() {
		super();
	}

	public Student(String firstName) {
		super();
		this.firstName = firstName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public Collection<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Collection<Teacher> teachers) {
		this.teachers = teachers;
	}

	public static Student getStudent() {
		Random random = new Random();
		int randomNum = random.nextInt(99999);
		return new Student("firstName" + randomNum);
	}

}
