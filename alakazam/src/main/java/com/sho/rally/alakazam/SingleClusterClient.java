package com.sho.rally.alakazam;

import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/*
 * Hazelcast Client enables you to do all Hazelcast operations without being a member of the cluster. 
 * It connects to one of the cluster members and delegates all cluster wide operations to it. 
 * When the connected cluster member dies, client will automatically switch to another live member.
 */
public class SingleClusterClient {
	
	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
		
		IMap capitals = client.getMap("capitals");
		System.out.println("Capitals map Size:" + capitals.size());
		
		IMap customers = client.getMap("customers");
		System.out.println("\nCustomers map Size:" + customers.size());
	}
}