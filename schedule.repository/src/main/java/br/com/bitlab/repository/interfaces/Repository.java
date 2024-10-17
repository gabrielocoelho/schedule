package br.com.bitlab.repository.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
	List<T> list() throws SQLException, IOException;
	void add(T t) throws SQLException, IOException;
	void remove(T t) throws SQLException, IOException;
	void update(T t) throws SQLException, IOException; 

}
