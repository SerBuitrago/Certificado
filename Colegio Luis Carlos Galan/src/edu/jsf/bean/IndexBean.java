package edu.jsf.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

import javax.servlet.http.HttpSession;

import edu.jpa.dao.CertificadoDao;
import edu.jpa.dao.EstudianteDao;
import edu.jpa.dao.EstudianteGradoDao;
import edu.jpa.entity.Certificado;
import edu.jpa.entity.Estudiante;
import edu.jpa.entity.Grado;

/**
 * Implementación Bean IndexBean.
 * 
 * @author Sergio Stives Barrios Buitrago.
 * @phone 3118938189 - 3114794520.
 * @email sergiostivesbb@ufps.edu.co.
 * @version 1.0.0.
 *
 */
@ManagedBean(name = "index")
@ViewScoped
public class IndexBean implements Serializable {

	///////////////////////////////////////////////////////
	/// Atributos /////////////////////////////////////////
	///////////////////////////////////////////////////////
	private static final long serialVersionUID = 1L;

	private final String colegio = "Institución Educativa Colegio Luis Carlos Galán Sarmiento";
	private final String lema = "Educando para la vida, la paz y la democracia";

	private byte tipo;
	private String gradoCertificado;

	private Certificado certificado;

	private Estudiante estudiante;
	public List<Grado> cursados = new ArrayList<Grado>();
	private String documento;

	///////////////////////////////////////////////////////
	/// Metodos ///////////////////////////////////////////
	///////////////////////////////////////////////////////

	/**
	 * Metodo permite consultar a un estudiante.
	 */
	public void consultar() {
		FacesMessage message = null;
		if (documento != null && documento.length() > 0) {
			if (tipo >= 0) {
				if (esNumero(documento)) {
					if (documento.length() < 11) {
						int doc = Integer.parseInt(documento);
						EstudianteDao dao = new EstudianteDao();
						this.estudiante = dao.estudiante(doc, tipo);
						if (estudiante != null && estudiante.getId() != null) {
							System.out.print("Nombre: " + estudiante.getNombre());
							message = new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCCESS", "Estudiante Valido");
						} else {
							message = new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Estudiante NO Valido");
						}
					} else {
						message = new FacesMessage(FacesMessage.SEVERITY_WARN, "INFO",
								"El documento ingresado es muy grande");
					}
				} else {
					message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR",
							"El documento debe ser solo numeros");
				}
			}
		} else {
			message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "INFO", "El documento no debe estar vacio");
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	/**
	 * Metodo que consulta el certificado de un estudiante.
	 * 
	 * @param grado representa el grado.
	 */
	public void ejecutarArchivo(String grado) {
		this.gradoCertificado = grado;
		ejecutarArchivo();
	}

	/**
	 * Metodo que consulta el certificado de un estudiante.
	 */
	public void ejecutarArchivo() {
		FacesMessage message = new FacesMessage();
		if (getGradoCertificado() != null && getGradoCertificado().length() > 0) {

			if (getEstudiante() != null && getEstudiante().getId() != null) {

				CertificadoDao dao = new CertificadoDao();
				certificado = dao.certificado(getEstudiante().getId().getDocumento(), getGradoCertificado());

				if (certificado != null) {

					byte[] datosPDF = certificado.getCertificado();

					if (datosPDF != null) {
						FacesContext facesContext = FacesContext.getCurrentInstance();
						HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
						session.setAttribute("pdfBytesArray", datosPDF);
						message = new FacesMessage(FacesMessage.SEVERITY_INFO, "SUCCESS", "Certificado encontrado");
					} else {
						message = new FacesMessage(FacesMessage.SEVERITY_WARN, "INFO", "Certificado NO encontrado");
					}
				} else {
					message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "",
							"El Estudiante no tiene certificado en ese grado");
				}
			} else {
				message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR", "El estudiante no tiene acesso");
			}
		} else {
			message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR", "El grado del estudiante no valido");
		}

		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	/**
	 * Metodo que consulta todos los grados cursados de un estudiante.
	 * 
	 * @return una cadena con los grados cursados.
	 */
	public String gradosCursados() {
		if (estudiante != null && estudiante.getId() != null && estudiante.getId().getDocumento() > 0) {
			EstudianteGradoDao dao = new EstudianteGradoDao();
			cursados = dao.cursados(estudiante.getId().getDocumento());
			String aux = "";
			int tamanio = cursados.size();
			for (Grado g : cursados) {
				tamanio--;
				aux += g.getGrado() + ((tamanio > 0) ? ", " : "");
			}
			return aux;
		} else {
			return "";
		}
	}

