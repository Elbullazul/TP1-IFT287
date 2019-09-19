package parser.objects;

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
	public String toJSON() {
		return null;
	}

	@Override
	public String toXML() {
		return null;
	}
}
