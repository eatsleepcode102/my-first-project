package locking_optimistic;

import java.util.List;

import javax.ejb.Remote;

import entities.Movie1;

@Remote
public interface MovieBeanOpRemote {

	public List<Movie1> listMovies();
	
	public Movie1 findMovie(Integer id);
	
	public Movie1 readMovie(Integer id);
	
	public void updateMovie(Integer id, String name);
	
	public void updateMovie2(Integer id, String name);
	
	public void updateMovie(Movie1 movie, String name);
	
	public void deleteMovie(Integer id);
}
