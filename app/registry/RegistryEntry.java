package registry;

import akka.actor.ActorRef;

public class RegistryEntry {
	
	private final static int DEFAULT_NUM_WORKERS = 5;
	
	private Class<ActorRef> worker;
	private Object customDirective;
	
	private int recommendedNumWorkers;
	
	
	
	public RegistryEntry(Class<ActorRef> worker, Object customDirective, int recommendedNumWorkers) {
		this.setWorker(worker);
		this.setCustomDirective(customDirective);
		this.setRecommendedNumWorkers(recommendedNumWorkers);
	}
	
	public RegistryEntry(Class<ActorRef> worker, int recommendedNumWorkers) {
		this.setWorker(worker);
		this.setCustomDirective(null);
		this.setRecommendedNumWorkers(recommendedNumWorkers);
	}

	public RegistryEntry(Class<ActorRef> worker, Object customDirective) {
		this.setWorker(worker);
		this.setCustomDirective(customDirective);
		this.setRecommendedNumWorkers(DEFAULT_NUM_WORKERS);
	}
	
	public RegistryEntry(Class<ActorRef> worker) {
		this.setWorker(worker);
		this.setCustomDirective(null);
		this.setRecommendedNumWorkers(DEFAULT_NUM_WORKERS);
	}
	
	public Class<ActorRef> getWorker() {
		return worker;
	}
	public void setWorker(Class<ActorRef> worker) {
		this.worker = worker;
	}
	
	public boolean hasCustomDirective(){
		return (customDirective == null) ? false : true;  
	}

	public Object getCustomDirective() {
		return customDirective;
	}

	public void setCustomDirective(Object customDirective) {
		this.customDirective = customDirective;
	}

	public int getRecommendedNumWorkers() {
		return recommendedNumWorkers;
	}

	public void setRecommendedNumWorkers(int recommendedNumWorkers) {
		this.recommendedNumWorkers = recommendedNumWorkers;
	}
	
}
