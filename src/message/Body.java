package message;

import java.io.Serializable;
import java.util.HashMap;

public class Body implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5728956330855011743L;
	private HashMap<String,Serializable> map;	// Contains all properties for the body of the message
	
	Body() {
		map = new HashMap<String, Serializable>();
	}
	
	public boolean hasField(String name){
		return map.containsKey(name);
	}
	
	public void addField(String name, Serializable value) {
		map.put(name, value);
	}
	
	public void removeField(String name) {
		map.remove(name);
	}
	
	public Serializable getField(String name) {
		return map.get(name);
	}
	
	public HashMap<String, Serializable> getMap() {
		return map;
	}
	public  String toString(){
		String s = "BODY:\n";
		for(String key : map.keySet()){
			s += key + ": " + map.get(key).toString() + "\n";
		}
		return s;		
	}
}

