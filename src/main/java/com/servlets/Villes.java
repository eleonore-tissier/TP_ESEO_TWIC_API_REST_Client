package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.beans.Ville;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Villes")
public class Villes extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private List<Ville> villes;
	HttpSession session = null;
		
	public Villes() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (this.session == null) {
			this.session = request.getSession();
		}
		
		// Envoie de la requête au serveur pour récupérer la liste des villes
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet("http://localhost:8181/ville");
		HttpResponse ret = httpClient.execute(getRequest);
	    
		HttpEntity httpEntity = ret.getEntity();
	    String apiOutput = EntityUtils.toString(httpEntity);
	    ObjectMapper objectMapper = new ObjectMapper();
//	    this.villes = objectMapper.readValue(apiOutput, new TypeReference<List<Ville>>() {});
	    this.villes = new Gson().fromJson(apiOutput, new TypeToken<List<Ville>>() {}.getType());
	    
	    this.session.setAttribute("villes", villes);
	    
	    // Gestion de la pagination
	    List<Ville> villesPagination = new ArrayList<Ville>();
	    int pageNumber = 1;
	    int nbVillesAffichees=50;
	    System.out.println("Numéro de page : " + pageNumber);

	    for(int i=0 ; i<=49 ; i++) {
	    	villesPagination.add(this.villes.get(i));
	    }
	    request.setAttribute("villesPagination", villesPagination);
	    
		this.getServletContext().getRequestDispatcher("/WEB-INF/villes.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (this.session == null) {
			this.session = request.getSession();
		}
		
		// Gestion de la pagination
	    List<Ville> villesPagination = new ArrayList<Ville>();
	    int pageNumber=Integer.parseInt(request.getParameter("page"));
	    System.out.println("Numéro de page : " + pageNumber);
	    request.setAttribute("pageNumber", pageNumber);
//	    int pageNumber = 1;
	    int nbVillesAffichees=50;
	    
	    int begin = 0;
	    int end = 0;
	    if(pageNumber == 1) {
	    	begin = 0;
	    	end = 49;
	    }
	    else {
	    	begin = ((pageNumber-1)*nbVillesAffichees+1);
	    	end = begin + 49;
	    }
	    for(int i=begin ; i<=end ; i++) {
	    	if(i<this.villes.size()) {
		    	villesPagination.add(this.villes.get(i));
	    	}
	    }
	    request.setAttribute("villesPagination", villesPagination);
		
	    // -------------------------------------------------------------------------------------
		// Traitement pour la modification et de la suppression d'une ville : Dans le servlet ModifVille.java
	    // -------------------------------------------------------------------------------------
	    
//		// Traitement pour la suppression d'une ville
//		if(request.getParameter("supprimer") != null) {
//			System.out.println(request.getParameter("supprimer"));
//			
//			// Body de la requête DELETE de modification de la ville
////			String deleteRequestBody = "{ \"Code_commune_INSEE\": " + request.getParameter("codeInsee") + "}";
////			
////			System.out.println("--- Requête à envoyer --- \n" + deleteRequestBody);
////			System.out.println("----------------");
//			
//			// Envoie de la requête au serveur
//			// Préparation de la requête delete
//			DefaultHttpClient httpClient = new DefaultHttpClient();
//			HttpGet getRequest = new HttpGet("http://localhost:8181/ville?insee=\"" + request.getParameter("codeInsee") + "\"");
//			HttpResponse ret = httpClient.execute(getRequest);
//		    
//			HttpEntity httpEntity = ret.getEntity();
//		    String apiOutput = EntityUtils.toString(httpEntity);
//		    System.out.println("--- Réponse --- \n" + apiOutput);
			
			// Envoie de la requête au serveur
			// Préparation de la requête delete
//			DefaultHttpClient httpClient = new DefaultHttpClient();
//			HttpDelete deleteRequest = new HttpDelete("http://localhost:8181/ville");
//			deleteRequest.setHeader("Accept", "application/json");
//			deleteRequest.setHeader("Content-type", "application/json");
//	        
//			// On ajoute le body de la requête
//			StringEntity stringEntity = new StringEntity(deleteRequestBody);
//			deleteRequest.setEntity(stringEntity);
//	        
//			// On exécute la requête
//			HttpResponse ret = httpClient.execute(deleteRequest);
//			
//			HttpEntity httpEntity = ret.getEntity();
//		    String apiOutput = EntityUtils.toString(httpEntity);
//		    System.out.println("--- Réponse --- \n" + apiOutput);
			
//		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/villes.jsp").forward(request, response);
	}
}
