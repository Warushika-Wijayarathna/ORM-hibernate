package lk.ijse;

import org.hibernate.Session;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Student;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("S001", "Kamal", "Colombo");

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(student);

        student.setName("Nimal");
        session.update(student);

        session.delete(student);

        student = new Student("S001", "Sunil", "Kandy");
        session.save(student);

        Student student1= session.get(Student.class, "S001");
        System.out.println(student1);



        transaction.commit();

        session.close();
    }
}