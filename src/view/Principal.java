package view;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import factory.Factory;
import model.Cliente;

public class Principal {
private static SessionFactory sessionFactory = null;
	
	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		Session session = null;
        try {
            try {
                sessionFactory = Factory.getSessionFactory();
                session = sessionFactory.openSession();
 
                System.out.println("Insertando registro");
                Transaction tx = session.beginTransaction();
                
                Cliente javier=session.get(Cliente.class,106);
                
        		System.out.println("Nombre:"+javier.getNombre());
        		
        		tx.commit();
        		
                System.out.println("Finalizado...");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } finally {
            session.close();
        }

	}
}
