/**
 * 
 */
package com.albums.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.albums.service.AlbumService;
import com.albums.vo.Album;

/**
 * @author pragathiReddy
 *
 */

@RestController
public class AlbumController {

	
	@Autowired
	AlbumService albumService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/album")
	public Album createAlbum(@RequestBody Album album) {
		System.out.println(album);
		Album resAlbum = albumService.createAlbumService(album);;
		
		return resAlbum;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/albums")
	public List<Album> createAlbums(@RequestParam("file") MultipartFile inputFile) {
		List<Album> resAlbums = albumService.createAlbumsService(inputFile);
		
		return resAlbums;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/albums")
	public List<Album> getAlbums() {
		List<Album> resAlbums =null;
		resAlbums=albumService.getAlbumsService();
		return resAlbums;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/album")
	public Album getAlbum(@RequestParam("albumname") String albumName) {
		 Album resAlbum = albumService.getAlbumService(albumName);
		return resAlbum;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/album")
	public Album updateAlbum(@RequestBody  Album album) {
		Album resAlbum= albumService.updateAlbumService(album);
		return resAlbum;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/album/{albumName}")
	public void deleteAlbum(@PathVariable("albumName") String albumName) {
		System.out.println(albumName);
		albumService.deleteAlbumService(albumName);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("albums/artist")
	public List<Album> getArtistAlbums(@RequestParam("artist") String artist) {
		List<Album> resAlbums = albumService.getArtistAlbumsService(artist);
		return resAlbums;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/artists")
	public List<String> getArtists() {
		List<String> resArtists = albumService.getArtistsService();
		return resArtists;
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/albums?{index}")
	public List<Album> getAlbums(@RequestParam("index") String index) {
		List<Album> resAlbums = albumService.getAlbumsService(index);
		return resAlbums;
	}
	

}
