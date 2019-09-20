package parser.objects;

import java.util.ArrayList;
import parser.JSONObject;
import parser.XMLObject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class HumanSystem extends BaseObject {
	private ArrayList<Flow> flows;
	private String type;

	public HumanSystem(String name, int id) {
		super(name, id);
	}
	
	public HumanSystem(String name, int id, String type) {
		super(name, id);

		this.type = type;
		this.flows = new ArrayList<Flow>();
	}

	// Flow management
	public ArrayList<Flow> getFlows() {
		return flows;
	}
	
	public void addFlow(Flow flow) {
		flows.add(flow);
	}

	// Node attributes
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public JSONObject toJSON() {
		JSONObject j = new JSONObject();
		
		j.openObject();
		j.addAttibute("name", this.name, true);
		j.addAttibute("id", this.id, true);
		j.addAttibute("type", this.type, true);
		j.openArray("Flows");
		
		int count = 1;
		for (Flow fl: this.flows) {
			JSONObject oj = fl.toJSON();
			j.addObject(oj, (count != this.flows.size()));
			count++;
		}
		
		j.closeArray();
		j.closeObject();
		
		return j;
	}

	@Override
	public Element toXML(Document doc) {
		XMLObject xo = new XMLObject(doc);
		
		Element e = xo.newElement("System");
		e.setAttributeNode(xo.newAttribute("name", this.name));
		e.setAttributeNode(xo.newAttribute("id", this.id));
		e.setAttributeNode(xo.newAttribute("type", this.type));
		
		for (Flow flow : this.flows) {
			e.appendChild(flow.toXML(doc));
		}
		
		return e;
	}
}
