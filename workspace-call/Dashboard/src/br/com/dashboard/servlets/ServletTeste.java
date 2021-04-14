package br.com.dashboard.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dashboard.dao.TesteDao;
import br.com.dashboard.models.Teste;


@WebServlet("/teste")
public class ServletTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletTeste() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String opcao = request.getParameter("opcao");
			String caminho;
			
			switch(opcao) {
			case "incluir":
				caminho = "/WEB-INF/views/testeCadastro.jsp";break;
			case "listar":
				caminho = "/WEB-INF/views/listaTeste.jsp";break;
			case "alterar":
				caminho = "/WEB-INF/views/editTestes.jsp";
				int id = Integer.parseInt(request.getParameter("id"));
				Teste teste = new TesteDao().buscarTeste(id);				
				if(teste !=null) {
					request.setAttribute("teste", teste);
				}			
				break;
			case "remover":
				caminho = "/WEB-INF/views/listaTeste.jsp";
				int id1 = Integer.parseInt(request.getParameter("id"));
				new TesteDao().apagarTestes(id1);						
				break;	
			default:
				caminho = "/WEB-INF/views/listaTeste.jsp";			
			}
			
			request.getRequestDispatcher(caminho).forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String caminho = "/WEB-INF/views/testeCadastro.jsp";
		
		try {
			String nome = request.getParameter("nome");
			
			Teste teste = new Teste(nome);
			
						
			//verificando se é uma alteracao
			String modo = request.getParameter("modo");
			
			if (modo != null && modo.equals("alteracao")) {
				int id = Integer.parseInt(request.getParameter("id"));
				teste.setId(id);
				new TesteDao().alterarTeste(teste);
				caminho = "/WEB-INF/views/listaTeste.jsp";
			} else {
				new TesteDao().incluirTeste(teste);
				caminho = "/WEB-INF/views/testeCadastro.jsp";				
			}
			
			new TesteDao().apagarTestes(0);
			
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			request.getRequestDispatcher(caminho).forward(request, response);
		}
	}

}
