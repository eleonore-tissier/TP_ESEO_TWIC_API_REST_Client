		<title>Cidystance - Calcul de distance</title>
	</head>
	<body>
		<div class="divforfooter"><center><p class="banner" ><a class="banner" href="http://localhost:8080/TP_ESEO_API_REST_Client/">Cidystance</a></p></center>
		<!-- Formulaire de calcul des distances -->		
		<c:if test="${ villes != null }">
			<div class="calculDist">
				<p class="enteteCalculDistance" >Sélectionnez les villes dans les listes déroulantes</p>
				<form method="post" action="CalculDistance">
					<p>
						<label for="ville1">Ville 1 :</label>
						<select id="ville1" name="ville1">
							<c:forEach items="${ villes }" var="ville" >
								<option value="${ ville.nom_commune }"><c:out value="${ ville.nom_commune }"/></option>
							</c:forEach>
						</select>
					</p>
					<p>
						<label for="ville2">Ville 2 :</label>
						<select id="ville2" name="ville2">
							<c:forEach items="${ villes }" var="ville" >
								<option value="${ ville.nom_commune }"><c:out value="${ ville.nom_commune }"/></option>
							</c:forEach>
						</select>
					</p>
					<input class="calculButton" type="submit" value="Calculer"/>
				</form>
			</div>
		</c:if>
		
		<c:if test="${ !empty resultat }">
			<p class="resultDistance"><c:out value="${ ville1 }"/> et <c:out value="${ ville2 }"/> sont séparées par <c:out value="${ resultat }"/> kilomètres</p>
		</c:if></div>
		
		<footer>
			<a class="pagefooter" href="https://www.linkedin.com/in/%C3%A9l%C3%A9onore-tissier-5701671b9/">Eléonore Tissier</a>
		</footer>
	</body>
</html>