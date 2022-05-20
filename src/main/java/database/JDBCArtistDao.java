package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Artist;

public class JDBCArtistDao implements ArtistDao {
	private Database db = new Database();

	@Override
	public List<Artist> getAllItems() {
		String selectAll = "SELECT ArtistId, Name FROM Artist ORDER BY Name ASC;";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		List<Artist> items = new ArrayList<Artist>();

		try {
			connection = db.connect();
			statement = connection.prepareStatement(selectAll);
			results = statement.executeQuery();

			while (results.next()) {
				long artistId = results.getLong("ArtistId");
				String artistName = results.getString("Name");

				Artist newArtist = new Artist(artistId, artistName);
				items.add(newArtist);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(results, statement, connection);
		}

		return items;
	}

	@Override
	public Artist getArtist(long id) {
		List<Artist> items = getAllItems();

		for (Artist item : items) {
			if (item.getArtistId() == id) {
				return new Artist(item.getArtistId(), item.getArtistName());
			}
		}

		return null;
	}

	@Override
	public boolean addArtist(Artist newArtist) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			// tarkistetaan onko artisti jo tietokannassa
			List<Artist> items = getAllItems();

			for (Artist listItem : items) {
				if (listItem.getArtistName().equalsIgnoreCase(newArtist.getArtistName())) {
					return false;
				}
			}

			connection = db.connect();
			statement = connection.prepareStatement("INSERT INTO Artist (Name) VALUES (?)",
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, newArtist.getArtistName());
			int count = statement.executeUpdate();

			results = statement.getGeneratedKeys();
			results.next();

			int generatedId = results.getInt(1);
			newArtist.setArtistId(generatedId);

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
	public boolean removeArtist(Artist artist) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		List<Artist> items = getAllItems();

		try {

			connection = db.connect();
			statement = connection.prepareStatement("DELETE FROM Artist WHERE ArtistId = ?");

			for (Artist listItem : items) {
				if (artist.getArtistId() == listItem.getArtistId()) {
					statement.setLong(1, listItem.getArtistId());

					if (statement.executeUpdate() > 0) {
						return true;
					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(results, statement, connection);
		}

		return false;
	}

}
