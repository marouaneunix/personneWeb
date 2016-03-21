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
		<article>
		<form action="contoleur.do" method="post">
			<table>
				<tr>
					<td>Nom :<td>
					<td><input type="text" name="nomPersonne" value="${ nomPersonne }"/></td>
					<td style="display:none;" ><input type="text" name="nom" value="${ nomPersonne } "/></td>
				<tr>
				<tr>
					<td><input class="button-success" type="submit" name="action" value="Update" /></td>
				</tr>
			</table>
			</form>
		</article>
	</section>
	</div>
</body>
</html>