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
import model.Artist;

@SuppressWarnings("serial")
@WebServlet("/artists")
public class ArtistServlet extends HttpServlet {
	private ArtistDao artistDao = new JDBCArtistDao();
	private AlbumDao albumDao = new JDBCAlbumDao();
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Artist> artists = artistDao.getAllItems();
		
		req.setAttribute("items", artists);
		req.getRequestDispatcher("/WEB-INF/artists.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Artist newArtist = new Artist(req.getParameter("name"));

		artistDao.addArtist(newArtist);
		resp.sendRedirect("/artists");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		long id = Long.parseLong(req.getParameter("id"));
		Artist artist = artistDao.getArtist(id);
		
		artistDao.removeArtist(artist);
		albumDao.removeAlbum(artist.getArtistId());
	}
	
}
