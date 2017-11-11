package br.levameuvo.Atendente;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import br.levameuvo.Atendimento.Atendimento;

@Entity
public class Atendente {

	@Id
	private String idAtendente;
	@OneToMany
	@JoinColumn
	private List<Atendimento> atendimentos = new ArrayList<Atendimento>();
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

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

}
