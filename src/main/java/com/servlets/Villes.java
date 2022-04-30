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

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Villes")
public class Villes extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private List<Ville> listVilles;
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

	    this.listVilles = new Gson().fromJson(apiOutput, new TypeToken<List<Ville>>() {}.getType());
	    
	    this.session.setAttribute("villes", this.listVilles);
	    
	    // Gestion de la pagination
	    List<Ville> villesPagination = new ArrayList<>();

	    for(int i=0 ; i<=49 ; i++) {
	    	villesPagination.add(this.listVilles.get(i));
	    }
	    request.setAttribute("villesPagination", villesPagination);
	    
		this.getServletContext().getRequestDispatcher("/WEB-INF/villes.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (this.session == null) {
			this.session = request.getSession();
		}
		
		// Gestion de la pagination
	    List<Ville> villesPagination = new ArrayList<>();
	    int pageNumber=Integer.parseInt(request.getParameter("page"));

	    request.setAttribute("pageNumber", pageNumber);

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
	    	if(i<this.listVilles.size()) {
		    	villesPagination.add(this.listVilles.get(i));
	    	}
	    }
	    request.setAttribute("villesPagination", villesPagination);
		
	    // -------------------------------------------------------------------------------------
		// Traitement pour la modification et de la suppression d'une ville : Dans le servlet ModifVille.java
	    // -------------------------------------------------------------------------------------
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/villes.jsp").forward(request, response);
	}
}
