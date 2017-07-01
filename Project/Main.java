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

import project.Movie;
import project.User;
import project.Parser;

public class Main {

  public static void main(String[] args) {
		Parser parser = new Parser();
		try {
			parser.parseFileMovie(new FileReader("banco_filmes.json"));
		  parser.parseFileMovie(new FileReader("banco_usuarios.json"));
		} catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
  }

}
