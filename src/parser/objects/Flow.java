package parser.objects;

import java.util.ArrayList;
import parser.JSONObject;
import parser.XMLObject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
		j.openArray("Connectible");
		
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
	public Element toXML(Document doc) {
		XMLObject xo = new XMLObject(doc);
		
		Element e = xo.newElement("Flow");
		e.setAttributeNode(xo.newAttribute("name", this.name));
		e.setAttributeNode(xo.newAttribute("id", this.id));
		
		Element connectible = xo.newElement("Connectible");
		
		for (Connectible cnn : this.connectibles) {
			connectible.appendChild(cnn.toXML(doc));
		}
		
		e.appendChild(connectible);
		
		Element connections = xo.newElement("Connections");
		
		for (Connection cnn : this.connections) {
			connections.appendChild(cnn.toXML(doc));
		}
		
		e.appendChild(connections);
		
		return e;
	}
}
