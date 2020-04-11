package br.com.caelum.ingresso.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DetalhesDoFilme {
	@JsonProperty("Title")
	private String titulo;
	@JsonProperty("Year")
	private String ano;
	@JsonProperty("Poster")
	private String imagem;
	@JsonProperty("Director")
	private String diretores;
	@JsonProperty("Writer")
	private String escritores;
	@JsonProperty("Actors")
	private String atores;
	@JsonProperty("Plot")
	private String descricao;
	@JsonProperty("imdbRating")
	private Double avaliacao;
	public String getTitulo() {
		return titulo;
	}
	public String getAno() {
		return ano;
	}
	public String getImagem() {
		return imagem;
	}
	public String getDiretores() {
		return diretores;
	}
	public String getEscritores() {
		return escritores;
	}
	public String getAtores() {
		return atores;
	}
	public String getDescricao() {
		return descricao;
	}
	public Double getAvaliacao() {
		return avaliacao;
	}
	
}
