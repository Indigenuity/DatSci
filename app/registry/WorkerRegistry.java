package registry;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import work.WorkType;

public class WorkerRegistry {
	private static final WorkerRegistry instance = new WorkerRegistry();
	
	private final Map<WorkType, RegistryEntry> registry = Collections.synchronizedMap(new HashMap<WorkType, RegistryEntry>());
	
	protected WorkerRegistry(){
	}
	
	public static WorkerRegistry getInstance() {
		return instance;
	}
	
	public RegistryEntry getRegistrant(WorkType workType) {
		return registry.get(workType);
	}
	
	//Synchronize for multiple operations on the registry
	public boolean register(WorkType workType, RegistryEntry entry) {
		synchronized(registry){
			if(workType == null || entry == null || registry.containsKey(workType)) {
				return false;
			}
			registry.put(workType, entry);
			return true;
		}
	}
	
	public void unRegister(WorkType workType) {
		registry.remove(workType);
	}
	
	public void replaceRegister(WorkType workType, RegistryEntry entry) {
		registry.replace(workType, entry);
	}
	
	//Return a copy of the registry.  Don't want anything iterating over it outside of this object
	public Map<WorkType, RegistryEntry> getRegistry() {
		Map<WorkType, RegistryEntry> copy = new HashMap<WorkType, RegistryEntry>();
		copy.putAll(registry);
		return copy;
	}
}
