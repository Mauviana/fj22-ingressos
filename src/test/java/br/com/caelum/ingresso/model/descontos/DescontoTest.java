package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.TipoDeIngresso;

public class DescontoTest {
	private Sala sala;
	private Filme filme;
	private Sessao sessao; 
	private Lugar lugar;
	private Ingresso ingressoSemDesconto;
	private Ingresso ingressoDescontoBanco;
	private Ingresso ingressoDescontoEstudante;
	
	@Before
	public void preparaSessoes() {
		this.sala = new Sala("Eldorado - IMAX", new BigDecimal("20.5"));
		this.filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("12"));
		this.sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		this.lugar = new Lugar("A", 1);
		
		this.ingressoDescontoBanco = new Ingresso(sessao, TipoDeIngresso.BANCO, lugar);
		this.ingressoDescontoEstudante = new Ingresso(sessao, TipoDeIngresso.ESTUDANTE, lugar);
		this.ingressoSemDesconto = new Ingresso(sessao, TipoDeIngresso.INTEIRO, lugar);
	}
	
	@Test
	public void naoDeveConcederDescontoParaIngressoNormal() {
		BigDecimal precoEsperado = new BigDecimal("32.50");
		Assert.assertEquals(precoEsperado, ingressoSemDesconto.getPreco());
	}

	@Test
	public void deveConcederDescontoDe30PorcentoParaIngressosDeClientesDeBancos() {
		BigDecimal precoEsperado = new BigDecimal("22.75");
		Assert.assertEquals(precoEsperado, ingressoDescontoBanco.getPreco());
	}

	@Test
	public void deveConcederDescontoDe50PorcentoParaIngressoDeEstudante() {
		
		BigDecimal precoEsperado = new BigDecimal("16.25");
		Assert.assertEquals(precoEsperado, ingressoDescontoEstudante.getPreco());
	}
}