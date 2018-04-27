package listeners;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Movie;

@Stateless
public class MovieBeanListener implements MovieBeanListenerRemote {

	@PersistenceContext
	private EntityManager em;
	
	public List<Movie>  listMovies(){
		return em.createNamedQuery("Movie.findAll", Movie.class).getResultList();
	}
	
	public void createMovie(Movie m) {
		em.persist(m);
		em.flush();
	}
	
	public Movie getMovieById(int id) {
		return em.createNamedQuery("Movie.findById",Movie.class).setParameter("id", id).getSingleResult();
	}
	
	public void removeMovieById(int id) {
		Movie m=em.createNamedQuery("Movie.findById",Movie.class).setParameter("id", id).getSingleResult();
		em.remove(m);
		em.flush();
	}
	
	public void updateMovie() {
        Movie m = em.createNamedQuery("Movie.findByName", Movie.class)
            .setParameter("name", "Inception")
            .getSingleResult();
        m.setName("Inception2");
        em.merge(m);
        em.flush();
    }

    public void deleteMovie() {
        Movie m = em.createNamedQuery("Movie.findByName", Movie.class)
            .setParameter("name", "Inception2")
            .getSingleResult();
        em.remove(m);
        em.flush();
    }
    

}
