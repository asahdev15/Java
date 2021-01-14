package java8.escapingreferences;

public class Main {

	public static void main(String[] args) {
		CustomerRecords records = new CustomerRecords();
		
		records.addCustomer("John");
		records.addCustomer("Simon");

//		records.getCustomers().clear();
		
		for (ReadonlyCustomer c : records) {
			System.out.println(c);
		}
		
		//Customer c = (Customer) records.find("John");
				

	}
}