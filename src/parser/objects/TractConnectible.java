package parser.objects;

import parser.JSONObject;

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
	public String toXML() {
		return null;
	}
}
