package ru.fintech.qa.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.fintech.qa.homework.utils.BeforeUtils;
import ru.fintech.qa.homework.utils.classes.Animal;
import ru.fintech.qa.homework.utils.db.HibernateSessionCreator;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    @BeforeAll
    public static void createDB() {
        BeforeUtils.createData();
    }


    @Test
    public void insertTest() {

        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();

        /*Animal animal = session.createNativeQuery("select * from Animal where name = 'Пчелка'",
                Animal.class).getResultList().get(0);*/
        Animal animal = session.createNativeQuery("select * from animal where id = 2", Animal.class).getResultList().get(0);
        System.out.println(animal.getName());
        session.close();
    }

    @Test
    public void insertTest2() {
        SessionFactory sessionFactory = HibernateSessionCreator.getSessionFactory();
        Session session = sessionFactory.openSession();
        BigInteger result = (BigInteger) session.createNativeQuery("select count (*) from animal").uniqueResult();

        System.out.println(result);
        BigInteger expected = BigInteger.valueOf(10);

        assertEquals(expected,result);

        session.close();

    }


       // Session session = DBClient.getSessionFactory().openSession();
      // Animal animal = new Animal();
        /*animal.setId();
        animal.setName();
        @Id
        int id = 1;
        @Column(name = "name")
        String name;
        @Column(name = "age")
        int age;
        @Column(name = "type")
        int type;
        @Column(name = "sex")
        int sex;
        @Column(name = "place")
        int place;
        session.save(user);*/


       // System.out.println(new DBHibernateService().getUserByName("Пчелка"));

      //  SessionFactory sessionFactory = DBClient.getSessionFactory();



    }
