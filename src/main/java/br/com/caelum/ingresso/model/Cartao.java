package br.com.caelum.ingresso.model;

import java.time.YearMonth;

public class Cartao {
	private String cartaoDeCredito;
	private Integer cvv;
	private YearMonth vencimento;
	
	public boolean isValido() {
		return vencimento.isAfter(YearMonth.now());
	}

	public String getCartaoDeCredito() {
		return cartaoDeCredito;
	}
	
	public void setCartaoDeCredito(String cartaoDeCredito) {
		this.cartaoDeCredito = cartaoDeCredito;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public YearMonth getVencimento() {
		return vencimento;
	}

	public void setVencimento(YearMonth vencimento) {
		this.vencimento = vencimento;
	}

}
