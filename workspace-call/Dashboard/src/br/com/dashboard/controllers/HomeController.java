package br.com.dashboard.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.dashboard.dao.ConsultasDao;
import br.com.dashboard.dao.PessoasDao;
import br.com.dashboard.models.Pessoa;
import br.com.dashboard.viewmodels.ChamadasPorDataVM;

@Controller
public class HomeController {

	@CrossOrigin
	@RequestMapping("/wspessoas")
	@ResponseBody
	public List<Pessoa> listarPessoa(){
		try {
			return new PessoasDao().listarPessoas();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Pessoa>();
		}
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/wschamadas/{di}/df/{df}", method = RequestMethod.GET)
	@ResponseBody
	public List<ChamadasPorDataVM> listarChamadas(@PathVariable("di") String di, @PathVariable("df") String df){
				
		
		try {
			Date inicio = new SimpleDateFormat("yyyy-MM-dd").parse(di);
			Date fim = new SimpleDateFormat("yyyy-MM-dd").parse(df);
			
			return new ConsultasDao().listarChamadas(inicio, fim);
		} catch (Exception e) {
			return new ArrayList<ChamadasPorDataVM>();
		}
	}
	
	
}
