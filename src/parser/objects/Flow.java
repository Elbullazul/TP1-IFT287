package parser.objects;

import java.util.ArrayList;
import parser.JSONObject;

public class Flow extends BaseObject {
	private ArrayList<Connectible> connectibles;
	private ArrayList<Connection> connections;

	public Flow(String name, int id) {
		super(name, id);
		
		this.connectibles = new ArrayList<Connectible>();
		this.connections = new ArrayList<Connection>();
	}
	
	public ArrayList<Connectible> getConnectibles() {
		return connectibles;
	}

	public void addConnectible(Connectible connectible) {
		this.connectibles.add(connectible);
	}

	public ArrayList<Connection> getConnections() {
		return connections;
	}

	public void addConnection(Connection connection) {
		this.connections.add(connection);
	}

	@Override
	public JSONObject toJSON() {
		JSONObject j = new JSONObject();
		
		j.openObject();
		j.addAttibute("name", this.name, true);
		j.addAttibute("id", this.id, true);
		j.openArray("Connectibles");
		
		int count = 1;
		for (Connectible cnn: this.connectibles) {
			JSONObject jo = cnn.toJSON();
			j.addObject(jo, (count != this.connectibles.size()));
			count++;
		}
		
		j.closeArray();
		j.newLine();
		j.openArray("Connections");

		count = 1;
		for (Connection cnn: this.connections) {
			JSONObject jo = cnn.toJSON();
			j.addObject(jo, (count != this.connections.size()));
			count++;
		}
		
		j.closeArray();
		j.closeObject();
		
		return j;
	}

	@Override
	public String toXML() {
		return null;
	}
}
