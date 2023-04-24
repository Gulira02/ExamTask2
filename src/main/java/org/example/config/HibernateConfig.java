package org.example.config;

import jakarta.persistence.EntityManagerFactory;
import org.example.config.many_to_Many.Instructor;
import org.example.config.many_to_Many.Student;
import org.example.config.on_toMany_Manyto_one.Auther;
import org.example.config.on_toMany_Manyto_one.Book;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateConfig {
    public static EntityManagerFactory getEntityManager() {
        try {
            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "org.postgresql.Driver");
            properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
            properties.put(Environment.USER, "postgres");
            properties.put(Environment.PASS, "postgres");
            properties.put(Environment.HBM2DDL_AUTO, "create");
            properties.put(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
            properties.put(Environment.SHOW_SQL, "true");
            properties.put(Environment.FORMAT_SQL, "true");

            Configuration configuration = new Configuration();
            configuration.addProperties(properties);
            configuration.addAnnotatedClass(Auther.class);
            configuration.addAnnotatedClass(Book.class);
            System.out.println("Successfully connected!");
//В данном случае,метод unwrap() преобразует объект типа SessionFactory в объект типа EntityManagerFactory.
            return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
