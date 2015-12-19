package registry;

import akka.actor.ActorRef;

public class RegistryEntry {
	
	private Class<ActorRef> worker;
	private RegistryConfig defaultConfig;
	
	
	public RegistryEntry(Class<ActorRef> worker, RegistryConfig defaultConfig) {
		this.setWorker(worker);
		this.setDefaultConfig(defaultConfig);
	}
	
	public RegistryEntry(Class<ActorRef> worker) {
		this.setWorker(worker);
	}
	
	public Class<ActorRef> getWorker() {
		return worker;
	}
	private void setWorker(Class<ActorRef> worker) {
		this.worker = worker;
	}

	public RegistryConfig getDefaultConfig() {
		return defaultConfig;
	}

	private void setDefaultConfig(RegistryConfig defaultConfig) {
		this.defaultConfig = defaultConfig;
	}
	
	
}
