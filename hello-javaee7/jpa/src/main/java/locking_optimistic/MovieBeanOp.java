package locking_optimistic;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Movie1;

@Stateless
public class MovieBeanOp implements MovieBeanOpRemote {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Movie1> listMovies(){
		return em.createNamedQuery("movie.findAll", Movie1.class).getResultList();
	}
	
	public Movie1 findMovie(Integer id) {
		return em.find(Movie1.class, id);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Movie1 readMovie(Integer id) {
		return em.find(Movie1.class, id);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void updateMovie(Integer id, String name) {
        Movie1 movie = findMovie(id);
        em.lock(movie, javax.persistence.LockModeType.OPTIMISTIC);
        movie.setName(name);
        em.merge(movie);
        em.flush();
    }
	
	public void updateMovie2(Integer id, String name) {
        Movie1 movie = findMovie(id);
        em.lock(movie, javax.persistence.LockModeType.OPTIMISTIC);
        movie.setName(name);
        em.merge(movie);
        em.flush();
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void updateMovie(Movie1 movie, String name) {
        em.lock(movie, javax.persistence.LockModeType.OPTIMISTIC);
        movie.setName(name);
        em.merge(movie);
        em.flush();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deleteMovie(Integer id) {
        em.remove(findMovie(id));
    }
}
