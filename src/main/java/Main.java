import entities.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person(1,"Anton");
        Person person2 = new Person(2,"Sergey");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        //пишем данные в бд
        session.beginTransaction();
        session.save(person1);
        session.save(person2);
        session.getTransaction().commit();

        //получаем данные из бд
        session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from Person").list();

        for (Person person : (List<Person>)result) {
            System.out.println(person.getFirstName());
        }
        session.getTransaction().commit();
        session.close();
    }
}
