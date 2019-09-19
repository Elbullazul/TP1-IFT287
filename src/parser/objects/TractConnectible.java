package parser.objects;

public class TractConnectible extends Connectible {
	private double length;
	private double volume;
	
	public TractConnectible(String name, int id) {
		super(name, id);
	}
	
	public TractConnectible(String name, int id, String type, double length, double volume) {
		super(name, id, type);
		this.length = length;
		this.volume = volume;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	@Override
	public String toJSON() {
		String format = 
				"{\n" +
				"    \"name\": \"%s\",\n" +
				"    \"id\": %d,\n" +
				"    \"type\": \"%s\",\n" +
				"    \"length\": %f,\n" +
				"    \"volume\": %f\n" +
				"}\n";
		return String.format(format, this.name, this.id, this.type, this.length, this.volume);
	}

	@Override
	public String toXML() {
		return null;
	}
}
