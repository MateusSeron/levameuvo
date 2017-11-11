package br.levameuvo.Localizacao;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Localizacao {
	
	@Id
	private String idLocalizacao;
	private Integer latitude;
	private Integer longitude;
	
	public Localizacao(){
		this.idLocalizacao = UUID.randomUUID().toString();
	}
	
	public Localizacao(Integer latitude, Integer longitude){
		
		this();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public String getIdLocalizacao() {
		return idLocalizacao;
	}
	public Integer getLongitude() {
		return longitude;
	}
	public Integer getLatitude() {
		return latitude;
	}
}
