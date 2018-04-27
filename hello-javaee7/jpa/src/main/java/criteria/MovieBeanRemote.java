package criteria;

import java.util.List;

import javax.ejb.Remote;

import entities.Movie;

@Remote
public interface MovieBeanRemote {

	public List<Movie> listMovies();
	public void updateMovie();
	public void deleteMovie();
}
