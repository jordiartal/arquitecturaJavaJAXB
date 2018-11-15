/**
 * 
 */
package com.java.arquitectura.business;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import com.java.arquitectura.domain.Libro;

/**
 * @author Jordi.Artal
 *
 */
public class LibroImpl {

	private final static Logger LOGGER = Logger.getLogger(LibroImpl.class.getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		 * create a POJO and convert it to a xml
		 */
		try {
			Libro bookPojo = new Libro("Odisea 2001", 400);
			JAXBContext contextPojo = JAXBContext.newInstance(bookPojo.getClass()); 
			Marshaller marshaller = contextPojo.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(bookPojo, System.out);
		}
		catch(PropertyException e) {
			LOGGER.log(Level.WARNING, e.toString());
		}
		catch(JAXBException e) {
			LOGGER.log(Level.WARNING, e.toString());
		}
		
		/*
		 * get a xml and convert it to a POJO
		 */
		try {
			JAXBContext contextXml = JAXBContext.newInstance(Libro.class);
			Unmarshaller unmarshaler = contextXml.createUnmarshaller();
			Libro bookXml = (Libro) unmarshaler.unmarshal(new File("src/main/resources/Book.xml"));
			System.out.println("Book Title: "+bookXml.getTitulo());
			System.out.println("Book number of Pages: "+bookXml.getPaginas());
		}
		catch(JAXBException e) {
			LOGGER.log(Level.WARNING, e.toString());
		}
	
	}
	
}