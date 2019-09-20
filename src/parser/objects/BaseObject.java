package parser.objects;

import parser.JSONObject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class BaseObject {
	protected String name;
	protected int id;
	
	public BaseObject(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public abstract JSONObject toJSON();
	public abstract Element toXML(Document doc);
}
