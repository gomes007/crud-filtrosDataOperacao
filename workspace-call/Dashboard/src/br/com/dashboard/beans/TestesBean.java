package br.com.dashboard.beans;

import java.util.ArrayList;
import java.util.List;

import br.com.dashboard.dao.TesteDao;
import br.com.dashboard.models.Teste;

public class TestesBean {

	//GETTER PARA RETORNAR A LISTA DE TESTES
	public List<Teste> getListaTeste(){
		try {
			return new TesteDao().listarTestes();
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}
}
