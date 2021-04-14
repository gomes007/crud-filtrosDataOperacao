package br.com.dashboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Dao {

	private static String conexao = "jdbc:mysql://localhost:3306/db_operacional";
	
	protected Connection cn;
	
	protected PreparedStatement stmt;
	
	protected ResultSet rs;
	
	//METODO PARA ABRIR A CONEXAO
	protected void abrirConexao() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		cn = DriverManager.getConnection(conexao, "root", "123456");		
	}
	
	//metodo para fechar a conexao
	protected void fecharConexao() throws ClassNotFoundException, SQLException {
		if (cn != null && !cn.isClosed()) {
			cn.close();
		}
	}
	
	
}
