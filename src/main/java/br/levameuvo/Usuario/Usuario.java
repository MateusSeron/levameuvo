package br.levameuvo.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.levameuvo.Atendimento.Atendimento;


@Entity
public class Usuario {

	@Id
	private String idUsuario;
	private String nome;
	private List<Atendimento> agendamentos = new ArrayList<Atendimento>();
	
	
	public Usuario(){
		this.idUsuario = UUID.randomUUID().toString();
		
	}
	public Usuario(String nome, ArrayList<Atendimento> agendamentos){
		this();
		this.nome = nome;
		this.agendamentos = agendamentos;
	}
	
	public String getNome() {
		return nome;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public List<Atendimento> getAgendamentos() {
		return agendamentos;
	}
}
