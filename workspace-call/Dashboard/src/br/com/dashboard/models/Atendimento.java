package br.com.dashboard.models;

import java.util.Date;

public class Atendimento {
	
	private int id; 
	private int operador;
	private int chamadas;
	private int tma;
	private int shortc;
	private Date data;
	private String servico;
	

	public Atendimento() {
		
	}
	


	





	public Atendimento(int operador, int chamadas, int tma, int shortc, Date data, String servico) {
		this.operador = operador;
		this.chamadas = chamadas;
		this.tma = tma;
		this.shortc = shortc;
		this.data = data;
		this.servico = servico;
	}









	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getId_operador() {
		return operador;
	}



	public void setId_operador(int operador) {
		this.operador = operador;
	}



	public int getChamadas() {
		return chamadas;
	}



	public void setChamadas(int chamadas) {
		this.chamadas = chamadas;
	}



	public int getTma() {
		return tma;
	}



	public void setTma(int tma) {
		this.tma = tma;
	}



	public int getShortc() {
		return shortc;
	}



	public void setShortc(int shortc) {
		this.shortc = shortc;
	}



	public Date getData() {
		return data;
	}



	public void setData(Date data) {
		this.data = data;
	}



	public String getServico() {
		return servico;
	}



	public void setServico(String servico) {
		this.servico = servico;
	}







	
	
	


}
