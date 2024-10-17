package br.com.bitlab.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.bitlab.factories.ConnectFactoryJDBC;
import br.com.bitlab.constants.SQLConstants;
import br.com.bitlab.entity.Contact;
import br.com.bitlab.repository.interfaces.Repository;

public class ContactRepositoryJDBC implements Repository<Contact> {
	
	@Override
	public List<Contact> list() throws SQLException, IOException {
		
		List<Contact> contacts = new ArrayList<>();
		try (Connection connection = ConnectFactoryJDBC.connection();
			
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(SQLConstants.SELECT_ALL);) {			
			
			while (resultSet.next()) {
				Contact contact = new Contact();
				
				contact.setId(resultSet.getInt(SQLConstants.ID_COLUMN));
				contact.setName(resultSet.getString(SQLConstants.NAME_COLUMN));
				contact.setPhone(resultSet.getString(SQLConstants.PHONE_COLUMN));
				contact.setBirth(resultSet.getDate(SQLConstants.BIRTH_COLUMN));
				contacts.add(contact);
			}
		}

		return contacts;
	}

	@Override
	public void add(Contact contact) throws SQLException, IOException {
	
		try(Connection connection = ConnectFactoryJDBC.connection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQLConstants.INSERT_INTO);){
			preparedStatement.setString(1, contact.getName());
			preparedStatement.setString(2, contact.getPhone());
			preparedStatement.setBoolean(3, contact.getStatus());
			preparedStatement.setDate(4, contact.getBirthSQL());
			preparedStatement.execute();
		}
	}

	@Override
	public void remove(Contact contact) throws SQLException, IOException{
		
		try(Connection connection = ConnectFactoryJDBC.connection();
			PreparedStatement prepareStatement = connection.prepareStatement(SQLConstants.UPDATE);){
			
			contact.setStatus(false);
			
			prepareStatement.setBoolean(1, contact.getStatus());
			prepareStatement.setInt(2, contact.getId());
			prepareStatement.execute();
			
		}
		
		
		

	}

	@Override
	public void update(Contact contact) throws SQLException, IOException {
		try(Connection connection = ConnectFactoryJDBC.connection();
				PreparedStatement prepareStatement = connection.prepareStatement("UPDATE contacts name=?, phone=?  WHERE id = ?");){
				
			
				
				prepareStatement.setString(1, contact.getName());
				prepareStatement.setString(2, contact.getPhone());
				prepareStatement.execute();	
				
			}	
	}

}
