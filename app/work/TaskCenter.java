package work;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import registry.RegistryEntry;
import registry.WorkerRegistry;

public class TaskCenter {
	private static final TaskCenter instance = new TaskCenter();
	
	private ActorSystem mainSystem;
	private ActorRef mainMaster;
	
	private TaskCenter(){
		init();
	}
	
	public static TaskCenter getInstance() {
		return instance;
	}
	
	private void init() {
		this.mainSystem = ActorSystem.create("mainSystem");
		mainMaster = mainSystem.actorOf(Props.create(MainMaster.class, 60));
	}
	
	
}
