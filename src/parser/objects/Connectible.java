package parser.objects;

import parser.JSONObject;
import parser.XMLObject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
	public Element toXML(Document doc) {
		XMLObject xo = new XMLObject(doc);
		
		Element e = xo.newElement(this.type);
		e.setAttributeNode(xo.newAttribute("name", this.name));
		e.setAttributeNode(xo.newAttribute("id", this.id));
		
		return e;
	}	
}
