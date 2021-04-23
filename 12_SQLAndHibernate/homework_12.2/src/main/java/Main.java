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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        //создаем список студентов
        List<Student> students = new LinkedList<>();

        try {

            //получение списка PurchaseList
            Connection connection = ConnectionDB.getConnectionToDB();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT student_name " +
                                                                "FROM PurchaseList " +
                                                                "group by student_name");

            //выполняем поиск студента по имени из PurchaseList
            while (resultSet.next()) {
                String studentName = resultSet.getString("student_name");
                String hql = "from " + Student.class.getSimpleName() + " where name = \'" + studentName + "\'";

                //найденного студента добавляем в список студентов
                students.addAll(session.createQuery(hql).getResultList());
            }

            //перебираем список студентов
            Transaction transaction = session.beginTransaction();
            for (Student student : students) {
                System.out.println("student id: " + student.getId() + "\tstudent name: " + student.getName());
                //получаем список курсов каждого студента
                List<Course> courses = student.getCourses();
                for (Course course : courses) {
                    System.out.println("course id: " + course.getId() + "\tcourse name: " + course.getName());
                    //добавляем id студента и id курса в LinkedPurchaseList
                    LinkedPurchase linkedPurchase = new LinkedPurchase();
                    linkedPurchase.setId(new LinkedPurchaseKey(student.getId(), course.getId()));
                    linkedPurchase.setStudent(student);
                    linkedPurchase.setCourse(course);

                    //записываем добавленные данные в таблицу в БД
                    session.save(linkedPurchase);
                }
            }
            transaction.commit();

        } catch (HibernateException | SQLException exception) {
            exception.printStackTrace();
        }
        sessionFactory.close();
    }
}
