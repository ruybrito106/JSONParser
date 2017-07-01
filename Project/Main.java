import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

  public static void main(String[] args) {
	Parser parser = new Parser();
	try {
		parser.parseFileMovie(new FileReader("./Input/banco_filmes.json"));
		parser.parseFileUser(new FileReader("./Input/banco_usuarios.json"));
		
		//Tira os comentarios abaixo pra testar os parsers
		//parser.testMovies();
		//parser.testUsers();
	} catch (FileNotFoundException ex) {
		ex.printStackTrace();
	}
  }

}
