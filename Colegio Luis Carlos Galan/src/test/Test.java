package test;


import edu.jpa.dao.*;
import edu.jpa.entity.*;


public class Test {
	public static void main(String[] arg) {

		/*
		 * TrabajadorDao daoT= new TrabajadorDao(); Trabajador t=daoT.find(60358816);
		 * System.out.print("Trabajador: "+t);
		 * System.out.print("Profesor: "+t.getProfesor().getFechaIngreso());
		 * System.out.print("Rector: "+t.getRector());
		 */
		
		/*TecnicaDao daoTe= new TecnicaDao();
		Tecnica te= daoTe.find("Contabilidad");
		System.out.print("Materias" + te.materias());*/
		
		/*AsignaturaDao daoAs= new AsignaturaDao();
		Asignatura as= daoAs.find((byte)5);
		System.out.print("Profesores" + as.profesores());*/
		
		/*
		EstudianteGradoDao dao= new EstudianteGradoDao();
		System.out.print("Certificado: " + dao.certificado(1010058716,"8-A"));
		*/
		
		 CertificadoDao daoCf= new CertificadoDao();
		 Certificado c=daoCf.certificado(1010058716,"9-B");
		 System.out.print("Certificado 1: " + c);
		
		 c=daoCf.certificado(1010058716,"8-A");
		 System.out.print("Certificado 2: " + c);

	}
}
