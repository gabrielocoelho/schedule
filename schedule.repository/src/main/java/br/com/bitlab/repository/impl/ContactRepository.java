package br.com.bitlab.repository.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.bitlab.entity.Contact;
import br.com.bitlab.repository.interfaces.Repository;

public class ContactRepository implements Repository<Contact> {
	private static final List<Contact> contacts = new ArrayList<>();
	@Override
	public List<Contact> list() {
		
		return contacts;
	}

	@Override
	public void add(Contact contact) {
		contacts.add(contact);
		
	}

	@Override
	public void remove(Contact contact) {
		contacts.remove(contact);
	}

	@Override
	public void update(Contact contact) {
		boolean exists = contacts.contains(contact);
		if(exists) {
			int oldIndexContact = contacts.indexOf(contact);
			contacts.remove(oldIndexContact);
			contacts.add(oldIndexContact, contact);
			
		} else {
			contacts.add(contact);
		}
	}

}
