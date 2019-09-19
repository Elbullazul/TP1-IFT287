package parser.objects;

import java.util.ArrayList;

public class MainBody extends BaseObject {
	private ArrayList<HumanSystem> systems;
	private ArrayList<Organ> organs;
	
	public MainBody(String name, int id) {
		super(name, id);
		
		this.systems = new ArrayList<HumanSystem>();
		this.organs = new ArrayList<Organ>();
	}

	// System management
	public ArrayList<HumanSystem> getSystems() {
		return systems;
	}

	public void addSystem(HumanSystem system) {
		this.systems.add(system);
	}

	// Organ management
	public ArrayList<Organ> getOrgans() {
		return organs;
	}

	public void addOrgan(Organ organ) {
		this.organs.add(organ);
	}

	@Override
	public String toJSON() {
		String format =
				"{\n" +
				"\"MainBody\": {\n" +
				"    \"bodyName\": \"%s\",\n" +
				"    \"bodyId\": %d,\n" +
				"    \"Systems\": [\n";
		
		for (HumanSystem sys : this.systems) {
			format += sys.toJSON() + ",\n";
		}
		
		// remove last comma and newline
		format = format.substring(0, format.length() - 2);
		
		format +=
				"    ],\n" +
				"\"Organs\": [\n";
		
		for (Organ org : this.organs) {
			format += org.toJSON() + ",\n";
		}
		
		// remove last comma and newline
		format = format.substring(0, format.length() - 2);
		
		format +=
				"    ]\n" +
				"}\n" +
				"}\n";
		
		return String.format(format, this.name, this.id);
	}

	@Override
	public String toXML() {
		return "";
	}
}
