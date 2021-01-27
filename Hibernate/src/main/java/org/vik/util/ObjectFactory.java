package org.vik.util;

import java.time.LocalDate;

import org.vik.dto.Book;
import org.vik.dto.StudentDetails;
import org.vik.vo.Address;

public class ObjectFactory {
	public static int appender;

	public static StudentDetails getStudent(int appender) {
		StudentDetails student = new StudentDetails();
		student.setFirstName("First" + appender);
		student.setMiddleName("Middle" + appender);
		student.setLastName("Last" + appender);
		student.setDob(LocalDate.of(1989, 02, 17));

		return student;
	}

	public static Address getAddress(int appender) {
		Address address = new Address();
		address.setStreet("street" + appender);
		address.setCity("city" + appender);
		address.setState("state" + appender);
		address.setPincode("pincode" + appender);
		return address;
	}

	public static Book getBook(int appender) {
		Book book1 = new Book();
		book1.setAuthor("Author" + appender);
		book1.setName("Book" + appender);
		book1.setDesc("Desc" + appender);
		book1.setIsbn("isbn" + appender);

		return book1;
	}

}
