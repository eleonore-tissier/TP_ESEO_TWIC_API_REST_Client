		<title>Cidystance - Liste des villes</title>
	</head>
	<body>
		<c:choose>
			<c:when test="${ pageNumber == '68' }">
				<div class="divforfooter"><center><p class="banner" ><a class="banner" href="http://localhost:8080/TP_ESEO_API_REST_Client/">Cidystance</a></p></center>
				<table>
					<thead>
						<tr>
							<th>Nom de la commune</th>
							<th>Code postal</th>
							<th>Code INSEE</th>
							<th>Libelle d'acheminement</th>
							<th>Ligne 5</th>
							<th>Latitude</th>
							<th>Longitude</th>
						</tr>
					</thead>
					<tbody id="tabVille">
						<c:forEach items="${ villesPagination }" var="ville" varStatus="status">
							<tr>
								<form method="post" action="ModifVille">
									<td><input type="hidden" value="${ ville.nomCommune }" name="nomVille" id="nomVille"><c:out value="${ ville.nomCommune }"/></input></td>
									<td><input type="hidden" value="${ ville.codePostal }" name="codePostal" id="codePostal"><c:out value="${ ville.codePostal }"/></input></td>
									<td><input type="hidden" value="${ ville.codeCommuneInsee }" name="codeInsee" id="codeInsee"><c:out value="${ ville.codeCommuneInsee }"/></input></td>
									<td><input type="hidden" value="${ ville.libelleAcheminement }" name="libelle" id="libelle"><c:out value="${ ville.libelleAcheminement }"/></input></td>
									<td><input type="hidden" value="${ ville.ligne5 }" name="ligne5" id="ligne5"><c:out value="${ ville.ligne5 }"/></input></td>
									<td><input type="hidden" value="${ ville.latitude }" name="latitude" id="latitude"><c:out value="${ ville.latitude }"/></input></td>
									<td><input type="hidden" value="${ ville.longitude }" name="longitude" id="longitude"><c:out value="${ ville.longitude }"/></input></td>
									<td><input type="submit" value="Modifier" name="modifier" id="modifier"></td>
								</form>
		<!-- 						<td><button onclick="window.location.href = 'http://localhost:8080/TP_ESEO_API_REST_Client/ModifVille';" >Modifier</button></td> -->
		<!-- 						<td><button>Supprimer</button></td> -->
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
		<!-- 		Pagination -->
				<hr>
				<div class="pages">
					<form method="post" action="Villes">
						<c:forEach var="i" begin="1" end="68">
							<input type="submit" type="hidden" name="page" id="page" value="${ i }">
						</c:forEach>
					</form>
				</div></div>
			</c:when>
			<c:otherwise>
				<div class="divforfooterBigPage"><center><p class="banner" ><a class="banner" href="http://localhost:8080/TP_ESEO_API_REST_Client/">Cidystance</a></p></center>
				<table>
					<thead>
						<tr>
							<th>Nom de la commune</th>
							<th>Code postal</th>
							<th>Code INSEE</th>
							<th>Libelle d'acheminement</th>
							<th>Ligne 5</th>
							<th>Latitude</th>
							<th>Longitude</th>
						</tr>
					</thead>
					<tbody id="tabVille">
						<c:forEach items="${ villesPagination }" var="ville" varStatus="status">
							<tr>
								<form method="post" action="ModifVille">
									<td><input type="hidden" value="${ ville.nomCommune }" name="nomVille" id="nomVille"><c:out value="${ ville.nomCommune }"/></input></td>
									<td><input type="hidden" value="${ ville.codePostal }" name="codePostal" id="codePostal"><c:out value="${ ville.codePostal }"/></input></td>
									<td><input type="hidden" value="${ ville.codeCommuneInsee }" name="codeInsee" id="codeInsee"><c:out value="${ ville.codeCommuneInsee }"/></input></td>
									<td><input type="hidden" value="${ ville.libelleAcheminement }" name="libelle" id="libelle"><c:out value="${ ville.libelleAcheminement }"/></input></td>
									<td><input type="hidden" value="${ ville.ligne5 }" name="ligne5" id="ligne5"><c:out value="${ ville.ligne5 }"/></input></td>
									<td><input type="hidden" value="${ ville.latitude }" name="latitude" id="latitude"><c:out value="${ ville.latitude }"/></input></td>
									<td><input type="hidden" value="${ ville.longitude }" name="longitude" id="longitude"><c:out value="${ ville.longitude }"/></input></td>
									<td><input type="submit" value="Modifier" name="modifier" id="modifier"></td>
								</form>
		<!-- 						<td><button onclick="window.location.href = 'http://localhost:8080/TP_ESEO_API_REST_Client/ModifVille';" >Modifier</button></td> -->
		<!-- 						<td><button>Supprimer</button></td> -->
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
		<!-- 		Pagination -->
				<hr>
				<div class="pages">
					<form method="post" action="Villes">
						<c:forEach var="i" begin="1" end="68">
							<input type="submit" type="hidden" name="page" id="page" value="${ i }">
						</c:forEach>
					</form>
				</div></div>
			</c:otherwise>
		</c:choose>
		
		<c:choose>
			<c:when test="${ pageNumber == '68' }">
				<footer>
					<a class="pagefooter" href="https://www.linkedin.com/in/%C3%A9l%C3%A9onore-tissier-5701671b9/">Eléonore Tissier</a>
				</footer>
			</c:when>
			<c:otherwise>
				<footer class="bigPageFooter">
					<a class="pagefooter" href="https://www.linkedin.com/in/%C3%A9l%C3%A9onore-tissier-5701671b9/" target="_blank">Eléonore Tissier</a>
				</footer>
			</c:otherwise>
		</c:choose>

	</body>
</html>