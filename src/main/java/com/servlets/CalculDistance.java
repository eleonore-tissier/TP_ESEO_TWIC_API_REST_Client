package com.servlets;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.beans.Ville;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CalculDistance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Ville> villes;
	HttpSession session = null;
	
	double ville1Long;
	double ville2Long;
	double ville1Lat;
	double ville2Lat;
	double resultat;
	
	public CalculDistance() {
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
	    
  	    this.session.setAttribute("villes", this.villes);

        this.getServletContext().getRequestDispatcher("/WEB-INF/calculDistance.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (this.session == null) {
			this.session = request.getSession();
		}		
		
		if(request.getParameter("ville1")!=null || request.getParameter("ville2")!=null) {
			// On récupère les noms des villes sélectionées dans le formulaire
			String ville1 = request.getParameter("ville1");
        	String ville2 = request.getParameter("ville2");
			request.setAttribute("ville1", ville1);
			request.setAttribute("ville2", ville2);
			
			// On récupère la latitude et la longitude des deux villes
			for(Ville item : this.villes) {
				if(item.getNom_commune().equals(ville1)) {
					this.ville1Lat = Double.parseDouble(item.getLatitude());
					this.ville1Long = Double.parseDouble(item.getLongitude());
				}
				if(item.getNom_commune().equals(ville2)) {
					this.ville2Lat = Double.parseDouble(item.getLatitude());
					this.ville2Long = Double.parseDouble(item.getLongitude());
				}
			}
			
			// On calcule leur distance
			this.resultat = 6371 * Math.acos(Math.sin(Math.toRadians(this.ville1Lat))*Math.sin(Math.toRadians(this.ville2Lat)) 
					+ Math.cos(Math.toRadians(this.ville1Lat))*Math.cos(Math.toRadians(this.ville2Lat))*Math.cos(Math.toRadians(this.ville2Long - this.ville1Long)));
			request.setAttribute("resultat", this.resultat);
		}
		
        this.getServletContext().getRequestDispatcher("/WEB-INF/calculDistance.jsp").forward(request, response);
	}
}
