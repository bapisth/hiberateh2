import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by hp on 22-07-2017.
 */
public class App {
    public static void main(String[] args) {
        Person person = new Person();
        person.setFirstName("Hemendra");
        person.setLastName("Sethi");
        person.setMobile("9090123456");

        SessionFactory sessionFactory = buildSessionFactory(Person.class);
        Session session = sessionFactory.openSession();
        session.save(person);

        Person person1 = session.get(Person.class, 1);

        System.out.println("--------------------------");
        System.out.println("First Name = "+ person1.getFirstName());
        System.out.println("--------------------------");

        session.close();
        sessionFactory.close();

    }

    private static SessionFactory buildSessionFactory(Class clazz) {
        return new Configuration()
                .configure()
                .addAnnotatedClass(clazz)
                .buildSessionFactory();
    }
}
