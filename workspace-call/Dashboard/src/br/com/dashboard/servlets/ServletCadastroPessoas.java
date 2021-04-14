package br.com.dashboard.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dashboard.dao.PessoasDao;
import br.com.dashboard.models.Pessoa;


@WebServlet("/cadpessoas")
public class ServletCadastroPessoas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletCadastroPessoas() {
        super();
       
    }

    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String opcao = request.getParameter("opcao");
			String caminho;		
			
			String[] cargos = {"GERENTE", "COORDENADOR", "SUPERVISOR", "OPERADOR"}; //para editar ou update
			String[] status = {"ATIVO", "FERIAS", "DESLIGADO"};
			
			switch (opcao) {
			case "incluir": 
				caminho = "/WEB-INF/views/cadPessoas.jsp";break;
			case "alterar":
				caminho = "/WEB-INF/views/editPessoas.jsp";
				int id = Integer.parseInt(request.getParameter("id"));
				Pessoa pessoa = new PessoasDao().buscarPessoas(id);				
				if(pessoa !=null) {
					request.setAttribute("pessoa", pessoa);
				}
				request.setAttribute("cargos", cargos); //para editar ou update
				request.setAttribute("status", status);				
				break;
			case "listar": 
				caminho = "/WEB-INF/views/listaPessoas2.jsp";break;
			case "remover":
				caminho = "/WEB-INF/views/listaPessoas2.jsp";
				int id1 = Integer.parseInt(request.getParameter("id"));
				new PessoasDao().apagarPessoas(id1);						
				break;	
			default:
				caminho = "/WEB-INF/views/cadPessoas.jsp";
}
			
			request.getRequestDispatcher(caminho).forward(request, response);
		} catch (Exception e) {			
			e.printStackTrace();
		}

	}		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String caminho = "/WEB-INF/views/cadPessoas.jsp";
		
		try {
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String cargo = request.getParameter("cargo");
			String status = request.getParameter("status");				
			
			Pessoa pessoa = new Pessoa(nome,email,cargo,status);	
			
			//verificando se é uma alteracao
			String modo = request.getParameter("modo");
						
			if (modo != null && modo.equals("alteracao")) {
				int id = Integer.parseInt(request.getParameter("id"));
				pessoa.setId(id);				
				new PessoasDao().alterarPessoa(pessoa);
				caminho = "/WEB-INF/views/listaPessoas2.jsp";
			} else {
				new PessoasDao().incluirPessoa(pessoa);
				caminho = "/WEB-INF/views/cadPessoas.jsp";
				request.setAttribute("mensagem", nome + "incluido com sucesso!");
			}
			
			
			
			
													
			
		} catch (Exception e) {
			request.setAttribute("mensagem", e.getMessage());
		} finally {
			request.getRequestDispatcher(caminho).forward(request, response);
		}
		
		
	}

}
