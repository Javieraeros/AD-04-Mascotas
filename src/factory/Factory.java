package factory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import model.*;

public class Factory {
	private static ServiceRegistry serviceRegistry;
	private static final SessionFactory sessionFactory;

	static {
		try {
			Configuration configuration = new Configuration().configure(); // configures
																			// settings
																			// from
																			// hibernate.cfg.xml
			configuration.addAnnotatedClass(Actualizacion.class);
			configuration.addAnnotatedClass(Cliente.class);
			configuration.addAnnotatedClass(Enfermedad.class);
			configuration.addAnnotatedClass(EnfermedadMascota.class);
			configuration.addAnnotatedClass(Mascota.class);
			configuration.addAnnotatedClass(Visita.class);
			StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();

			// If you miss the below line then it will complaing about a missing
			// dialect setting
			serviceRegistryBuilder.applySettings(configuration.getProperties());

			serviceRegistry = serviceRegistryBuilder.build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
