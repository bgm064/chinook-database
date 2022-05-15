package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.ArtistDao;
import database.JDBCArtistDao;
import model.Artist;

@SuppressWarnings("serial")
@WebServlet("/list")
public class ArtistServlet extends HttpServlet {

	private ArtistDao dao = new JDBCArtistDao();
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Artist> artists = dao.getAllItems();
		
		req.setAttribute("items", artists);
		req.getRequestDispatcher("/WEB-INF/artists.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Artist newArtist = new Artist(req.getParameter("name"));

		dao.addArtist(newArtist);
		resp.sendRedirect("/list");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		long id = Long.parseLong(req.getParameter("id"));
		Artist artist = dao.getArtist(id);
		
		dao.removeArtist(artist);
	}
	
}
