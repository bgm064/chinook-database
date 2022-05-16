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
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			// tarkistetaan onko albumi jo tietokannassa
			List<Album> items = getAllItems(newAlbum.getArtistId());

			for (Album listItem : items) {
				if (listItem.getAlbumTitle().equalsIgnoreCase(newAlbum.getAlbumTitle())
						&& listItem.getArtistId() == newAlbum.getArtistId()) {
					return false;
				}
			}

			connection = db.connect();
			statement = connection.prepareStatement("INSERT INTO Album (Title, ArtistId) VALUES (?, ?)",
					statement.RETURN_GENERATED_KEYS);
			statement.setString(1, newAlbum.getAlbumTitle());
			statement.setLong(2, newAlbum.getArtistId());
			int count = statement.executeUpdate();

			results = statement.getGeneratedKeys();
			results.next();

			int generatedId = results.getInt(1);
			newAlbum.setAlbumId(generatedId);

			// tarkistetaan lisättiinkö uusi rivi
			if (count > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(results, statement, connection);
		}

		return false;
	}

	@Override
	public boolean removeAlbum(long artistId) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {

			connection = db.connect();
			statement = connection.prepareStatement("DELETE FROM Album WHERE AlbumId = ?");

			statement.setLong(1, artistId);

			if (statement.executeUpdate() > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(results, statement, connection);
		}

		return false;
	}

}
