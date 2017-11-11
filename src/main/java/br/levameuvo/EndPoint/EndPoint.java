package br.levameuvo.EndPoint;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EndPoint {
	
	@Id
	private String idEndPoint;
	private String etapa;
	private boolean concluido;
	private List<Byte> foto;
	
	public EndPoint() {
		this.idEndPoint = UUID.randomUUID().toString();
	}
	
	public EndPoint(String etapa, boolean concluido, List<Byte> foto){
		this();
		this.etapa = etapa;
		this.concluido = concluido;
		this.foto = foto;
	}

	public String getIdEndPoint() {
		return idEndPoint;
	}

	public String getEtapa() {
		return etapa;
	}

	public boolean isConcluido() {
		return concluido;
	}

	public List<Byte> getFoto() {
		return foto;
	}
	
}
