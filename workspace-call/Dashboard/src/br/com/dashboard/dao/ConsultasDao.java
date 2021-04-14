package br.com.dashboard.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.dashboard.viewmodels.AtendimentoPeriodoVM;
import br.com.dashboard.viewmodels.ChamadasPorDataVM;

public class ConsultasDao extends Dao {

	
	String sql = "SELECT A.*, P.NOME\r\n"
			+ "FROM tb_chamadas A, tb_pessoas P, tb_supervisor_operador S\r\n"
			+ "WHERE A.ID_OPERADOR = S.ID_OPERADOR\r\n"
			+ "AND S.ID_OPERADOR = P.ID\r\n";
	
	
	private AtendimentoPeriodoVM buscar(ResultSet rs) throws Exception {
		AtendimentoPeriodoVM vm = new AtendimentoPeriodoVM();
		vm.setNomeOperador(rs.getString("NOME"));
		vm.setIdOperador(rs.getInt("ID_OPERADOR"));
		vm.setChamadas(rs.getInt("CHAMADAS_ATENDIDAS"));
		vm.setTma(rs.getInt("TMA"));
		vm.setShortc(rs.getInt("SHORT_CALL"));
		vm.setData(rs.getDate("DATA_ATENDIMENTO"));
		vm.setServico(rs.getString("SERVICO_ATENDIDO"));
		return vm;
	}
	
	
	public List<AtendimentoPeriodoVM> listarPeriodo(Date inicio, Date fim, String servico) throws Exception {
		List<AtendimentoPeriodoVM> lista = new ArrayList<>();
		try {
			abrirConexao();
			
			String filtro = "and A.DATA_ATENDIMENTO between ? and ? \r\n";
			if (servico != null) {
				if (servico.equals("PRE") || servico.equals("POS") || servico.equals("RET")) {
					filtro += " and SERVICO_ATENDIDO = ?";
				}
			}
			
			stmt =cn.prepareStatement(sql + filtro);
			stmt.setDate(1, new java.sql.Date(inicio.getTime()));
			stmt.setDate(2, new java.sql.Date(fim.getTime()));
			if (servico != null) {
				if (servico.equals("PRE") || servico.equals("POS") || servico.equals("RET")) {
					stmt.setString(3, servico);
				}
			}
			
			rs = stmt.executeQuery();
			
			while (rs.next()) {			
				lista.add(buscar(rs));
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		return lista;
	}
	
	public List<ChamadasPorDataVM> listarChamadas(Date inicio, Date fim) throws Exception{
		List<ChamadasPorDataVM> lista = new ArrayList<>();
		
		try {
			abrirConexao();
			String sql = "SELECT SUM(A.CHAMADAS_ATENDIDAS) AS CHAMADAS, A.DATA_ATENDIMENTO AS DATA \r\n"
					+ "FROM tb_chamadas A, tb_pessoas P, tb_supervisor_operador S\r\n"
					+ "WHERE A.ID_OPERADOR = S.ID_OPERADOR\r\n"
					+ "AND S.ID_OPERADOR = P.ID\r\n"
					+ "AND A.DATA_ATENDIMENTO BETWEEN ? AND ? \r\n"
					+ "AND SERVICO_ATENDIDO LIKE '%%'\r\n"
					+ "GROUP BY A.DATA_ATENDIMENTO;";
			
			stmt = cn.prepareStatement(sql);
			stmt.setDate(1, new java.sql.Date(inicio.getTime()));
			stmt.setDate(2, new java.sql.Date(fim.getTime()));
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				ChamadasPorDataVM chamadas = new ChamadasPorDataVM();
				chamadas.setChamadas(rs.getInt("CHAMADAS"));							
				chamadas.setData(new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("DATA")));
				
				lista.add(chamadas);
			}
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			fecharConexao();
		}
		return lista;
	}
	
}
