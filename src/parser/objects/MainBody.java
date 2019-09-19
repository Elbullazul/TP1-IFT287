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
}
