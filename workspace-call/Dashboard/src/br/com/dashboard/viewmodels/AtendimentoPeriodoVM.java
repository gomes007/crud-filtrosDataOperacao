package br.com.dashboard.viewmodels;

import java.util.Date;

public class AtendimentoPeriodoVM {

	private int idOperador;
	private String nomeOperador;
	private String nomeSupervisor;
	private int chamadas;
	private int tma;
	private int shortc;
	private Date data;
	private String servico;
	
	
	
	
	public int getIdOperador() {
		return idOperador;
	}
	public void setIdOperador(int idOperador) {
		this.idOperador = idOperador;
	}
	public String getNomeOperador() {
		return nomeOperador;
	}
	public void setNomeOperador(String nomeOperador) {
		this.nomeOperador = nomeOperador;
	}
	public String getNomeSupervisor() {
		return nomeSupervisor;
	}
	public void setNomeSupervisor(String nomeSupervisor) {
		this.nomeSupervisor = nomeSupervisor;
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
