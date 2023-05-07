package service;

import java.util.List;

import domain.Contact;

public interface ContactService {

	public List<Contact> findAll();
	
	public Contact findById(Long id);
	
	public Contact save(Contact contact);	
	
}