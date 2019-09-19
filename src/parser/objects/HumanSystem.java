package parser.objects;

import java.util.ArrayList;

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
	public String toJSON() {
		String format = 
				"{\n" +
				"    \"name\": \"%s\",\n" +
				"    \"id\": %d\n" +
				"    \"type\": {\n";
		
		for (Flow fl: this.flows) {
			format += fl.toJSON() + ",";
		}
		
		format +=
				"    }\n" +
				"}\n";
		
		return String.format(format, this.name, this.id, this.type);
	}

	@Override
	public String toXML() {
		return null;
	}
}
