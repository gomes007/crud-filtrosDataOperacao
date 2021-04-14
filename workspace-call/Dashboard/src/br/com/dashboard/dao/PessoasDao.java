package br.com.dashboard.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.dashboard.models.Pessoa;

public class PessoasDao extends Dao {

	//METODO PARA INCLUIR UMA NOVA PESSOA
	public void incluirPessoa(Pessoa pessoa) throws Exception {
		try {
			abrirConexao();
			String sql = "INSERT INTO tb_pessoas(nome, email,cargo,status) VALUES(?,?,?,?)";
			stmt = cn.prepareStatement(sql);
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getEmail());
			stmt.setString(3, pessoa.getCargo());
			stmt.setString(4, pessoa.getStatus());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
	}
	
	
	
	//METODO PARA buscar uma pessoa
	public Pessoa buscarPessoas(int id) throws Exception {
		Pessoa pessoa = null;
		
		try {
			abrirConexao();
			stmt = cn.prepareStatement("select * from tb_pessoas where id = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				pessoa = new Pessoa(
					rs.getString("NOME"),
					rs.getString("EMAIL"),
					rs.getString("CARGO"),
					rs.getString("STATUS"));
					
				pessoa.setId(id);
					
			}
			
		} catch (Exception e) {
			
		} finally {
			fecharConexao();
		}
		return pessoa;
	}
	
	
	
	
	//METODO PARA LISTAR
	public List<Pessoa> listarPessoas() throws Exception{
		List<Pessoa> lista = new ArrayList<>();
		try {
			abrirConexao();
			
			stmt = cn.prepareStatement("SELECT * FROM tb_pessoas");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Pessoa pessoa = new Pessoa(
						rs.getString("NOME"),
						rs.getString("EMAIL"),
						rs.getString("CARGO"),
						rs.getString("STATUS"));
				
			pessoa.setId(rs.getInt("ID")); // PARA USAR NO UPDATE
			
				lista.add(pessoa);
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		return lista;
	}
	
	
	
	//METODO PARA LISTAR
		public List<Pessoa> listarOperadores() throws Exception{
			List<Pessoa> lista = new ArrayList<>();
			try {
				abrirConexao();
				
				stmt = cn.prepareStatement("SELECT * FROM tb_pessoas where cargo = 'OPERADOR'");
				rs = stmt.executeQuery();
				while(rs.next()) {
					Pessoa pessoa = new Pessoa(
							
							rs.getString("NOME"),
							rs.getString("EMAIL"),
							rs.getString("CARGO"),
							rs.getString("STATUS"));
					
					pessoa.setId(rs.getInt("ID"));
					
					lista.add(pessoa);
				}
				
			} catch (Exception e) {
				throw e;
			} finally {
				fecharConexao();
			}
			return lista;
		}
	
		
		//METODO PARA ALTERAR 
				public void alterarPessoa(Pessoa pessoa) throws Exception {
					
					try {
						abrirConexao();
						String sql = "update tb_pessoas set NOME=?,EMAIL=?,CARGO=?,STATUS=? where ID=?";
						stmt = cn.prepareStatement(sql);
						stmt.setString(1, pessoa.getNome());
						stmt.setString(2, pessoa.getEmail());
						stmt.setString(3, pessoa.getCargo());
						stmt.setString(4, pessoa.getStatus());
						stmt.setInt(5, pessoa.getId());
						
						
						stmt.executeUpdate();
						
						
					} catch (Exception e) {
						throw e;
					} finally {
						fecharConexao();
					}			
				}
	
	
	
				//METODO PARA APAGAR REGISTRO
				public void apagarPessoas(int id) throws Exception {
					try {
						abrirConexao();
						stmt = cn.prepareStatement("delete from tb_pessoas where id = ?");
						stmt.setInt(1, id);
						stmt.executeUpdate();
					} catch (Exception e) {
						throw e;
					} finally {
						fecharConexao();
					}
				}
	
}
