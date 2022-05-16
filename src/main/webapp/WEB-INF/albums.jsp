<%@ page contentType="text/html; encoding=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Albums</title>
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
	<h1>Albums: <c:out value="${ artist.getArtistName() }"></c:out></h1>

	<form method="POST">
		<input name="title" type="text" required
			placeholder="type album here..." autofocus /> <input type="submit"
			value="Add to database" />
	</form>

	<ol>
		<c:forEach items="${ items }" var="album">
			<li id="product-${ album.getAlbumId() }"><c:out
					value="${ album.getAlbumTitle() }"></c:out>
				<button onclick="removeItem(${ album.getAlbumId() })">Remove</button></li>
		</c:forEach>
	</ol>
</body>
</html>