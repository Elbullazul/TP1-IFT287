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
		String format = 
				"\"Organ\": {\n" +
				"    \"name\": \"%s\",\n" +
				"    \"id\": %d,\n" +
				"    \"systemID\": %d\n" +
				"}\n";
		
		return String.format(format, this.name, this.id, this.system_id);
	}

	@Override
	public String toXML() {
		return null;
	}
}
