package parser.objects;

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
	public String toJSON() {
		String format = 
				"\"%s\": {\n" +
				"    \"name\": \"%s\",\n" +
				"    \"id\": %d\n" +
				"}\n";
		return String.format(format, this.type, this.name, this.id);
	}

	@Override
	public String toXML() {
		return "";
	}	
}
