package com.sho.rally.alakazam;

import java.util.Map;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class MultipleMemberClusterInstance {
	
	public static void main(String[] args) {
		// Create first member in our cluster
		HazelcastInstance instanceA = Hazelcast.newHazelcastInstance();
		
		// Create a capitals map from the cluster
		Map<String, String> us_capitals_1 =  instanceA.getMap("capitals");
		
		// Populate the map
		us_capitals_1.put("Hartford", "Connecticut");
		us_capitals_1.put("Sacramento", "California");
		us_capitals_1.put("Albany", "New York");
		us_capitals_1.put("Trenton", "New Jersey");
		us_capitals_1.put("Springfield", "Illinois");
		us_capitals_1.put("Honolulu", "Hawaii");
		
		// Create second member in our cluster
		HazelcastInstance instanceB = Hazelcast.newHazelcastInstance();
		
		// Retrieve the capitals map and modify it in this cluster
		Map<String, String> us_capitals_2 =  instanceB.getMap("capitals");
		
		// Add a capital
		us_capitals_2.put("Columbus", "Ohio");
		
		// Sysout the entire capitals_2 map
		for (Map.Entry<String, String> capitalsEntry : us_capitals_2.entrySet()) {
			System.out.println(capitalsEntry.getKey() + " - " + capitalsEntry.getValue());
		}
		
		// Remove a few capitals
		us_capitals_2.remove("Trenton");
		us_capitals_2.remove("Hartford");
		
		// Sysout the entire capitals_1 map
		for (Map.Entry<String, String> capitalsEntry : us_capitals_1.entrySet()) {
			System.out.println(capitalsEntry.getKey() + " - " + capitalsEntry.getValue());
		}
		
		// Shutdown clusters
		instanceA.shutdown();
		instanceB.shutdown();
	}

}
