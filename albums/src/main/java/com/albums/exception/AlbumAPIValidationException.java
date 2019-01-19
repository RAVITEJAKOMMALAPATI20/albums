/**
 * 
 */
package com.albums.exception;

/**
 * @author pragathiReddy
 *
 */
public class AlbumAPIValidationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AlbumAPIValidationException(){
        super();
    }
	
	public AlbumAPIValidationException(String message) {
		super(message);
	}
}
