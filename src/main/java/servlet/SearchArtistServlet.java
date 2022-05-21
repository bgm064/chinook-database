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
@WebServlet("/artists/search")
public class SearchArtistServlet extends HttpServlet {
	private ArtistDao artistDao = new JDBCArtistDao();
	private AlbumDao albumDao = new JDBCAlbumDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword = req.getParameter("q");
		List<Artist> artists = artistDao.searchArtist(keyword);

		req.setAttribute("keyword", keyword);
		req.setAttribute("artists", artists);
		req.getRequestDispatcher("/WEB-INF/search.jsp").forward(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		long id = Long.parseLong(req.getParameter("id"));
		Artist artist = artistDao.getArtist(id);

		artistDao.removeArtist(artist);
		albumDao.removeAlbum(artist.getArtistId());
	}

}
