import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {

            //получение списка PurchaseList
            List<Purchase> purchaseList = session.createQuery("From PurchaseList").list();

            purchaseList.forEach(purchase -> {
                Query queryStudent = session.createQuery("From Students where name = :name");
                queryStudent.setParameter("name", purchase.getStudentName());
                Student student = (Student) queryStudent.getSingleResult();

                Query queryCourse = session.createQuery("From Courses where name = :name");
                queryCourse.setParameter("name", purchase.getCourseName());
                Course course = (Course) queryCourse.getSingleResult();

                LinkedPurchase linkedPurchase = new LinkedPurchase(student, course);

                session.save(linkedPurchase);
            });

        } catch (HibernateException exception) {
            exception.printStackTrace();
        }
        transaction.commit();
        sessionFactory.close();
    }
}
