package view;

import java.sql.Date;
import java.text.DateFormat;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import factory.Factory;
import model.Actualizacion;
import model.Cliente;
import model.Enfermedad;
import model.EnfermedadMascota;
import model.Mascota;
import model.Visita;

public class Principal {
private static SessionFactory sessionFactory = null;
	
	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		Session session = null;
        try {
            try {
                sessionFactory = Factory.getSessionFactory();
                session = sessionFactory.openSession();
 
                Transaction tx = session.beginTransaction();
                
                List<Actualizacion> tablaActualizacion;
                Query q=session.createQuery("Select a from Actualizacion a");
                tablaActualizacion=q.list();
                for(int i=0;i<tablaActualizacion.size();i++){
                	Actualizacion miAct=tablaActualizacion.get(i);
            		Mascota nuevaMascota=new Mascota();
            		//La mascota tenemos que inserterla o recuperarla
            		//De ahí que nuevaMascota se recupere en caso de que el cçodigo de propietario sea null
                	if(miAct.getCodigoPropietario()!=null){
                		Cliente nuevoCliente=session.get(Cliente.class, miAct.getCodigoPropietario());
                		nuevaMascota.setCodigo(miAct.getCodigoMascota());
                		nuevaMascota.setAlias(miAct.getAlias());
                		nuevaMascota.setCliente(nuevoCliente);
                		nuevaMascota.setRaza(miAct.getRaza());
                		nuevaMascota.setEspecie(miAct.getEspecie());
                		nuevaMascota.setFechaNacimiento(miAct.getFechaNacimiento());
                		nuevaMascota.setFechaFallecimiento(miAct.getFechaFallecimiento());
                		session.save(nuevaMascota);
                	}else{
                		nuevaMascota=session.get(Mascota.class, miAct.getCodigoMascota());
                	}
                	if(miAct.getEnfermedad()!=null){
                		EnfermedadMascota miEM=new EnfermedadMascota();
                		int idEnfermedad=(Integer) session.createQuery("Select e.id from Enfermedad e where nombre='"
                        		+miAct.getEnfermedad()+"'").uniqueResult();
                		Enfermedad miEnfermedad=session.get(Enfermedad.class, idEnfermedad);
                		miEM.setEnfermedad(miEnfermedad);
                		miEM.setMascota(nuevaMascota);
                		miEM.setFechaInicio(new Date(miAct.getFecha().getTime()));
                		session.save(miEM);
                	}
                	
                	Visita miVisita=new Visita();
                	miVisita.setFecha(miAct.getFecha());
                	miVisita.setTemperatura(miAct.getTemperatura());
                	miVisita.setPeso(miAct.getPeso());
                	
                	
                	miVisita.setMascota(nuevaMascota);
                	session.save(miVisita);
                }
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
