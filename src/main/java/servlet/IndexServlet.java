package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.AlbumDao;
import database.ArtistDao;
import database.JDBCAlbumDao;
import database.JDBCArtistDao;

@SuppressWarnings("serial")
@WebServlet("")
public class IndexServlet extends HttpServlet {
	private ArtistDao artistDao = new JDBCArtistDao();
	private AlbumDao albumDao = new JDBCAlbumDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int artistCount = artistDao.getCount();
		int albumCount = albumDao.getCount();

		req.setAttribute("artistCount", artistCount);
		req.setAttribute("albumCount", albumCount);
		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}

}
