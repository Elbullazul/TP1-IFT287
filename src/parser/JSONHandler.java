package parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.json.Json;
import javax.json.stream.JsonParser;

import parser.objects.Connectible;
import parser.objects.Connection;
import parser.objects.Flow;
import parser.objects.HumanSystem;
import parser.objects.MainBody;
import parser.objects.Organ;

public class JSONHandler {
	private String filename;
	
	private MainBody body;
	private HumanSystem system;
	private Flow flow;
	private Connectible connectible;
	private Connection connection;
	private Organ organ;
	
	public JSONHandler(String filename) {
		this.filename = filename;
    }
	
	public MainBody getBody() {
		return body;
	}
	
	public void parse() {
        String content = "";
		try {
			content = Files.readString(Paths.get(filename));
			
			JsonParser parser = Json.createParser(new StringReader(content));
			while (parser.hasNext()) {
				JsonParser.Event event = parser.next();
				switch (event) {
				case START_ARRAY:
				case END_ARRAY:
				case START_OBJECT:
				case END_OBJECT:
				case VALUE_FALSE:
				case VALUE_NULL:
				case VALUE_TRUE:
					break;
				case KEY_NAME:
				case VALUE_STRING:
				case VALUE_NUMBER:
					parser.getString();
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
