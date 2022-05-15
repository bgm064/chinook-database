<%@ page contentType="text/html; encoding=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Artists</title>
<script src="/scripts/app.js"></script>
<link rel="stylesheet"
	href="https://unpkg.com/sakura.css/css/sakura-dark.css" type="text/css">
<style>
button {
	float: right;
}
</style>
</head>
<body>
	<h1>Artists</h1>

	<form method="POST">
		<input name="name" type="text" required
			placeholder="type artist here..." autofocus /> <input type="submit"
			value="Add to database" />
	</form>

	<ol>
		<c:forEach items="${ items }" var="artist">
			<li id="product-${ artist.getArtistId() }"><c:out value="${ artist.getArtistName() }"></c:out>
				<button onclick="removeItem(${ artist.getArtistId() })">Remove</button></li>
		</c:forEach>
	</ol>
</body>
</html>