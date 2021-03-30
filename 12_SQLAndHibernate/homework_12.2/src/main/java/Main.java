import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        //отображение списка курсов и кол-ва студентов по каждому
        List<Course> courseList = (List<Course>) session.createQuery("from Course").list();
        for (Course course : courseList) {
            System.out.println(course.getName() + "\tкол-во студентов: " + course.getStudentsCount() + " человек");
        }

        sessionFactory.close();
    }
}
