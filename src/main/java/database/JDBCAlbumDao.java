package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Album;
import model.Artist;

public class JDBCAlbumDao implements AlbumDao {
	private Database db = new Database();

	@Override
	public List<Album> getAllItems(long artist) {
		String selectAll = "SELECT AlbumId, Title, ArtistId FROM Album WHERE ArtistId = ?;";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		List<Album> items = new ArrayList<Album>();

		try {
			connection = db.connect();
			statement = connection.prepareStatement(selectAll);
			statement.setLong(1, artist);
			results = statement.executeQuery();

			while (results.next()) {
				long artistId = results.getLong("ArtistId");
				long albumId = results.getLong("AlbumId");
				String albumTitle = results.getString("Title");

				Album newAlbum = new Album(artistId, albumId, albumTitle);
				items.add(newAlbum);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(results, statement, connection);
		}

		return items;
	}

	@Override
	public boolean addAlbum(Album newAlbum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAlbum(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
