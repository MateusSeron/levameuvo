package br.levameuvo.Localizacao;

<<<<<<< HEAD
import javax.persistence.Entity;

@Entity
public class Localizacao {
=======
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
>>>>>>> e51d03fcd460a19767bae3bd8ab5084862b61b66

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
