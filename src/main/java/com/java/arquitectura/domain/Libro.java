/**
 * 
 */
package com.java.arquitectura.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jordi.Artal
 *
 */
@XmlRootElement
public class Libro {

	private String titulo;
	private int paginas;
	
	

	public Libro() {
		super();
	}

	public Libro(String titulo, int paginas) {
		super();
		this.titulo = titulo;
		this.paginas = paginas;
	}

	/**
	 * @return the titulo
	 */
	@XmlElement(name="tituloLibro")
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the paginas
	 */
	@XmlElement(name="numeroPaginas")
	public int getPaginas() {
		return paginas;
	}

	/**
	 * @param paginas
	 *            the paginas to set
	 */
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + paginas;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (paginas != other.paginas)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

}
