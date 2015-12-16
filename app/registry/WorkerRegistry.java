package registry;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WorkerRegistry {
private static final WorkerRegistry instance = new WorkerRegistry();
	
	private final Map<String, RegistryEntry> registry = Collections.synchronizedMap(new HashMap<String, RegistryEntry>());
	
	protected WorkerRegistry(){
	}
	
	public static WorkerRegistry getInstance() {
		return instance;
	}
	
	public RegistryEntry getRegistrant(String workType) {
		return registry.get(workType);
	}
	
	//Synchronize for multiple operations on the registry
	public boolean register(String workType, RegistryEntry entry) {
		synchronized(registry){
			if(workType == null || entry == null || registry.containsKey(workType)) {
				return false;
			}
			registry.put(workType, entry);
			return true;
		}
	}
	
	public void unRegister(String workType) {
		registry.remove(workType);
	}
	
	public void replaceRegister(String workType, RegistryEntry entry) {
		registry.replace(workType, entry);
	}
	
	//Return a copy of the registry.  Don't want anything iterating over it outside of this object
	public Map<String, RegistryEntry> getRegistry() {
		Map<String, RegistryEntry> copy = new HashMap<String, RegistryEntry>();
		copy.putAll(registry);
		return copy;
	}
}
