package com.apolinaro.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apolinaro.cobranca.model.StatusTitulo;
import com.apolinaro.cobranca.model.Titulo;
import com.apolinaro.cobranca.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@Autowired
	private Titulos titulos;
	
	@GetMapping("/novo")
	public ModelAndView novo() {
		return new ModelAndView("CadastroTitulo");
	}
	
	@PostMapping
	public ModelAndView salvar(Titulo titulo) {
		titulos.save(titulo);
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject("mensagem", "Titulo salvo com sucesso!");
		return mv;
	}
	
	@GetMapping
	public String pesquisar() {
		return "PesquisaTitulos";
	}
	
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulos() {
		return Arrays.asList(StatusTitulo.values());

	}

}
