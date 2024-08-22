import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    private static SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();

    public static void main(String[] args) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT NEW " + LinkedPurchaseList.class.getSimpleName() + " (s.id, c.id) FROM " +
                PurchaseList.class.getSimpleName() + " p " +
                "join " + Student.class.getSimpleName() + " s " +
                "ON s.name = p. student " +
                "join " + Course.class.getSimpleName() + " c " +
                "ON c.name = p.course";

        List<LinkedPurchaseList> lists = session.createQuery(hql).getResultList();

        for (LinkedPurchaseList list : lists) {
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList(list.getStudentId(), list.getCourseId());
            session.save(linkedPurchaseList);
        }
        System.out.println(lists.size());

        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
