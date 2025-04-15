package org.project.utils;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.project.repository.ProductRepository;
import org.project.dto.ProductFilter;

import java.lang.reflect.Proxy;

@Slf4j
public class HibernateRunner {


    public static void main(String[] args) {

        try(SessionFactory sessionFactory = HibernateUtil.buildConfiguration()){
            var session = (Session) Proxy.newProxyInstance(SessionFactory.class.getClassLoader(), new Class[]{Session.class},
                    (proxy, method, args1) -> method.invoke(sessionFactory.getCurrentSession(), args1));
            session.beginTransaction();


            ProductRepository productRepository = new ProductRepository(session);

            productRepository.findListOfProducts(session, ProductFilter.builder()
                            .name("Bike")
                    .build());

            session.getTransaction().commit();
        }
    }
}
