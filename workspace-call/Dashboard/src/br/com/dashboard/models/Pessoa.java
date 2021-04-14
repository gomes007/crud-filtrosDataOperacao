package br.com.dashboard.models;

public class Pessoa {

	private int id;
	private String nome;
	private String email;
	private String cargo;
	private String status;
	
	public Pessoa() {
		
	}
	
		
	
	public Pessoa(String nome, String email, String cargo, String status) {
		
		this.setNome(nome);
		this.setEmail(email);
		this.setCargo(cargo);
		this.setStatus(status);
	}







	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
		
	
}
