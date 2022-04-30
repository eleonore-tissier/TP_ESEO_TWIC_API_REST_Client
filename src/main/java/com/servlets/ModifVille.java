package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.beans.Ville;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ModifVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
	
	private static final String NOMVILLE = "nomVille";
	private static final String CODEPOSTAL = "codePostal";
	private static final String LIBELLE = "libelle";
	private static final String LIGNE5 = "ligne5";
	private static final String LATITUDE = "latitude";
	private static final String LONGITUDE = "longitude";
	
    public ModifVille() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (this.session == null) {
			this.session = request.getSession();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifVille.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (this.session == null) {
			this.session = request.getSession();
		}
		
		// Modification d'une ville
		// On récupère la ville sélectionnée précédemment
		if(request.getParameter("modifier") != null) {
			
			Ville villeSelectionnee = new Ville(request.getParameter("codeInsee"),
					request.getParameter(NOMVILLE),
					request.getParameter(CODEPOSTAL),
					request.getParameter(LIBELLE),
					request.getParameter(LIGNE5),
					request.getParameter(LATITUDE),
					request.getParameter(LONGITUDE));
			this.session.setAttribute("villeSelectionnee", villeSelectionnee);
		    
		}
		
		// Body de la requête PUT de modification de la ville
		if(request.getParameter("enregistrer") != null) {
			List<String> parameters = new ArrayList<>();
			putBuilding(request, parameters);
			
			Ville villeSelectionnee = (Ville)session.getAttribute("villeSelectionnee");
			String putRequestBody = "{ \"Code_commune_INSEE\": \"" + villeSelectionnee.getCodeCommuneInsee() + "\",";
			
			for(int i=1 ; i<parameters.size() ; i+=2) {
				if(i == parameters.size()-1) {
					putRequestBody += "\"" + parameters.get(i-1) + "\": \"" + parameters.get(i) + "\"}";
				}
				else {
					putRequestBody += "\"" + parameters.get(i-1) + "\": \"" + parameters.get(i) + "\",";
				}
			}

			// Envoie de la requête au serveur
			// Préparation de la requête put
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPut putRequest = new HttpPut("http://localhost:8181/ville");
			putRequest.setHeader("Accept", "application/json");
			putRequest.setHeader("Content-type", "application/json");
	        
			// On ajoute le body de la requête
			StringEntity stringEntity = new StringEntity(putRequestBody);
			putRequest.setEntity(stringEntity);
	        
			// On exécute la requête
			httpClient.execute(putRequest);
			
			Boolean modifDonne = true;
			request.setAttribute("modifDonne", modifDonne);

		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifVille.jsp").forward(request, response);
	}

	private void putBuilding(HttpServletRequest request, List<String> parameters) {
		if(request.getParameter(NOMVILLE) != null && !request.getParameter(NOMVILLE).equals("")) {
			parameters.add("Nom_commune");
			parameters.add(request.getParameter(NOMVILLE));
		}
		if(request.getParameter(CODEPOSTAL) != null && !request.getParameter(CODEPOSTAL).equals("")) {
			parameters.add("Code_postal");
			parameters.add(request.getParameter(CODEPOSTAL));
		}
		if(request.getParameter(LIBELLE) != null && !request.getParameter(LIBELLE).equals("")) {
			parameters.add("Libelle_acheminement");
			parameters.add(request.getParameter(LIBELLE));
		}
		if(request.getParameter(LIGNE5) != null && !request.getParameter(LIGNE5).equals("")) {
			parameters.add("Ligne_5");
			parameters.add(request.getParameter(LIGNE5));
		}
		if(request.getParameter(LATITUDE) != null && !request.getParameter(LATITUDE).equals("") && !request.getParameter(LATITUDE).equals(" ")) {
			parameters.add("Latitude");
			parameters.add(request.getParameter(LATITUDE));
		}
		if(request.getParameter(LONGITUDE) != null && !request.getParameter(LONGITUDE).equals("") && !request.getParameter(LONGITUDE).equals(LONGITUDE)) {
			parameters.add("Longitude");
			parameters.add(request.getParameter(LONGITUDE));
		}
	}

}
