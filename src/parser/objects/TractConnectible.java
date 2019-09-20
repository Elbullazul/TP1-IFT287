package parser.objects;

import parser.JSONObject;
import parser.XMLObject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TractConnectible extends Connectible {
	private double length;
	private double volume;

	public TractConnectible(String name, int id) {
		super(name, id);
	}

	public TractConnectible(String name, int id, String type, double length, double volume) {
		super(name, id, type);
		this.length = length;
		this.volume = volume;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	@Override
	public JSONObject toJSON() {
		JSONObject j = new JSONObject();

		j.openObject();
		j.addAttibute("name", this.name, true);
		j.addAttibute("id", this.id, true);
		j.addAttibute("type", this.type, true);
		j.addAttibute("length", this.length, true);
		j.addAttibute("volume", this.volume, false);

		j.closeObject();

		return j;
	}

	@Override
	public Element toXML(Document doc) {
		XMLObject xo = new XMLObject(doc);

		Element e = xo.newElement(this.type);
		e.setAttributeNode(xo.newAttribute("name", this.name));
		e.setAttributeNode(xo.newAttribute("id", this.id));
		e.setAttributeNode(xo.newAttribute("type", this.type));
		e.setAttributeNode(xo.newAttribute("length", this.length));
		e.setAttributeNode(xo.newAttribute("volume", this.volume));

		return e;
	}
}
