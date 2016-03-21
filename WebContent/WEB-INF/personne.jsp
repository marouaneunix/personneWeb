<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="inc/css/main.css">
<link rel="stylesheet" href="inc/css/normalize.css">
<link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<header class="row">
		<div class="col-12">
			<h1 class="primary-title" >Gestion des Personnes</h1>
		</div>
	</header>
	<section class="row">
	<article class="col-8">
			<table class="table">
				<tr>
					<th class="th-green">Nom</th><th class="th-green">Supprimer</th><th class="th-green" >Modifier</th>
				</tr>
				<c:forEach items="${ personnes }" var="pers">
				<tr>
						<td class="center"> <c:out value="${ pers.nom }"/> </td>
						<td class="center" >
						<a href="<c:url value="controleur.do"> 
							<c:param name="action" value="del" /> 
							<c:param name="nom" value="${pers.nom}" />
						</c:url> ">
						<img class="small-image" alt="delete" src="inc/delete.png"/>
						</a>
						</td>
						<td class="center">
						<a href="<c:url value="controleur.up"> 
							<c:param name="action" value="upd" /> 
							<c:param name="nom" value="${pers.nom}" />
						</c:url> ">
						<img class="small-image" alt="update" src="inc/update.png"/>
						</a>
						</td>
				</tr>
				</c:forEach>
			</table>
		</article>
		<article class="col-4">
		<button class="button-info" id="tog" >Ajouter un Personne</button>
		<div id="thing" class="thing">
		<form  action="contoleur.do" method="post">
			<table >
				<tr>
					<td>Nom :<td>
					<td><input type="text" name="nomPersonne"/></td>
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
}</script>
</body>
</html>