import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Parser {

	private List<Movie> movies;
	private List<User> users;

	public Parser() {
		this.movies = new ArrayList<Movie>();
		this.users = new ArrayList<User>();
	}

	public void appendMovie(Movie movie) {
		this.movies.add(movie);
	}

	public void appendUser(User user) {
		this.users.add(user);
	}

	public List<Movie> getMovies() {
		return this.movies;
	}

	public List<User> getUsers() {
	    return this.users;
	  }

	public void processMovie(JSONObject obj) {
		String title = (String) obj.get("Title");
		String rated = (String) obj.get("Rated");
		String genreStr = (String) obj.get("Genre");
		String[] genre = genreStr.split(",");
		String director = (String) obj.get("Director");
		String actorStr = (String) obj.get("Actors");
		String[] actors = new String[0];
		if (actorStr != null) actors = actorStr.split(",");
		String countryStr = (String) obj.get("Country");
		String[] countries = countryStr.split(",");
		String rating = (String) obj.get("imdbRating");
		String boxOffice = (String) obj.get("BoxOffice");
		this.appendMovie(new Movie(title, rated, genre, director, actors, countries, rating, boxOffice));
	}

  public void parseFileMovie(FileReader file) {
    JSONParser parser = new JSONParser();
    try {
      JSONObject mainObj = (JSONObject) parser.parse(file);
      JSONArray arr = (JSONArray) mainObj.get("Filmes");
      Iterator<JSONObject> it = arr.iterator();
      JSONObject obj;
      while (it.hasNext()) processMovie(it.next());
    } catch (IOException ex) {
      ex.printStackTrace();
    } catch (ParseException ex) {
      ex.printStackTrace();
    } catch (NullPointerException ex) {
      ex.printStackTrace();
    }
  }

  public void testMovies() {
	Movie movie;
	for(int i = 0; i < movies.size(); i++) {
		movie = movies.get(i);
		System.out.println("Titulo: " + movie.getTitle());
		System.out.println("IMDB rating: " + movie.getRating());
		System.out.println("Lista de atores: ");
		for(int j = 0; j < movie.getActors().length; j++) {
			System.out.println(" - " + (movie.getActors())[j]);
		}
	}
  }

  public void processUser(JSONObject obj) {
	  String name = (String) obj.get("Name");
	  String age = (String) obj.get("Age");
	  String style = (String) obj.get("Style");
	  
	  // Parsing genres block
	  List<Genre> genres = new ArrayList<Genre>();
	  JSONArray GObj = (JSONArray) obj.get("Genres");
	  String genreName, genrePref;
	  Iterator<JSONObject> it = GObj.iterator();
	  JSONObject currentGenre;
	  while (it.hasNext()) {
		  currentGenre = it.next();
		  genreName = (String) currentGenre.get("Name");
		  genrePref = (String) currentGenre.get("Preference");
		  genres.add(new Genre(genreName, genrePref));
	  }
	  
	  // Parsing actors block
	  List<Actor> actors = new ArrayList<Actor>();
	  JSONArray AObj = (JSONArray) obj.get("Actors");
	  String actorName, actorPref;
	  Iterator<JSONObject> it1 = AObj.iterator();
	  JSONObject currentActor;
	  while (it1.hasNext()) {
		  currentActor = it1.next();
		  actorName = (String) currentActor.get("Name");
		  actorPref = (String) currentActor.get("Preference");
		  actors.add(new Actor(actorName, actorPref));
	  }
	  
	  // Parsing countries block
	  List<Country> countries = new ArrayList<Country>();
	  JSONArray CObj = (JSONArray) obj.get("Countries");
	  String countryName, countryPref;
	  Iterator<JSONObject> it2 = CObj.iterator();
	  JSONObject currentCountry;
	  while (it2.hasNext()) {
		  currentCountry = it2.next();
		  countryName = (String) currentCountry.get("Name");
		  countryPref = (String) currentCountry.get("Preference");
		  countries.add(new Country(countryName, countryPref));
	  }
	  
	  this.appendUser(new User(name, age, countries, actors, genres, style));
  }

  public void parseFileUser(FileReader file) {
	JSONParser parser = new JSONParser();
	try {
	  JSONObject mainObj = (JSONObject) parser.parse(file);
	  JSONArray arr = (JSONArray) mainObj.get("Users");
	  Iterator<JSONObject> it = arr.iterator();
	  JSONObject obj;
	  while (it.hasNext()) processUser(it.next());
	} catch (IOException ex) {
	  ex.printStackTrace();
	} catch (ParseException ex) {
	  ex.printStackTrace();
	} catch (NullPointerException ex) {
	  ex.printStackTrace();
	}
  }

  public void testUsers() {
	User user;
	for(int i = 0; i < users.size(); i++) {
		user = users.get(i);
		System.out.println("The user "+user.getName()+", aged "+user.getAge()+" years, likes the following:");
		System.out.println("Actors:");
		for(int j = 0; j < user.getActors().size(); j++) {
			System.out.println(" - "+user.getActors().get(j).getName() + ". Pref: "+user.getActors().get(j).getPreference());
		}
		System.out.println("Countries:");
		for(int j = 0; j < user.getCountries().size(); j++) {
			System.out.println(" - "+user.getCountries().get(j).getName() + ". Pref: "+user.getCountries().get(j).getPreference());
		}
		System.out.println("Genres:");
		for(int j = 0; j < user.getGenres().size(); j++) {
			System.out.println(" - "+user.getGenres().get(j).getName() + ". Pref: "+user.getGenres().get(j).getPreference());
		}
	}
  }
}
