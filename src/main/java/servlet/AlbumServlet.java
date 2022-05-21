package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.AlbumDao;
import database.ArtistDao;
import database.JDBCAlbumDao;
import database.JDBCArtistDao;
import model.Album;
import model.Artist;

@SuppressWarnings("serial")
@WebServlet("/albums")
public class AlbumServlet extends HttpServlet {
	private AlbumDao albumDao = new JDBCAlbumDao();
	private ArtistDao artistDao = new JDBCArtistDao();

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long artistId = Long.parseLong(req.getParameter("ArtistId"));
		List<Album> albums = albumDao.getAllItems(artistId);
		Artist artist = artistDao.getArtist(artistId);

		req.setAttribute("albums", albums);
		req.setAttribute("artists", artist);
		req.getRequestDispatcher("/WEB-INF/albums.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long artistId = Long.parseLong(req.getParameter("ArtistId"));
		String name = req.getParameter("name");
		Album newAlbum = new Album(artistId, name);

		albumDao.addAlbum(newAlbum);
		resp.sendRedirect("/albums?ArtistId=" + artistId);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		long id = Long.parseLong(req.getParameter("id"));

		albumDao.removeAlbum(id);
	}

}
