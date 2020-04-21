package br.com.caelum.ingresso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.ingresso.email.EmailNovoUsuario;
import br.com.caelum.ingresso.email.Mailer;
import br.com.caelum.ingresso.email.Token;
import br.com.caelum.ingresso.helper.TokenHelper;

@Controller
public class UsuarioController {

	private Mailer mailer;
	private TokenHelper tokenHelper;

	@Autowired
	public UsuarioController(Mailer mailer, TokenHelper tokenHelper) {
		this.mailer = mailer;
		this.tokenHelper = tokenHelper;
	}

	@GetMapping
	private ModelAndView formSolicitacaoDeAcesso() {
		return new ModelAndView("usuario/form-email");
	}

	@PostMapping("/usuario/request")
	@Transactional
	public ModelAndView solicitacaoDeAcesso(String email) {
		ModelAndView view = new ModelAndView("usuario/adicionado");
		Token token = tokenHelper.generateFrom(email);
		mailer.send(new EmailNovoUsuario(token));
		return view;
	}
}
