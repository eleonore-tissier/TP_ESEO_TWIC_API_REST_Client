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

	public String getCodeCommuneInsee() {
		return this.codeCommuneInsee;
	}

	public void setCodeCommuneInsee(String code_commune_INSEE) {
		this.codeCommuneInsee = code_commune_INSEE;
	}

	public String getNomCommune() {
		return this.nomCommune;
	}

	public void setNomCommune(String nom_commune) {
		this.nomCommune = nom_commune;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String code_postal) {
		this.codePostal = code_postal;
	}

	public String getLibelleAcheminement() {
		return this.libelleAcheminement;
	}

	public void setLibelleAcheminement(String libelle_acheminement) {
		this.libelleAcheminement = libelle_acheminement;
	}

	public String getLigne5() {
		return this.ligne5;
	}

	public void setLigne5(String ligne_5) {
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
