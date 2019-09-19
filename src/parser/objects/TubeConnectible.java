package parser.objects;

public class TubeConnectible extends Connectible {
	private double start_radius;
	private double end_radius;
	private double length;

	public TubeConnectible(String name, int id) {
		super(name, id);
	}

	public TubeConnectible(String name, int id, String type, double start_radius, double end_radius, double length) {
		super(name, id, type);
		this.start_radius = start_radius;
		this.end_radius = end_radius;
		this.length = length;
	}

	public double getStartRadius() {
		return start_radius;
	}

	public void setStartRadius(double start_radius) {
		this.start_radius = start_radius;
	}

	public double getEndRadius() {
		return end_radius;
	}

	public void setEndRadius(double end_radius) {
		this.end_radius = end_radius;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public String toJSON() {
		String format = 
				"\"%s\": {\n" +
				"    \"name\": \"%s\",\n" +
				"    \"id\": %d,\n" +
				"    \"startRadius\": %f,\n" +
				"    \"endRadius\": %f,\n" +
				"    \"length\": %f\n" +
				"};\n";
		return String.format(format, this.type, this.name, this.id, this.start_radius, this.end_radius, this.length);
	}

	@Override
	public String toXML() {
		return null;
	}
}
