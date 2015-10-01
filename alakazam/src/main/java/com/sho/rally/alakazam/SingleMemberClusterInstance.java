package com.sho.rally.alakazam;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SingleMemberClusterInstance {
	
	public static void main(String[] args) {
		
		// Single instance in our cluster
		HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
		
		// Map
		Map<Integer, String> customers = hazelcastInstance.getMap("customers");
		
		customers.put(1, "Joe");
		customers.put(2, "Ali");
		customers.put(3, "Avi");
		
		System.out.println("Customer with key 1: " + customers.get(1));
		System.out.println("Map Size:" + customers.size());
		
		System.out.println();
		
		// Queue
		Queue<String> queueCustomers = hazelcastInstance.getQueue("customers");
		
		queueCustomers.offer("Tom");
		queueCustomers.offer("Mary");
		queueCustomers.offer("Jane");
		
		System.out.println("First customer: " + queueCustomers.poll());
		System.out.println("Second customer: " + queueCustomers.peek());
		System.out.println("Queue size: " + queueCustomers.size());
		
		System.out.println();
		
		// List
		List<String> shows = hazelcastInstance.getList("shows");
		
		shows.add("Ray Donovan");
		shows.add("The Affair");
		shows.add("Dexter");
		shows.add("Penny Dreadful");
		
		for (String showStr : shows) {
			System.out.println(showStr);
		}
		
		System.out.println();
		
		// Set
		Set<Integer> integerSet = hazelcastInstance.getSet("integerSet");
		
		integerSet.add(new Integer(1));
		integerSet.add(new Integer(2));
		integerSet.add(new Integer(3));
		integerSet.add(new Integer(Integer.MAX_VALUE));
		
		System.out.println(integerSet);
		for (Integer integer : integerSet) {
			System.out.println(integer);
		}
		
		hazelcastInstance.shutdown();
	}
}