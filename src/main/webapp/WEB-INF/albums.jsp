<%@ page contentType="text/html; encoding=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Albums | 💿 | Music Library</title>
<link rel="stylesheet"
	href="https://unpkg.com/sakura.css/css/sakura-dark.css" type="text/css">
<style>
#remove_button, #back_button, #search_form {
	float: right;
}

#search_button:hover, #add_button:hover, #back_button:hover {
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

	<h1>
		Albums by
		<c:out value="${ artists.getArtistName() }"></c:out>
	</h1>

	<form method="POST">
		<input name="name" type="text" required
			placeholder="type artist here..." autofocus /> <input id="add_button"  type="submit"
			value="Add to database" /> <input id="back_button" type="button"
			value="Back" onclick="window.location.href='/artists';">
	</form>

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Album</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ albums }" var="album">
				<tr id="item-${ album.getAlbumId() }">
					<td><c:out value="${ album.getAlbumId() }"></c:out></td>
					<td><c:out value="${ album.getAlbumTitle() }"></c:out></td>
					<td>
						<button id="remove_button"
							onclick="removeItem(${ album.getAlbumId() })">Remove</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script src="/scripts/app.js"></script>
</body>
</html>