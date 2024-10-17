package br.com.bitlab.application;

import java.util.List;

import br.com.bitlab.entity.Contact;
import br.com.bitlab.repository.impl.ContactRepositoryJDBC;
import br.com.bitlab.repository.interfaces.Repository;

public class Main {
	public static void main(String[] args) {
		try {
			Repository<Contact> repository =  new ContactRepositoryJDBC();
			List<Contact> contacts = repository.list();
			
			
			contacts.forEach(System.out::println);
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}

	}
}
