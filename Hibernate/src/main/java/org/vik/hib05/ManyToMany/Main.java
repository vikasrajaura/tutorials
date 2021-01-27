package org.vik.hib05.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.vik.util.HibernateUtil;

/**
 * @author vr250104
 */
public class Main {

    public static void main(String args[]) {
        Main ob = new Main();
        ob.test();
    }

    public void test() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Student st = Student.getStudent();

        // add Teacher list
        List<Teacher> teachers = new ArrayList<>();
        Teacher t1 = Teacher.getTeacher();
        Teacher t2 = Teacher.getTeacher();
        teachers.add(t1);
        teachers.add(t2);
        st.setTeachers(teachers);

        session.beginTransaction();
        session.save(st);
        System.out.println(st.getStudentId());

        session.getTransaction().commit();
        session.close();

/*        Session session1 = HibernateUtil.getSessionFactory().openSession();
        session1.beginTransaction();
        Student s1 = session1.get(Student.class, st.getStudentId());
        System.out.println("===========");
        s1.setFirstName("This is Rajaura");
        session1.getTransaction().commit();

        session1.close();
*/
    }

}
