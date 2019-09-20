package parser.objects;

import parser.JSONObject;
import parser.XMLObject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class VolumeConnectible extends Connectible {
	private double volume;

	public VolumeConnectible(String name, int id) {
		super(name, id);
	}
	
	public VolumeConnectible(String name, int id, String type, double volume) {
		super(name, id, type);
		this.volume = volume;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public JSONObject toJSON() {
		JSONObject j = new JSONObject();
		
		j.openObject();
		j.addAttibute("name", this.name, true);
		j.addAttibute("id", this.id, true);
		j.addAttibute("type", this.type, true);
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
		e.setAttributeNode(xo.newAttribute("volume", this.volume));

		return e;
	}
}
