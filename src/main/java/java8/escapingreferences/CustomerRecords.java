package java8.escapingreferences;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CustomerRecords implements Iterable<Customer> {
	private Map<String, Customer> records;
	
	public CustomerRecords() {
		this.records = new HashMap<String, Customer>();
	}
	
	public void addCustomer(String name) {
		this.records.put(name, new Customer(name));
	}
		
	public Map<String, Customer> getCustomers() {
//		return Map.copyOf(records); // Java 10+
		return Collections.unmodifiableMap(records);
	}

	@Override
	public Iterator<Customer> iterator() {
		return records.values().iterator();
	}
	
	public ReadonlyCustomer find(String name) {
		return new Customer(records.get(name));
	}
}