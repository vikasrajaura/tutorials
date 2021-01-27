package org.vik.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TEACHER")
public class Teacher {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "TEACHER_ID")
	private int teacherId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@ManyToMany//(mappedBy="teachers")
	@JoinTable(name = "TEACHER_STUDENT", joinColumns = @JoinColumn(name = "STUDENT_ID"), inverseJoinColumns = @JoinColumn(name = "TEACHER_ID"))
	Collection<StudentDetails> students = new ArrayList<>();

	public int getTeacherId() {
		return teacherId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Collection<StudentDetails> getStudents() {
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

	public void setStudents(Collection<StudentDetails> students) {
		this.students = students;
	}

}
