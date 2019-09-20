package parser.objects;

import parser.JSONObject;
import parser.XMLObject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Organ extends BaseObject {
	private int system_id;

	public Organ(String name, int id) {
		super(name, id);
	}
	
	public Organ(String name, int id, int system_id) {
		super(name, id);
		this.system_id = system_id;
	}

	public int getSystemId() {
		return system_id;
	}

	public void setSystemId(int system_id) {
		this.system_id = system_id;
	}

	@Override
	public JSONObject toJSON() {
		JSONObject j = new JSONObject();
		
		j.openObject();
		j.addAttibute("name", this.name, true);
		j.addAttibute("id", this.id, true);
		j.addAttibute("systemID", this.system_id, false);
		
		j.closeObject();
		
		return j;
	}

	@Override
	public Element toXML(Document doc) {
		XMLObject xo = new XMLObject(doc);
		
		Element e = xo.newElement("Organ");
		
		e.setAttributeNode(xo.newAttribute("name", this.name));
		e.setAttributeNode(xo.newAttribute("id", this.id));
		e.setAttributeNode(xo.newAttribute("systemID", this.system_id));
		
		return e;
	}
}
