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

import br.com.dashboard.dao.ConsultasDao;
import br.com.dashboard.viewmodels.AtendimentoPeriodoVM;


@WebServlet("/consulta")
public class ServletConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletConsulta() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			Date dataInicio = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("inicio"));
			Date dataFim = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fim"));				
			String servico = request.getParameter("servico");
			
			if (dataInicio != null && dataFim != null) {							
				
				List<AtendimentoPeriodoVM> atendimentos = new ConsultasDao().listarPeriodo(dataInicio, dataFim, servico);
				
				request.setAttribute("atendimentos", atendimentos);											
			}
			
			
		} catch (Exception e) {
			request.setAttribute("mensagem", e.getMessage());
		} finally {
			request.getRequestDispatcher("/WEB-INF/views/consultas.jsp").forward(request, response);
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
