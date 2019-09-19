package parser.objects;

public class VolumeConnectible extends Connectible {
	private double volume;

	public VolumeConnectible(String name, int id) {
		super(name, id);
	}
	
	public VolumeConnectible(String name, int id, String type, double volume) {
		super(name, id, type);
		this.volume = volume;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public String toJSON() {
		String format = 
				"{\n" +
				"    \"name\": \"%s\",\n" +
				"    \"id\": %d,\n" +
				"    \"type\": \"%s\",\n" +
				"    \"volume\": %f\n" +
				"}\n";
		return String.format(format, this.name, this.id, this.type, this.volume);
	}

	@Override
	public String toXML() {
		return null;
	}
}
