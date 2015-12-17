package work;

import java.util.UUID;

public class WorkItem implements Comparable<WorkItem>{

	
	private WorkSet workSet;
	private WorkType workType;
	private Long uuid = UUID.randomUUID().getLeastSignificantBits();
	private WorkStatus workStatus = WorkStatus.NO_WORK;
	
	public WorkItem(WorkType workType, WorkSet workSet) {
		if(workType == null) {
			throw new IllegalArgumentException("Can't have null WorkType in WorkItem");
		}
		this.workType = workType;
		this.workSet = workSet;
	}
	
	public WorkItem(WorkType workType) {
		if(workType == null) {
			throw new IllegalArgumentException("Can't have null WorkType in WorkItem");
		}
		this.workType = workType;
		this.workStatus = WorkStatus.DO_WORK;
	}

	public WorkType getWorkType() {
		return workType;
	}

	public void setWorkType(WorkType workType) {
		if(workType == null) {
			throw new IllegalArgumentException("Can't have null WorkType in WorkItem");
		}
		this.workType = workType;
	}

	public WorkStatus getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(WorkStatus workStatus) {
		this.workStatus = workStatus;
	}

	public WorkSet getWorkSet() {
		return workSet;
	}

	public void setWorkSet(WorkSet workSet) {
		this.workSet = workSet;
	}

	public Long getUuid() {
		return uuid;
	}

	//TODO add other aspects to the comparison
	public int compareTo(WorkItem other) {
		return workType.compareTo(other.getWorkType());
	}

}
