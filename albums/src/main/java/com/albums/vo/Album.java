/**
 * 
 */
package com.albums.vo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 * @author pragthiReddy
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(
	name = "Album.getArtistAlbums",
	query = "select U from Album U where U.artist = :artist"
	),
	@NamedQuery(
			name = "Album.getAlbums",
			query = "select U from Album U"
			),
	/*@NamedQuery(
		name = "Album.getAlbumsWithArtistIndex",
		query = "select U from Album U where U.artist REGEXP :index"
		)*/
	@NamedQuery(
		name = "Album.getDistinctArtists",
		query = "select DISTINCT U.artist from Album U"
		)
})
public class Album {

	
	@Id
	private String albumName;
	private String artist;
	private String genre;
	private int year;
	

	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	@Override
	public String toString() {
		return " [albumName=" + albumName + ", artist=" + artist + ", genre=" + genre + ", year=" + year + "]";
	}
	
	
	
}
