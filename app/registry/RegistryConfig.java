package registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistryConfig {

	private final Map<String, String> properties = new HashMap<String, String>();
	
	public RegistryConfig(Map<String, String> properties) {
		this.properties.putAll(properties);
	}
	
	public String get(String key){
		return properties.get(key);
	}
	
	public Map<String, String> getAll() {
		return new HashMap<String, String>(properties);
	}
}
