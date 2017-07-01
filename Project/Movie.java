public class Movie {

  private String title;
  private String rated;
  private String[] genre;
  private String director;
  private String[] actors;
  private String[] countries;
  private String rating;
  private String boxOffice;

  public Movie(String title, String rated, String[] genre, String director, String[] actors, String[] countries, String rating, String boxOffice) {
    this.title = title;
    this.rated = rated;
    this.genre = genre;
    this.director = director;
    this.actors = actors;
    this.countries = countries;
    this.rating = rating;
    this.boxOffice = boxOffice;
  }

  public String getTitle() {
	   return title;
  }

  public void setTitle(String title) {
	   this.title = title;
	}

  public String getRated() {
	   return rated;
	}

  public void setRated(String rated) {
	   this.rated = rated;
	}

  public String[] getGenre() {
	   return genre;
	}

  public void setGenre(String[] genre) {
	   this.genre = genre;
  }

  public String getDirector() {
  	return director;
  }

  public void setDirector(String director) {
  	this.director = director;
  }

  public String[] getActors() {
  	return actors;
  }

  public void setActors(String[] actors) {
  	this.actors = actors;
  }

  public String[] getCountries() {
  	return countries;
  }

  public void setCountries(String[] countries) {
  	this.countries = countries;
  }

  public String getRating() {
  	return rating;
  }

  public void setRating(String rating) {
  	this.rating = rating;
  }

  public String getBoxOffice() {
  	return boxOffice;
  }

  public void setBoxOffice(String boxOffice) {
  	this.boxOffice = boxOffice;
  }
  
}
