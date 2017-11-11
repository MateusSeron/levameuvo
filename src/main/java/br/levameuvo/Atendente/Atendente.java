package br.levameuvo.Atendente;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Atendente {
	@Id
	private String idAtendente;
	private String nome;
	private String cpf;
	
	public Atendente() {
		this.idAtendente = UUID.randomUUID().toString();
	}
	
	public Atendente(String nome, String cpf){
		this();
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getIdAtendente() {
		return idAtendente;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}
}
