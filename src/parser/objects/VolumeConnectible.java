package parser.objects;

import parser.JSONObject;

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
	public String toXML() {
		return null;
	}
}
