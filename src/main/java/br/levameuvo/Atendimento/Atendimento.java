package br.levameuvo.Atendimento;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.levameuvo.Localizacao.Localizacao;

@Entity
public class Atendimento {
	
	@Id
	private String idAtendimento;
	private Date horario;
	private Date data;
	private boolean aceito;
	private Integer valor;
	private Localizacao geolocalizacao;
	
	public Atendimento() {
		this.idAtendimento = UUID.randomUUID().toString();
	}

	public String getIdAtendimento() {
		return idAtendimento;
	}

	public Date getHorario() {
		return horario;
	}

	public Date getData() {
		return data;
	}

	public boolean isAceito() {
		return aceito;
	}

	public Integer getValor() {
		return valor;
	}

	public Localizacao getGeolocalizacao() {
		return geolocalizacao;
	}
	
	
}
