package parser.objects;

import java.util.ArrayList;
import parser.JSONObject;

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
	public JSONObject toJSON() {
		JSONObject j = new JSONObject();
		
		j.openObject();
		j.addAttibute("id", this.id, true);
		j.openArray("target_ids");
		
		int count = 1;
		for (Integer i: this.targets_ids) {
			j.addInt(i, (count != this.targets_ids.size()));
			count++;
		}
		
		j.closeArray();
		j.closeObject();
		
		return j;
	}

	@Override
	public String toXML() {
		return null;
	}
}
