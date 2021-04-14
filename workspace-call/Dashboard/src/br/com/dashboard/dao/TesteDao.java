package br.com.dashboard.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.dashboard.models.Teste;

public class TesteDao extends Dao {

	//METODO PARA INCLUIR
	public void incluirTeste(Teste teste) throws Exception {
		try {
			abrirConexao();
			String sql = "insert into tb_teste (nome) values(?)";
			stmt = cn.prepareStatement(sql);
			stmt.setString(1, teste.getNome());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
	}
	
	//METODO PARA LISTAR
	public List<Teste> listarTestes() throws Exception {
		List<Teste> lista = new ArrayList<>();
		try {
			abrirConexao();
			stmt = cn.prepareStatement("select * from tb_teste");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Teste teste = new Teste(
				rs.getString("NOME"));
				
				teste.setId(rs.getInt("ID")); // PARA USAR NO UPDATE
				
				lista.add(teste);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		return lista;
	}
	
	
	//METODO PARA buscar um teste
	public Teste buscarTeste(int id) throws Exception {
		Teste teste = null;
		try {
			abrirConexao();
			stmt = cn.prepareStatement("select * from tb_teste where id = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				teste = new Teste(
						rs.getString("NOME"));
				
				teste.setId(id);
			}
		} catch (Exception e) {
			
		} finally {
			fecharConexao();
		}
		return teste;
	}
	
	//METODO PARA ALTERAR
	public void alterarTeste(Teste teste) throws Exception{
		try {
			abrirConexao();
			String sql = "update tb_teste set NOME=? where id = ?";
			stmt = cn.prepareStatement(sql);
			stmt.setString(1, teste.getNome());
			stmt.setInt(2, teste.getId());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
	}
	
	
	//METODO PARA APAGAR REGISTRO
	public void apagarTestes(int id) throws Exception {
		try {
			abrirConexao();
			stmt = cn.prepareStatement("delete from tb_teste where id = ?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		
	}
	
	
}
