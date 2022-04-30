package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.beans.Ville;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ModifVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
       
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
			System.out.println(request.getParameter("modifier"));
			
			System.out.println("Ville sélectionnée - Nom : " + request.getParameter("nomVille"));
			System.out.println("Ville sélectionnée - Code Postal : " + request.getParameter("codePostal"));
			System.out.println("Ville sélectionnée - Code INSEE : " + request.getParameter("codeInsee"));
			System.out.println("Ville sélectionnée - Libelle d'acheminement : " + request.getParameter("libelle"));
			System.out.println("Ville sélectionnée - Ligne 5 : " + request.getParameter("ligne5"));
			System.out.println("Ville sélectionnée - Latitude : " + request.getParameter("latitude"));
			System.out.println("Ville sélectionnée - Longitude : " + request.getParameter("longitude"));
			
			System.out.println("----------------------------------------------");
			
			Ville villeSelectionnee = new Ville(request.getParameter("codeInsee"),
					request.getParameter("nomVille"),
					request.getParameter("codePostal"),
					request.getParameter("libelle"),
					request.getParameter("ligne5"),
					request.getParameter("latitude"),
					request.getParameter("longitude"));
			this.session.setAttribute("villeSelectionnee", villeSelectionnee);
		    
		}
		
		// Body de la requête PUT de modification de la ville
		if(request.getParameter("enregistrer") != null && request.getParameter("supprimer") == null) {
			System.out.println(request.getParameter("enregistrer"));
			List<String> parameters = new ArrayList<String>();
			if(request.getParameter("nomVille") != null && !request.getParameter("nomVille").equals("")) {
				parameters.add("Nom_commune");
				parameters.add(request.getParameter("nomVille"));
			}
			if(request.getParameter("codePostal") != null && !request.getParameter("codePostal").equals("")) {
				parameters.add("Code_postal");
				parameters.add(request.getParameter("codePostal"));
			}
			if(request.getParameter("libelle") != null && !request.getParameter("libelle").equals("")) {
				parameters.add("Libelle_acheminement");
				parameters.add(request.getParameter("libelle"));
			}
			if(request.getParameter("ligne5") != null && !request.getParameter("ligne5").equals("")) {
				parameters.add("Ligne_5");
				parameters.add(request.getParameter("ligne5"));
			}
			if(request.getParameter("latitude") != null && !request.getParameter("latitude").equals("") && !request.getParameter("latitude").equals(" ")) {
				parameters.add("Latitude");
				parameters.add(request.getParameter("latitude"));
			}
			if(request.getParameter("longitude") != null && !request.getParameter("longitude").equals("") && !request.getParameter("longitude").equals("longitude")) {
				parameters.add("Longitude");
				parameters.add(request.getParameter("longitude"));
			}
			
			Ville villeSelectionnee = (Ville)session.getAttribute("villeSelectionnee");
			String putRequestBody = "{ \"Code_commune_INSEE\": \"" + villeSelectionnee.getCode_commune_INSEE() + "\",";
			
			for(int i=1 ; i<parameters.size() ; i+=2) {
				if(i == parameters.size()-1) {
					putRequestBody += "\"" + parameters.get(i-1) + "\": \"" + parameters.get(i) + "\"}";
				}
				else {
					putRequestBody += "\"" + parameters.get(i-1) + "\": \"" + parameters.get(i) + "\",";
				}
			}
			
			System.out.println("--- Requête à envoyer --- \n" + putRequestBody);
			System.out.println("----------------");
			
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
			HttpResponse ret = httpClient.execute(putRequest);
			
			HttpEntity httpEntity = ret.getEntity();
		    String apiOutput = EntityUtils.toString(httpEntity);
		    System.out.println("--- Réponse --- \n" + apiOutput);
			
			Boolean modifDonne = true;
			request.setAttribute("modifDonne", modifDonne);

		}
		
		// Suppression d'une ville
//		if(request.getParameter("supprimer") != null && request.getParameter("enregistrer") == null) {
//			System.out.println(request.getParameter("supprimer"));
//			
//			// On récupère la ville sélectionnée
//			Ville villeSelectionnee = (Ville)session.getAttribute("villeSelectionnee");
//			
//			// Envoie de la requête au serveur
//			DefaultHttpClient httpClient = new DefaultHttpClient();
//			HttpGet getRequest = new HttpGet("http://localhost:8181/ville?insee=" + villeSelectionnee.getCode_commune_INSEE());
//			HttpResponse ret = httpClient.execute(getRequest);
//		    
//			HttpEntity httpEntity = ret.getEntity();
//		    String apiOutput = EntityUtils.toString(httpEntity);
//		    System.out.println("--- Réponse --- \n" + apiOutput);
//		    
//		    Boolean supDonne = true;
//			request.setAttribute("supDonne", supDonne);
//		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifVille.jsp").forward(request, response);
	}

}
