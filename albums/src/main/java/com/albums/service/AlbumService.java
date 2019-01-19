/**
 * 
 */
package com.albums.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.albums.dao.AlbumDAO;
import com.albums.exception.AlbumAPIValidationException;
import com.albums.vo.Album;

/**
 * @author pragathiReddy
 *
 */
@Service
public class AlbumService {

	
	@Autowired
	AlbumDAO albumDAO;
	
public Album createAlbumService(Album album) {
		
		if(album.getAlbumName()==null||album.getArtist()==null||album.getArtist()==null||album.getYear()==0) {
			throw new AlbumAPIValidationException("Invalid Input Data");
		}
		
		Album resalbum = albumDAO.createAlbumDAO(album);
		
		
		return resalbum;
	}
	
public Album getAlbumService(String albumName) {
	
	if(albumName==null) {
		throw new AlbumAPIValidationException("Invalid Input Data");
	}
	Album resalbum = albumDAO.getAlbumDAO(albumName);
	
	
	return resalbum;
}


public List<Album> getAlbumsService() {
	
	
	List<Album> resalbums = albumDAO.getAlbumsDAO();
	
	
	return resalbums;
}
public Album updateAlbumService(Album album) {
	if(album.getAlbumName()==null||album.getArtist()==null||album.getArtist()==null||album.getYear()==0) {
		throw new AlbumAPIValidationException("Invalid Input Data");
	}
	
	Album resalbum = albumDAO.updateAlbumDAO(album);
	
	return resalbum;
}
public void deleteAlbumService(String albumName) {
    if(albumName==null||albumName.trim().length()==0) {
    	throw new AlbumAPIValidationException("Invalid Input Data");
	}
	albumDAO.deleteAlbumDAO(albumName);
}
public List<Album> getAlbumsService(String index) {
	
	if(index==null) {
		throw new AlbumAPIValidationException("Invalid Input Data");
	}
	List<Album> resalbums = albumDAO.getAlbumsDAO(index);
	
	
	return resalbums;
}
public List<Album> getArtistAlbumsService(String artist) {
	
	if(artist==null||artist.trim().length()==0) {
		throw new AlbumAPIValidationException("Invalid Input Data");
	}
	List<Album> resalbums = albumDAO.getArtistAlbumsDAO(artist);
	
	return resalbums;
}

public List<String> getArtistsService() {
	
	
	List<String> resartists = albumDAO.getArtistsDAO();
	
	return resartists;
}

public List<Album> createAlbumsService(MultipartFile file){
	
	List<Album> inputAlbums = extractData(file);
	List<Album> resAlbums= albumDAO.createAlbumsDAO(inputAlbums);
	return resAlbums;
}

public List<Album> extractData(MultipartFile file) {
	
	if(file!=null&!file.isEmpty()) {
		try {
			String completeData = new String(file.getBytes());
            String[] rows = completeData.split("\n");
            List<Album> albumsList = new ArrayList<Album>();
            for(int i=1;i<rows.length;i++) {
            	Album album = new Album();
            	String[] columns = rows[i].split(",");
            	if(columns==null||columns.length!=4||columns[0]==null||columns[1]==null||columns[2]==null||columns[3]==null)continue;
            	album.setAlbumName(columns[0].trim());
            	album.setArtist(columns[1].trim());
            	album.setGenre(columns[2].trim());
            	try {
            	int year = Integer.parseInt(columns[3].trim());
            	album.setYear(year);
            	}catch(NumberFormatException  ex) {
            		continue;
            	}
            	albumsList.add(album);
            }
            return albumsList;
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}
	
	return null;
}
}
