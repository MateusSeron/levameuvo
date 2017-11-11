package br.levameuvo.Atendimento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.levameuvo.EndPoint.EndPoint;
import br.levameuvo.Localizacao.Localizacao;

@Entity
public class Atendimento {
	
	@Id
	private String idAtendimento;
	private Date horario;
	private Date data;
	private boolean aceito;
	private Integer valor;
	@ManyToOne
	@JoinColumn
	private Localizacao geolocalizacao;
	
	@OneToMany
	@JoinColumn()
	private List<EndPoint> etapas = new ArrayList<EndPoint>();
	
	public Atendimento() {
		this.idAtendimento = UUID.randomUUID().toString();
	}
	
	public Atendimento(Date horario, Date data, boolean aceito, Integer valor, Localizacao geo, List<EndPoint> etapas){
		this();
		this.horario = horario;
		this.data = data;
		this.aceito = aceito;
		this.valor = valor;
		this.geolocalizacao = geo;
		this.etapas = etapas;
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
	
	public List<EndPoint> getEtapas(){
		return this.etapas;
	}
	
	
}
