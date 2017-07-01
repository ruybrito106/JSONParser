import java.util.List;

public class User {

	private String name;
	private String age;
	private List<Country> countries;
	private List<Actor> actors;
	private List<Genre> genres;
	private String style;
	
	public User(String name, String age, List<Country> countries, List<Actor> actors, List<Genre> genres, String style) {
		this.name = name;
		this.age = age;
		this.countries = countries;
		this.actors = actors;
		this.genres = genres;
		this.style = style;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

}
