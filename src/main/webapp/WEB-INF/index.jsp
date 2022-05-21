<%@ page contentType="text/html; encoding=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
<head>
<title>Home | 🎵 | Music Library</title>
<link rel="stylesheet"
	href="https://unpkg.com/sakura.css/css/sakura-dark.css" type="text/css">
<style>
h1, div {
	text-align: center;
}

#timer, #ascii_art {
	color: #735BC1;
}
</style>
<meta http-equiv="refresh" content="15; url=/artists" />
</head>
<h1>Welcome to the Music Library!</h1>
<br>
<div>
	There are currently <b><c:out value="${ artistCount }"></c:out>
		artists</b> with <b><c:out value="${ albumCount }"></c:out> albums</b> in
	the database.<br> <a href="/artists">Click here to access the
		database.</a> Redirecting automatically in <span id="timer">15 </span>
	seconds.
</div>
<br>
<div id="ascii_art">
	<b>⠀⠀⠀⠀⣠⣤⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⣿⡟⠛⠿⢿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⣤⣀⠀⠀⠀
		⠀⠀⠀⠀⠸⣿⡀⠀⠀⠙⠷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣏⠉⠛⠻⣷⡄⠀ ⠀⠀⠀⠀⠀⢿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⡆⠀⠀⠈⠳⠀
		⠀⠀⠀⠀⠀⠘⣿⡄⠀⠀⠀⠀⠀⠀⠀⣀⠀⠀⠀⠀⠀⠀⠀⠹⣿⡀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⢹⣧⠀⠀⠀⠀⠀⠀⠀⣿⡿⣿⣶⣄⠀⠀⠀⠀⢻⣧⠀⠀⠀⠀
		⠀⠀⠀⠀⠀⠀⠈⣿⡆⠀⠀⠀⠀⠀⠀⣿⡇⠀⠙⢿⣧⠀⠀⠀⠀⢿⡄⠀⠀⠀ ⠀⠀⠀⣀⣤⣤⣤⣼⣷⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⢻⠀⠀⠀⠀⠈⣷⠀⠀⠀
		⠀⢠⣾⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⠀⠀⣀⣤⣤⣤⣾⣧⠀⠀ ⠀⢻⣿⣿⣿⣿⣿⣿⠟⠁⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⡆⠀
		⠀⠀⠈⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⠻⣿⣿⣿⣿⣿⡿⠋⠀⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⣄⣀⡀⣻⡇⠀⠀⠀⠀⠈⠉⠉⠉⠁⠀⠀⠀⠀
		⠀⠀⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⠀⠀⠙⢿⣿⣿⣿⣿⣿⡿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
		⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀</b>
</div>
<script src="/scripts/timer.js"></script>
<script>
	var timeleft = 15;
	var downloadTimer = setInterval(function() {
		timeleft--;
		document.getElementById("timer").textContent = timeleft;
		if (timeleft <= 0)
			clearInterval(downloadTimer);
	}, 1000);
</script>
</body>
</html>