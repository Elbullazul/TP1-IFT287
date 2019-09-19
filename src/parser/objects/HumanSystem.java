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
		return null;
	}

	@Override
	public String toXML() {
		return null;
	}
}
