package com.beans;

public class Ville {
	private String codeCommuneInsee;
	private String nomCommune;
	private String codePostal;
	private String libelleAcheminement;
	private String ligne5;
	private String latitude;
	private String longitude;

	public Ville() {
		super();
	}
	
	public Ville(String codeCommuneInsee, String nomCommune, String codePostal, String libelleAcheminement,
			String ligne5, String latitude, String longitude) {
		super();
		this.codeCommuneInsee = codeCommuneInsee;
		this.nomCommune = nomCommune;
		this.codePostal = codePostal;
		this.libelleAcheminement = libelleAcheminement;
		this.ligne5 = ligne5;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getCode_commune_INSEE() {
		return this.codeCommuneInsee;
	}

	public void setCode_commune_INSEE(String code_commune_INSEE) {
		this.codeCommuneInsee = code_commune_INSEE;
	}

	public String getNom_commune() {
		return this.nomCommune;
	}

	public void setNom_commune(String nom_commune) {
		this.nomCommune = nom_commune;
	}

	public String getCode_postal() {
		return this.codePostal;
	}

	public void setCode_postal(String code_postal) {
		this.codePostal = code_postal;
	}

	public String getLibelle_acheminement() {
		return this.libelleAcheminement;
	}

	public void setLibelle_acheminement(String libelle_acheminement) {
		this.libelleAcheminement = libelle_acheminement;
	}

	public String getLigne_5() {
		return this.ligne5;
	}

	public void setLigne_5(String ligne_5) {
		this.ligne5 = ligne_5;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
