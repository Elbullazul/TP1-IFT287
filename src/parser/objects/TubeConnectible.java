package parser.objects;

import parser.JSONObject;
import parser.XMLObject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TubeConnectible extends Connectible {
	private double start_radius;
	private double end_radius;
	private double length;

	public TubeConnectible(String name, int id) {
		super(name, id);
	}

	public TubeConnectible(String name, int id, String type, double start_radius, double end_radius, double length) {
		super(name, id, type);
		this.start_radius = start_radius;
		this.end_radius = end_radius;
		this.length = length;
	}

	public double getStartRadius() {
		return start_radius;
	}

	public void setStartRadius(double start_radius) {
		this.start_radius = start_radius;
	}

	public double getEndRadius() {
		return end_radius;
	}

	public void setEndRadius(double end_radius) {
		this.end_radius = end_radius;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public JSONObject toJSON() {
		JSONObject j = new JSONObject();
		
		j.openObject();
		j.addAttibute("name", this.name, true);
		j.addAttibute("id", this.id, true);
		j.addAttibute("type", this.type, true);
		j.addAttibute("startRadius", this.start_radius, true);
		j.addAttibute("endRadius", this.end_radius, true);
		j.addAttibute("length", this.length, false);
		
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
		e.setAttributeNode(xo.newAttribute("startRadius", this.start_radius));
		e.setAttributeNode(xo.newAttribute("endRadius", this.end_radius));
		e.setAttributeNode(xo.newAttribute("leng", this.length));

		return e;
	}
}
