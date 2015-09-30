package com.sho.rally.alakazam;

import java.util.Map;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class MultipleClusterInstance {
	
	public static void main(String[] args) {
		HazelcastInstance instanceA = Hazelcast.newHazelcastInstance();
		
		Map<String, String> capitalsAndStates =  instanceA.getMap("capitalsAndStates");
		
		capitalsAndStates.put("Hartford", "Connecticut");
		capitalsAndStates.put("Sacramento", "California");
		capitalsAndStates.put("Albany", "New York");
		capitalsAndStates.put("Trenton", "New Jersey");
		capitalsAndStates.put("Springfield", "Illinois");
		capitalsAndStates.put("Honolulu", "Hawaii");
		
		HazelcastInstance instanceB = Hazelcast.newHazelcastInstance();
		
		Map<String, String> capitalsAndStatesB =  instanceB.getMap("capitalsAndStates");
		
		capitalsAndStatesB.put("Columbus", "Ohio");
		
		for (Map.Entry<String, String> capitalsEntry : capitalsAndStatesB.entrySet()) {
			System.out.println(capitalsEntry.getKey() + " - " + capitalsEntry.getValue());
		}
		
		instanceA.shutdown();
		instanceB.shutdown();
		
	}

}
