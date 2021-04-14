package br.com.dashboard.beans;

import java.util.ArrayList;
import java.util.List;

import br.com.dashboard.dao.PessoasDao;
import br.com.dashboard.models.Pessoa;

public class PessoasBean {

	//GETTER PARA RETORNAR A LISTA DE PESSOAS
	public List<Pessoa> getListaPessoa(){ //listaPessoa fica como nome padrao para invocar o metodo. primeira letra minuscula e ignora o get.
		
		try {
			return new PessoasDao().listarPessoas();
		} catch (Exception e) {
			return new ArrayList<>();
		}
		
		
	}
	
}
