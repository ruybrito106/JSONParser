public class Genre {

	private String name;
	private String preference;
	
	public Genre(String name, String preference) {
		this.name = name;
		this.preference = preference;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}
	
}
