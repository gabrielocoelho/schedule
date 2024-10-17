package br.com.bitlab.entity;

import java.sql.Date;
import java.time.LocalDate;

public class Contact {
	private int id;
	private String name;
	private String cpf;
	private String phone;
	private LocalDate birth;
	private boolean status;

	public Contact() {
		this.status = true;
	}

	public Contact(String name, String cpf, String phoneNumber, LocalDate birth, int id) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.phone = phoneNumber;
		this.birth = birth;
		this.id = id;
		this.status = true;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phoneNumber) {
		this.phone = phoneNumber;
	}

	public LocalDate getBirth() {

		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth.toLocalDate();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirthSQL() {

		return Date.valueOf(birth);
	}

	@Override
	public String toString() {
		return this.name;

	}

}
