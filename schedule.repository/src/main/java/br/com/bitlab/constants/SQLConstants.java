package br.com.bitlab.constants;

public class SQLConstants {
	public static final String ID_COLUMN = "id";
	public static final String NAME_COLUMN = "name" ;
	public static final String BIRTH_COLUMN = "birth";
	public static final String PHONE_COLUMN = "phone";
	
	public static final String SELECT_ALL = "SELECT * FROM contacts;"; 
	public static final String INSERT_INTO = "INSERT INTO contacts (name, phone, status ,birth) VALUES (?,?,?,?)";
	public static final String UPDATE = "UPDATE contacts status = ? WHERE id = ?";
	
}
