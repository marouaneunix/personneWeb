<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="inc/css/main.css">
<link rel="stylesheet" href="inc/css/normalize.css">
<script src="inc/jvscript/jquery.min.js"></script>
<link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
<title>Insert title here</title>
</head>
<body>
<div class="container" id="result1">
	<header class="row">
		<div class="col-12">
			<h1 class="primary-title" >Gestion des Reclamation</h1>
		</div>
	</header>
	<section class="row">
	<div class="col-6">
		<table>
			 <tr>
			 	<td>Nom :</td>
			 	<td>
			 	<select name="personne" id="personne">
			 	<c:forEach items="${personnes}" var="pers">
			 	<c:choose>
			 	<c:when test="${pers.nom == personne }">
			 	<option selected ><c:out value="${ pers.nom }" /></option>
			 	</c:when>
			 	<c:otherwise>
			 	<option><c:out value="${ pers.nom }" /></option>
			 	</c:otherwise>
			 	</c:choose>
			 		
			 	</c:forEach>
			 	</select>
			 	</td>
			 </tr>
		</table>
			</div>
	</section>
	<section class="row">
	<article class="col-8">
	
			<table class="table" id="result1">
				<tr>
					<th class="th-green">Commentaire</th><th class="th-green">Supprimer</th><th class="th-green" >Modifier</th>
				</tr>
				<c:forEach items="${ reclamations }" var="rec">
				<tr>
						<td class="center" id='src${rec.id}'> <c:out value="${ rec.commentaire}"/> </td>
						<td class="center" >
						<a href="<c:url value="delete.rec"> 
							<c:param name="action" value="del" /> 
							<c:param name="id" value="${rec.id}" />
							<c:param name="nomPersonne" value="${rec.personne.nom }"/>
						</c:url> ">
						<img class="small-image" alt="delete" src="inc/delete.png"/>
						</a>
						</td>
						<td class="center">
						<a href="<c:url value="controleur.uprec"> 
							<c:param name="action" value="upd" /> 
 							<c:param name="id" value="${rec.id}" />
 							<c:param name="nomPersonne" value="${rec.personne.nom }"/>
 							<c:param name="commentaire" value="${rec.commentaire}"/>
						</c:url> ">
						<img class="small-image" alt="update" src="inc/update.png"/>
						</a>
						</td>
				</tr>
				</c:forEach>
			</table>
		</article>
		<article class="col-4">
		<button class="button-info" id="tog" >Ajouter un commentaire </button>
		<div id="thing" class="thing">
		<form  action="controleur.rec" method="post">
			<table >
				<tr>
					<td>
						<input type="text" name="personne" value="${ personne }" type="hidden"/>
					</td>
				</tr>
				<tr>
					<td>Commentaire :<td>
					<td><textarea class="textar" name="commentaire" rows="8" cols="20" id="commentaire" ></textarea></td>
				<tr>
				<tr>
					<td><input class="button-success" type="submit" name="action" value="Save" /></td>
				</tr>
			</table>
			</form>
		</div>
		</article>
		
	</section>
	<footer>
		
	</footer>
	</div>
<script>
var tog = document.getElementById("tog");
var thing = document.getElementById("thing");
if(tog){
tog.addEventListener("click", function(){
	thing.classList.toggle("open");
	
});
}




$(document).ready(function(){
	$("#personne").change(function(){
		 $.ajax({
		url: "home.rec",
		type: "GET",
		data : {personne: $(this).val()},
		success: function(response) {
		    $('#result1').html(response);
		  },
		  error: function(xhr) {
		    //Do Something to handle error
		  }
		 });	
		});
});

</script>
</body>
</html>