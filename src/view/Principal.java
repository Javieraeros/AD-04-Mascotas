package view;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import factory.Factory;
import model.Cliente;
import model.Mascota;

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
                
                Cliente javier=session.get(Cliente.class,105);
                
        		System.out.println("Nombre: "+javier.getNombre());

        		Mascota[] misMascotas=new Mascota[javier.getMascotas().size()];
        		javier.getMascotas().toArray(misMascotas);
        		System.out.println("Mascota 1: "+misMascotas[0].getAlias());
        		System.out.println("Mascota 2: "+misMascotas[1].getAlias());
        		
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
