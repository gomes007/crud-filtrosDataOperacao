package br.com.dashboard.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dashboard.dao.AtendimentoDao;
import br.com.dashboard.dao.PessoasDao;
import br.com.dashboard.dao.TiposServicoDao;
import br.com.dashboard.models.Atendimento;
import br.com.dashboard.models.Pessoa;
import br.com.dashboard.models.TipoServico;


@WebServlet("/atendimento")
public class ServletAtendimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletAtendimento() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//obter a lista de operadores
			List<Pessoa> operadores = new PessoasDao().listarOperadores();
			
			//obter a lista de servicos atendidos
			List<TipoServico> servicos = new TiposServicoDao().listarServicos();
			
			request.setAttribute("listaOperadores", operadores);
			request.setAttribute("listaServicos", servicos);
			
			request.getRequestDispatcher("/WEB-INF/views/cadAtendimento.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			int idOperador = Integer.parseInt(request.getParameter("operador"));
			int chamadas = Integer.parseInt(request.getParameter("chamadas"));
			int tma = Integer.parseInt(request.getParameter("tma"));
			int shortc = Integer.parseInt(request.getParameter("shortc"));
			Date data = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data"));
			String servico = request.getParameter("servico");
			
			Atendimento atendimento = new Atendimento(idOperador, chamadas, tma, shortc, data, servico);
			
			
			
			new AtendimentoDao().incluirAtendimento(atendimento);
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.setAttribute("mensagem", e.getMessage());
		} finally {
			// request.getRequestDispatcher("/WEB-INF/views/cadAtendimento.jsp").forward(request, response);
			doGet(request, response);
		}
		
	}

}
