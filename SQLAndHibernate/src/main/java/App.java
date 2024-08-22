
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.source.spi.SingularAttributeSourceToOne;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.lang.management.MemoryManagerMXBean;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class App {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        String hql = "select distinct courseName from " + PurchaseList.class.getSimpleName();
        List<String> listAllCourses = session.createQuery(hql).getResultList();
        System.out.println(listAllCourses.size());

        for (int i = 0; i < listAllCourses.size(); i++) {
            hql = "select count(*) from PurchaseList where courseName like '" + listAllCourses.get(i) + "'";

            var allCount = session.createQuery(hql).getResultList();
            hql = "select (Month(Max(subscriptionDate)) - Month(Min(subscriptionDate)) + 1) from PurchaseList where courseName like '" + listAllCourses.get(i) + "'";
            var rande = session.createQuery(hql).getResultList();

            Long allCountLong = (Long) allCount.getFirst();
            Integer rangeInteger = (Integer) rande.getFirst();
            double parseAllCountLong = allCountLong;
            double parseAll = parseAllCountLong / rangeInteger;
            System.out.println(listAllCourses.get(i) + " - " + parseAll);
        }



    }
}


