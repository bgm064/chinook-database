<%@ page contentType="text/html; encoding=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Artists | 🎤 | Music Library</title>
<link rel="stylesheet"
	href="https://unpkg.com/sakura.css/css/sakura-dark.css" type="text/css">
<style>
#remove_button, #home_button, #search_form {
	float: right;
}

#search_button:hover, #add_button:hover, #home_button:hover {
	color: #C9C9C9;
	background-color: #735BC1;
	border: 1px solid #735BC1;
}
</style>
</head>
<body>
	<form id="search_form" method="GET" action="/artists/search">
		<input name="q" type="text" required placeholder="type here..."
			autofocus /> <input id="search_button" type="submit" value="Search" />
	</form>

	<h1>Artists</h1>

	<form method="POST">
		<input name="name" type="text" required placeholder="type here..."
			autofocus /> <input id="add_button" type="submit"
			value="Add to database" /> <input id="home_button" type="button"
			value="Home" onclick="window.location.href='/';">
	</form>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Artist</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ artists }" var="artist">
				<tr id="item-${artist.getArtistId() }">
					<td><c:out value="${ artist.getArtistId() }"></c:out></td>
					<td><a href="/albums?ArtistId=${ artist.getArtistId() }"
						title="Albums"> <c:out value="${ artist.getArtistName() }"></c:out>
					</a></td>
					<td>
						<button id="remove_button"
							onclick="removeItem(${ artist.getArtistId() })">Remove</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script src="/scripts/app.js"></script>
</body>
</html>