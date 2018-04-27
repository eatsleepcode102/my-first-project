package criteria;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import entities.Movie;

@StaticMetamodel(Movie.class)
public class Movie_ {

    public static volatile SingularAttribute<Movie, Integer> id;
    public static volatile SingularAttribute<Movie, String> name;
    public static volatile SingularAttribute<Movie, String> actors;

}
