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
				"\"%s\": {\n" +
				"    \"name\": \"%s\",\n" +
				"    \"id\": %d,\n" +
				"    \"volume\": %f\n" +
				"}\n";
		return String.format(format, this.type, this.name, this.id, this.volume);
	}

	@Override
	public String toXML() {
		String format = "<%s ";
		format += "name ="+'"'+ "%s"+'"';
		format += "id ="+'"'+ "%d"+'"';
		format += "volume="+'"'+ "%f"+'"';
		format += "/>";
		return String.format(format, this.type, this.name, this.id, this.volume);
	}
	
}
