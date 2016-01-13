package com.ipn.mx.utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author JL
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties());

            sessionFactory = configuration.buildSessionFactory(builder.build());

        } catch (HibernateException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}