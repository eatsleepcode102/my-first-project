package listeners;

import java.util.List;

import javax.ejb.Remote;

import entities.Movie;

@Remote
public interface MovieBeanListenerRemote {

	public List<Movie> listMovies();

	public void createMovie(Movie m);

	public void updateMovie();

	public void deleteMovie();
	
	public Movie getMovieById(int id);
	
	public void removeMovieById(int id);
}
