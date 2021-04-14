package br.com.dashboard.dao;

import java.util.ArrayList;
import java.util.List;


import br.com.dashboard.models.TipoServico;

public class TiposServicoDao extends Dao {

	//METODO PARA LISTAR
		public List<TipoServico> listarServicos() throws Exception{
			List<TipoServico> lista = new ArrayList<>();
			try {
				abrirConexao();
				
				stmt = cn.prepareStatement("SELECT * FROM tb_servicos_atendidos");
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					TipoServico tipo = new TipoServico();
					tipo.setId(rs.getInt("ID"));
					tipo.setTipo(rs.getString("TIPO_SERVICO"));
					tipo.setValor(rs.getDouble("VALOR_SERVICO"));
					
					lista.add(tipo);
				}
				
			} catch (Exception e) {
				throw e;
			} finally {
				fecharConexao();
			}
			return lista;
		}
	
	
}
