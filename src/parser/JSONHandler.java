package parser;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import parser.objects.Connectible;
import parser.objects.Connection;
import parser.objects.Flow;
import parser.objects.HumanSystem;
import parser.objects.MainBody;
import parser.objects.Organ;
import parser.objects.TractConnectible;
import parser.objects.TubeConnectible;
import parser.objects.VolumeConnectible;

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
		JsonReader reader;

		try {
			reader = Json.createReader(new FileReader(this.filename));
			JsonObject jRoot = reader.readObject();

			JsonObject jBody = jRoot.getJsonObject("MainBody");
			body = new MainBody(jBody.getString("bodyName"), jBody.getInt("bodyID"));

			JsonArray jSystems = jBody.getJsonArray("Systems");

			for (int i = 0; i < jSystems.size(); i++) {
				JsonObject jSystem = jSystems.getJsonObject(i);

				system = new HumanSystem(jSystem.getString("name"), jSystem.getInt("id"), jSystem.getString("type"));
				body.addSystem(system);

				JsonArray jFlows = jSystem.getJsonArray("Flows");

				for (int f = 0; f < jFlows.size(); f++) {
					JsonObject jFlow = jFlows.getJsonObject(f);
					
					flow = new Flow(jFlow.getString("name"), jFlow.getInt("id"));
					system.addFlow(flow);
					
					JsonArray jConnectibles = jFlow.getJsonArray("Connectible");

					for (int c = 0; c < jConnectibles.size(); c++) {
						JsonObject jConnectible = jConnectibles.getJsonObject(c);
						String type = jConnectible.getString("type");
						String name = jConnectible.getString("name");
						int id = jConnectible.getInt("id");
						
						double volume, length, startRadius, endRadius;
						
						switch (type) {
						case "Atrium":
						case "Ventricle":
						case "Capillaries":
						case "Alveoli":
							volume = jConnectible.getJsonNumber("volume").doubleValue();
							
							connectible = new VolumeConnectible(name, id, type, volume);
							break;
							
						case "Artery":
						case "Vein":
						case "AirConnectible":
							startRadius = jConnectible.getJsonNumber("startRadius").doubleValue();
							endRadius = jConnectible.getJsonNumber("endRadius").doubleValue();
							length = jConnectible.getJsonNumber("length").doubleValue();
							
							connectible = new TubeConnectible(name, id, type, startRadius, endRadius, length);
							break;
							
						case "DigestiveTract":
						case "StomachTract":
						case "DuodenumTract":
						case "RectumTract":
						case "SalivaryDuct":
							volume = jConnectible.getJsonNumber("volume").doubleValue();
							length = jConnectible.getJsonNumber("length").doubleValue();
							
							connectible = new TractConnectible(name, id, type, length, volume);
							break;
						}

						flow.addConnectible(connectible);
					}

					JsonArray jConnections = jFlow.getJsonArray("Connections");

					for (int c = 0; c < jConnections.size(); c++) {
						JsonObject jConnection = jConnections.getJsonObject(c);
						connection = new Connection(jConnection.getInt("id"));

						JsonArray jTo = jConnection.getJsonArray("to");
						for (int t = 0; t < jTo.size(); t++) {
							int to = jTo.getJsonNumber(t).intValue();
							connection.addTargetId(to);
						}
						
						flow.addConnection(connection);
					}
				}
			}
			
			JsonArray jOrgans = jBody.getJsonArray("Organs");

			for (int i = 0; i < jOrgans.size(); i++) {
				JsonObject jOrgan = jOrgans.getJsonObject(i);

				organ = new Organ(jOrgan.getString("name"), jOrgan.getInt("id"), jOrgan.getInt("systemID"));
				body.addOrgan(organ);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
