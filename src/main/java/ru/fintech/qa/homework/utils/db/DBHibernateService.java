package ru.fintech.qa.homework.utils.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.fintech.qa.homework.utils.classes.Animal;

public class DBHibernateService {
    public Animal getUserByName(String name){
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();

        Session session = sessionFactory.openSession();

        return session.createNativeQuery("select * from users where name = '"+name+"'",
                Animal.class).getResultList().get(0);

    }

}
