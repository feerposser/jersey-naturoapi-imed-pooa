package br.com.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Personagem {
	
	private int id;
	private String nome;
	private int anoNascimento;
	private String clan;
	
	public Personagem(int id, String nome,  int anoNascimento, String clan) {
		this.anoNascimento = anoNascimento;
		this.nome = nome;
		this.clan = clan;
		this.id = id;
	}
	
	public Personagem() {}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

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