	///////////////////////////////////////////////////////
	/// Metodos Validaciones //////////////////////////////
	///////////////////////////////////////////////////////
	/**
	 * Metodo que consulta si una cadena es de numeros.
	 * 
	 * @param x representa la cadena a verificar.
	 * @return true si es de numeros false si no lo es.
	 */
	public boolean esNumero(String x) {
		x = x.trim();
		boolean esNumero = true, seguir = true;
		char[] n = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		for (short i = 0; i < x.length() && esNumero; i++) {
			seguir = (esNumero) ? true : false;
			for (short j = 0; j < n.length && seguir; j++) {
				if (x.charAt(i) == n[j]) {
					seguir = false;
					esNumero = true;
				} else {
					esNumero = false;
				}
			}
		}
		return esNumero;
	}

	/**
	 * Metodo que consulta si el estudiante no tiene grados.
	 * 
	 * @return true si no tiene false lo contrario.
	 */
	public boolean esVacioGrado() {
		return (cursados == null || cursados.isEmpty()) ? true : false;
	}

	/**
	 * Metodo que consulta si el estudiante no tiene certificado en un grado
	 * selecionado.
	 * 
	 * @return true si no tiene false lo contrario.
	 */
	public boolean esVacioCertificado() {
		return (certificado == null || certificado.getId() == null) ? true : false;

	}

	///////////////////////////////////////////////////////
	/// Metodos Items /////////////////////////////////////
	///////////////////////////////////////////////////////
	/**
	 * Metodo que lista todos los grados del estudiante del colegio.
	 * 
	 * @return una lista select item.
	 */
	public List<SelectItem> grados() {
		List<SelectItem> item = new ArrayList<>();
		SelectItemGroup s = new SelectItemGroup("Buscar");
		SelectItem[] items = new SelectItem[cursados.size()];
		for (int i = 0; i < items.length; i++) {
			String aux = String.valueOf(cursados.get(i).getGrado());
			items[i] = new SelectItem(aux, aux);
		}
		s.setSelectItems(items);
		item.add(s);
		return item;
	}

	/**
	 * Metodo que permite llenar el tipo de documento por buscar.
	 * 
	 * @return una lista select item.
	 */
	public List<SelectItem> tipo() {
		List<SelectItem> item = new ArrayList<>();
		SelectItemGroup s = new SelectItemGroup("Buscar");
		String[] vector = { "Cedula Ciudadania", "Codigo Estudiante", "Tarjeta Identidad" };
		SelectItem[] items = new SelectItem[vector.length];
		for (int i = 0; i < items.length; i++) {
			items[i] = new SelectItem(String.valueOf(i), String.valueOf(vector[i]));
		}
		s.setSelectItems(items);
		item.add(s);
		return item;
	}

	///////////////////////////////////////////////////////
	/// Getter y Setters //////////////////////////////////
	///////////////////////////////////////////////////////

	public String getColegio() {
		return colegio;
	}

	public String getLema() {
		return lema;
	}

	public byte getTipo() {
		return tipo;
	}

	public void setTipo(byte tipo) {
		this.tipo = tipo;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getGradoCertificado() {
		return gradoCertificado;
	}

	public void setGradoCertificado(String gradoCertificado) {
		this.gradoCertificado = gradoCertificado;
	}

	public List<Grado> getCursados() {
		return cursados;
	}

	public void setCursados(List<Grado> cursados) {
		this.cursados = cursados;
	}

	public Certificado getCertificado() {
		return certificado;
	}

	public void setCertificado(Certificado certificado) {
		this.certificado = certificado;
	}
}
