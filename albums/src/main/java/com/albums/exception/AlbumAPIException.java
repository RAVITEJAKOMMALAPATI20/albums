/**
 * 
 */
package com.albums.exception;

/**
 * @author pragathiReddy
 *
 */
public class AlbumAPIException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public AlbumAPIException(){
        super();
    }
	
	public AlbumAPIException(String message) {
		super(message);
	}
}
