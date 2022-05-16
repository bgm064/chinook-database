package model;

public class Album {
	private long artistId;
	private long albumId;
	private String albumTitle;
	
	public Album(long artist, String title) {
		this.artistId = artist;
		this.albumTitle = title;
	}
	
	public Album(long artist, long album, String title) {
		this.artistId = artist;
		this.albumId = album;
		this.albumTitle = title;
	}
	
	public long getArtistId() {
		return this.artistId;
	}
	
	public long getAlbumId() {
		return this.albumId;
	}
	
	public String getAlbumTitle() {
		return this.albumTitle;
	}
	
	public void setAlbumId(long album) {
		this.albumId = album;
	}
	
}
