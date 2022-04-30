<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Cidystance - Modifier une ville</title>
	</head>
	<body>
		<div class="divforfooter"><center><p class="banner" ><a class="banner" href="http://localhost:8080/TP_ESEO_API_REST_Client/">Cidystance</a></p></center>
		<div class="formModif">
			<p class="enteteModifier" >Remplissez les champs que vous souhaitez modifier</p>
			<form method="post" action="ModifVille">
				<p class="champsModifier">
					<label for="nomVille">Nouveau nom de la commune :</label>
		    		<input type="text" name="nomVille" id="nomVille">
		    	</p>
		    	<p class="champsModifier">
		    		<label for="codePostal">Nouveau code postal :</label>
		    		<input type="text" name="codePostal" id="codePostal" pattern="[0-9]{5}||{0}">
		    		<span style="font-size: 14px;">(Maximum 5 caractères)</span>
		    	</p>
		    	<p class="champsModifier">
		    		<label for="libelle">Nouveau libellé d'acheminement :</label>
		    		<input type="text" name="libelle" id="libelle" pattern="[A-Za-z]+||{0}">
		    	</p>
		    	<p class="champsModifier">
		    		<label for="nomVille">Ligne 5 :</label>
		    		<input type="text" name="nomVille" id="nomVille" pattern="[A-Za-z]+||{0}">
		    	</p>
		    	<p class="champsModifier">	
		    		<label for="latitude">Nouvelle latitude :</label>
		    		<input type="text" name="latitude" id="latitude" pattern="[0-9]+([\.,][0-9]+)?||{0}" step="0.00000000001">
		    	</p>
		    	<p class="champsModifier">
		    		<label for="longitude">Nouvelle longitude :</label>
		    		<input type="text" name="longitude" id="longitude" pattern="[0-9]+([\.,][0-9]+)?||{0}" step="0.00000000001">
		    	</p>
		    	
	    		<input class="modifierButton" type="submit" value="Enregistrer" name="enregistrer" id="enregistrer" >
	<!--     		<input type="submit" value="Supprimer la ville" name="supprimer" id="supprimer" > -->
			</form>
		</div>
		
		<c:if test="${ modifDonne }">
			<p class="piedDePageModifVille" >Ville modifiée avec succès !</p>
			<input class="modifVilleRetour" type="button" value="Retour à la liste des villes >" onclick="self.location.href='http://localhost:8080/TP_ESEO_API_REST_Client/Villes'">			
		</c:if></div>
		
		<footer>
			<a class="pagefooter" href="https://www.linkedin.com/in/%C3%A9l%C3%A9onore-tissier-5701671b9/" target="_blank">Eléonore Tissier</a>
		</footer>	
	</body>
</html>