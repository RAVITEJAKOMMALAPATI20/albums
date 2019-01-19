/**
 * 
 */
package com.albums.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.albums.vo.Album;


/**
 * @author pragathiReddy
 *
 */
@Repository
@Transactional
@Component
public class AlbumDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
public Album createAlbumDAO(Album album) {
		
	    entityManager.persist(album);
	     
	    flushAndClear();
		return album;
	}

public Album getAlbumDAO(String albumName) {
	
	
	Album resalbum = entityManager.find(Album.class, albumName);
    
    
	flushAndClear();
	return resalbum;
}

public List<Album> getAlbumsDAO() {
	List<Album> resAlbums =null;
	
	TypedQuery<Album> query =  entityManager.createNamedQuery("Album.getAlbums", Album.class);
	resAlbums = query.getResultList();
    
	flushAndClear();
	return resAlbums;
}
public Album updateAlbumDAO(Album album) {
	
	Album resalbum = entityManager.merge(album);
	
	flushAndClear();
	return resalbum;
}
public void deleteAlbumDAO(String albumName) {
	Album album = entityManager.find(Album.class, albumName);
	if(album!=null)
	entityManager.remove(album);
	flushAndClear();
}

public List<Album> getAlbumsDAO(String index) {
	List<Album> resAlbums =null;
	//TypedQuery<Album> query = entityManager.createNamedQuery("Album.getAlbumsWithArtistIndex",Album.class);
	//query.setParameter("artist", "^"+index);
	//resAlbums = query.getResultList();
	
	//flushAndClear();
	return resAlbums;
}


public List<String> getArtistsDAO() {
	List<String> resArtists =null;
	TypedQuery<String> query = entityManager.createNamedQuery("Album.getDistinctArtists",String.class);
	resArtists = query.getResultList();
	flushAndClear();
	return resArtists;
}

public List<Album> getArtistAlbumsDAO(String artist) {
	List<Album> resAlbums =null;
	TypedQuery<Album> query = entityManager.createNamedQuery("Album.getArtistAlbums",Album.class);
	query.setParameter("artist", artist);
	resAlbums = query.getResultList();
	
	flushAndClear();
	return resAlbums;
}





public List<Album> createAlbumsDAO(List<Album> albums) {
	int batchsize = 0;
	for(Album album:albums) {
		if(entityManager.find(Album.class, album.getAlbumName())==null) {
			entityManager.persist(album);
		}else {
			entityManager.merge(album);
		}
		batchsize++;
    if(batchsize%100==0) {
    	flushAndClear();
    }
	}
    
    flushAndClear();
	return albums;
}


private void flushAndClear() {
	entityManager.flush();
    entityManager.clear();
}
}


