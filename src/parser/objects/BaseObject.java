package parser.objects;

public class BaseObject {
	protected String name;
	protected int id;
	
	public BaseObject(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	// implémenter aussi pour chaque classe
	public String toJSON() {
		return "";
	}
	
	public String toXML() {
		return "";
	}
}
