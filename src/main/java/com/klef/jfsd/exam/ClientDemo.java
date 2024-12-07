package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        // Insert records
        Transaction transaction = session.beginTransaction();
        Client client1 = new Client();
        client1.setName("Suvarshitha");
        client1.setGender("Female");
        client1.setAge(30);
        client1.setLocation("Vijayawada");
        client1.setEmail("Suvarshithae@example.com");
        client1.setMobile("1234567890");

        session.save(client1);

        Client client2 = new Client();
        client2.setName("Jane Smith");
        client2.setGender("Female");
        client2.setAge(28);
        client2.setLocation("Los Angeles");
        client2.setEmail("jane.smith@example.com");
        client2.setMobile("9876543210");

        session.save(client2);
        transaction.commit();

        List<Client> clients = session.createQuery("from Client", Client.class).list();
        for (Client client : clients) {
            System.out.println(client.getId() + " | " + client.getName() + " | " + client.getGender() + " | " +
                    client.getAge() + " | " + client.getLocation() + " | " + client.getEmail() + " | " +
                    client.getMobile());
        }

        session.close();
        factory.close();
    }
}
