package main;

import java.util.HashMap;
import java.util.Map;

public class JSONObject {
	private final Map<String,Object> map=new HashMap<String, Object>();

	public boolean append(String key, String value){
		if(key!=null){
			map.put(key,value);
			return true;
		}else{
			return false;
		}
	}
	public boolean append(String key, JSONObject value){
		if(key!=null&&value!=null){
			map.put(key,value);
			return true;
		}else{
			return false;
		}
	}
	public String toJSONString(){
		StringBuffer str = new StringBuffer();
		if(!map.isEmpty()){
			str.append("{");
			for(Map.Entry<String, Object> el:map.entrySet()){
				str.append("\"");
				str.append(el.getKey());
				str.append("\":");
				if(el.getValue() instanceof JSONObject){
					str.append(((JSONObject)el.getValue()).toJSONString());
				}else {
					str.append("\"");
					str.append((String) el.getValue());
					str.append("\"");
				}
				str.append(", ");
			}
			str.delete(str.length()-2,str.length());
			str.append("}");
		}
		return str.toString();
	}
}
