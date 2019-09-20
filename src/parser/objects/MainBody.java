package parser.objects;

import java.util.ArrayList;
import parser.JSONObject;

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
	public JSONObject toJSON() {
		JSONObject j = new JSONObject();
		j.openObject();
		j.openObject("MainBody");
		
		j.addAttibute("bodyName", this.name, true);
		j.addAttibute("bodyID", this.id, true);
		
		j.openArray("Systems");
		
		int count = 1;
		for (HumanSystem sys : this.systems) {
			JSONObject jo = sys.toJSON();
			j.addObject(jo, (count != this.systems.size()));
			count++;
		}
		
		j.closeArray();
		j.newLine();
		j.openArray("Organs");
		
		count = 1;
		for (Organ org : this.organs) {
			JSONObject jo = org.toJSON();
			j.addObject(jo, (count != this.organs.size()));
			count++;
		}
		
		j.closeArray();
		j.closeObject();
		j.closeObject();
		
		return j;
	}

	@Override
	public String toXML() {
		return "";
	}
}
