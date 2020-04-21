package br.com.caelum.ingresso.model.form;

import br.com.caelum.ingresso.email.Token;

public class ConfirmacaoLoginForm {
	private Token token;
	private String password;
	private String confirmPassword;

	public ConfirmacaoLoginForm() {
	}

	public ConfirmacaoLoginForm(Token token) {
		this.token = token;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isValid() {
		return password.equals(confirmPassword);
	}
}