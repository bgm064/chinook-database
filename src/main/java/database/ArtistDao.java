package database;

import java.util.List;
import model.Artist;

public interface ArtistDao {
	public List<Artist> getAllItems();

	public Artist getArtist(long id);

	public boolean addArtist(Artist newArtist);

	public boolean removeArtist(Artist artist);

}
