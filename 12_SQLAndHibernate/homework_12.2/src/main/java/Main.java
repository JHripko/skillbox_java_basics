import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> query = builder.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
        query.select(root);
        List<Student> studentList = session.createQuery(query).getResultList();
        for (Student student : studentList) {
            List<Course> courseList = student.getCourses();

            for (Course course : courseList) {
                Subscription subscription = session.get(Subscription.class, new SubscriptionKey(student, course));
                System.out.println("student_id: " + subscription.getStudent().getId()
                            + "\tcourse_id: " + subscription.getCourse().getId()
                            + "\tsubscription_date: " + subscription.getSubscriptionDate());
            }
        }

        transaction.commit();
        sessionFactory.close();
    }
}
