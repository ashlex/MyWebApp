package home.main.java.html;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alexej on 01.08.2015.
 */
public class Attribute {
	private String name;
	private List<String> values;

	public Attribute(String name, String... values) {
		if (name == null) throw new NullPointerException("Name can not be null");
		this.name = name;
		this.values = new ArrayList<String>();
		this.values.addAll(Arrays.asList(values));
	}

	public String getName() {
		return name;
	}
	public boolean removeValue(String value){
		return this.values.remove(value);
	}

	public int addValue(String value) {
		this.values.add(value);
		return this.values.size();
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(name);
		if(values.size()>0){
			sb.append("='");
			for(String val:values){
				sb.append(val);
				sb.append(" ");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("'");
		}
		return sb.toString();
	}
}
