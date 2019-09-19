package parser.objects;

import java.util.ArrayList;

public class Connection extends BaseObject {
	private ArrayList<Integer> targets_ids;

	public Connection(String name, int id) {
		super(name, id);
		targets_ids = new ArrayList<Integer>();
	}

	public ArrayList<Integer> getTargetsIds() {
		return targets_ids;
	}

	public void addTargetId(int target_id) {
		this.targets_ids.add(target_id);
	}

	@Override
	public String toJSON() {
		String format = 
				"\"Connection\": {\n" +
				"    \"id\": %d\n" +
				"}\n";
		return String.format(format, this.id);
	}

	@Override
	public String toXML() {
		return null;
	}
}
