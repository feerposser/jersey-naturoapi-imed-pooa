package br.com.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Personagem {

	private int anoNascimento;
	private String nome;
	private String clan;
	
	public Personagem(int anoNascimento, String nome, String clan) {
		this.anoNascimento = anoNascimento;
		this.nome = nome;
		this.clan = clan;	
	}
	
	public Personagem() {}

	public int getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClan() {
		return clan;
	}

	public void setClan(String clan) {
		this.clan = clan;
	}

}
