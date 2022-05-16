package model;

public class Artist {
	private long artistId;
	private String artistName;
	
	public Artist(String name) {
		this.artistName = name;
	}
	
	public Artist(long artist, String name) {
		this.artistId = artist;
		this.artistName = name;
	}
	
	public long getArtistId() {
		return this.artistId;
	}
	
	public String getArtistName() {
		return this.artistName;
	}
	
	public void setArtistId(long artist) {
		this.artistId = artist;
	}
	
}