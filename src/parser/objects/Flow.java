package parser.objects;

import java.util.ArrayList;

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
	public String toJSON() {
		String format = 
				"\"Flow\": {\n" +
				"    \"name\": \"%s\",\n" +
				"    \"id\": %d\n" +
				"    \"Connectibles\": {\n";
		
		for (Connectible cnn: this.connectibles) {
			format += cnn.toJSON() + ",";
		}
		
		format +=
				"    }\n" +
				"};\n";
		
		return String.format(format, this.name, this.id);
	}

	@Override
	public String toXML() {
		return null;
	}
}
