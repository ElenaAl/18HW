package ru.fintech.qa.homework.utils.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.fintech.qa.homework.utils.classes.Animal;


public class HibernateSessionCreator {

    private static SessionFactory sessionFactory = null;
    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }

    private static SessionFactory buildSessionFactory(){
        return new Configuration()
                .configure()
                .addAnnotatedClass(Animal.class)
                .buildSessionFactory();

    }

}
