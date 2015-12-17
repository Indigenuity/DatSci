package work;

public class WorkType implements Comparable<WorkType>{
	
	private String identifier;
	private String description;
	private Float priorityIndex;	//Lower number = higher priority 
	
	
	public WorkType(String identifier, String description, float priorityIndex) {
		this.setIdentifier(identifier);
		this.setDescription(description);
		this.setPriorityIndex(priorityIndex);
	}
	
	public WorkType(String identifier) {
		this.setIdentifier(identifier);
		this.setDescription("This work type has no description yet. Fill it in!");
		this.setPriorityIndex(0);
	}
	
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getPriorityIndex() {
		return priorityIndex;
	}
	public void setPriorityIndex(float priorityIndex) {
		this.priorityIndex = priorityIndex;
	}
	
	public int compareTo(WorkType other) {
		return this.getPriorityIndex().compareTo(other.getPriorityIndex());
	}

	
	
}
