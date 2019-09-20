package parser;

public class JSONObject {
	private static String ind = "";
	private static String newLine = ",\n"; 
	private String charString;
	
	public JSONObject() {
		this.charString = "";
	}
	
	public static void addIndent() {
		JSONObject.ind += "  ";
	}
	
	public static void delIndent() {
		JSONObject.ind = JSONObject.ind.substring(0, JSONObject.ind.length() - 2);
	}
	
	public void newLine() {
		this.charString += ",\n";
	}
	
	public void openObject() { this.charString += JSONObject.ind + "{\n"; JSONObject.addIndent(); }
	public void closeObject() { JSONObject.delIndent(); this.charString += "\n" + JSONObject.ind + "}"; }
	public void openObject(String name) {
		this.charString += JSONObject.ind + "\"" + name + "\" : {\n"; JSONObject.addIndent();
	}
	
	public void openArray() { this.charString += JSONObject.ind + "[\n"; JSONObject.addIndent(); }
	public void closeArray() { JSONObject.delIndent(); this.charString += "\n" + JSONObject.ind + "]"; }
	public void openArray(String name) {
		this.charString += JSONObject.ind + "\"" + name + "\" : [\n"; JSONObject.addIndent();
	}
	
	public void addInt(int i, boolean newLine) {
		if (newLine)
			this.charString += JSONObject.ind + i + JSONObject.newLine;
		else
			this.charString += JSONObject.ind + i;
	}
	
	public void addAttibute(String attr, String val, boolean newLine) {
		if (newLine)
			this.charString += JSONObject.ind + "\"" + attr + "\": \"" + val + "\"" + JSONObject.newLine;
		else
			this.charString += JSONObject.ind + "\"" + attr + "\": \"" + val + "\"";
	}
	
	public void addAttibute(String attr, int val, boolean newLine) {
		if (newLine)
			this.charString += JSONObject.ind + "\"" + attr + "\": " + val + JSONObject.newLine;
		else
			this.charString += JSONObject.ind + "\"" + attr + "\": " + val;
	}
	
	public void addAttibute(String attr, double val, boolean newLine) {
		if (newLine)
			this.charString += JSONObject.ind + "\"" + attr + "\": " + val + JSONObject.newLine;
		else
			this.charString += JSONObject.ind + "\"" + attr + "\": " + val;
	}
	
	public void addObject(JSONObject o, boolean newLine) {
		if (newLine)
			this.charString += o.toString() + ",\n";
		else
			this.charString += o.toString();
	}
	
	public String toString() {
		return this.charString;
	}
}
