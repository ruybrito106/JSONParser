package project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import project.User;
import project.Movie;

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
		String[] actors = actorStr.split(",");
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

  public void processUser() {

  }

  public void parseFileUser(FileReader file) {

  }

  public void testUsers() {

  }
}
