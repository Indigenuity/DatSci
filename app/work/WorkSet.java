package work;

import java.util.PriorityQueue;
import java.util.UUID;

public class WorkSet {

	private PriorityQueue<WorkItem> workQueue= new PriorityQueue<WorkItem>();
	private Long uuid = UUID.randomUUID().getLeastSignificantBits();
	private String name;
	
	public WorkSet(String name) {
		this.setName(name);
	}
	
	public void addWorkItem(WorkItem workItem) {
		workItem.setWorkSet(this);
		workQueue.add(workItem);
	}
	
	public boolean removeWorkItem(WorkItem workItem) {
		return workQueue.remove(workItem);
	}
	
	public WorkItem getNextWorkItem() {
		return workQueue.poll();
	}
	
	public boolean hasMoreWork(){
		return (workQueue.peek() == null) ? false : true;
	}

	public long getUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
