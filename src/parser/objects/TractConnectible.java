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
				"\"%s\": {\n" +
				"    \"name\": \"%s\",\n" +
				"    \"id\": %d,\n" +
				"    \"length\": %f,\n" +
				"    \"volume\": %f\n" +
				"};\n";
		return String.format(format, this.type, this.name, this.id, this.length, this.volume);
	}

	@Override
	public String toXML() {
		String format = "<%s "+ "name="+ '"'+"%s" +'"'+ "id="+ '"'+"%d"+'"';
				format += '"'+ "length="+ '"'+"%s" +'"';
				format += '"'+ "volume="+ '"'+"%s" +'"';
				format +="/>";
		return String.format(format, this.type, this.name, this.id, this.length, this.volume);
	}
}
