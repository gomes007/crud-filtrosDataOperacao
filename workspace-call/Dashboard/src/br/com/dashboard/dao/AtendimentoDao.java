package br.com.dashboard.dao;

import java.sql.SQLException;

import br.com.dashboard.models.Atendimento;

public class AtendimentoDao extends Dao {

	//METODO PARA INCLUIR ATENDIMENTO
	public void incluirAtendimento(Atendimento atendimento) throws ClassNotFoundException, SQLException {
		
		try {
			abrirConexao();
			String sql = "insert into tb_chamadas(id_operador,chamadas_atendidas,tma,short_call,data_atendimento,servico_atendido) values(?,?,?,?,?,?)";
			stmt= cn.prepareStatement(sql);
			stmt.setInt(1, atendimento.getId_operador());
			stmt.setInt(2, atendimento.getChamadas());
			stmt.setInt(3, atendimento.getTma());
			stmt.setInt(4, atendimento.getShortc());
			stmt.setDate(5, new java.sql.Date(atendimento.getData().getTime()));
			stmt.setString(6, atendimento.getServico());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}

		
		
	}
	
	
}
