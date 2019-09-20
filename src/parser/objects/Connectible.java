package parser.objects;

import parser.JSONObject;

public class Connectible extends BaseObject {
	protected String type;
	
	public Connectible(String name, int id) {
		super(name, id);
	}
	
	public Connectible(String name, int id, String type) {
		super(name, id);
		this.type = type;
	}

	@Override
	public JSONObject toJSON() {
		JSONObject j = new JSONObject();
		
		j.openObject();
		j.addAttibute("name", this.name, true);
		j.addAttibute("id", this.id, true);
		j.addAttibute("type", this.type, false);
		
		j.closeObject();
		
		return j;
	}

	@Override
	public String toXML() {
		return "";
	}	
}
