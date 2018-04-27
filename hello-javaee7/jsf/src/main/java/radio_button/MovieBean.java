package radio_button;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class MovieBean implements Serializable {

	private List<Movie> list;

	@PostConstruct
	private void init() {
		list = Arrays.asList(new Movie(1, "The Matrix", "Keanu Reeves"),
				new Movie(2, "The Lord of the Rings", "Elijah Wood"),
				new Movie(3, "The Inception", "Leonardo Dicaprio"));
	}

	int selected;

	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}

	public List<Movie> getAll() {
		return list;
	}

	public Movie getSelectedMovie() {
		return list.get(selected - 1);
	}
}
