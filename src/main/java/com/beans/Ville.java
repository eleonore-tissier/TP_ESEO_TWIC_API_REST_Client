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

	public void setCodeCommuneInsee(String codeCommuneInsee) {
		this.codeCommuneInsee = codeCommuneInsee;
	}

	public String getNomCommune() {
		return this.nomCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getLibelleAcheminement() {
		return this.libelleAcheminement;
	}

	public void setLibelleAcheminement(String libelleAcheminement) {
		this.libelleAcheminement = libelleAcheminement;
	}

	public String getLigne5() {
		return this.ligne5;
	}

	public void setLigne5(String ligne5) {
		this.ligne5 = ligne5;
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
