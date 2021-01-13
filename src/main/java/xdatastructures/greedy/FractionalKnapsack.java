package xdatastructures.greedy;

import java.util.*;

public class FractionalKnapsack {

	
	static void knapSack(ArrayList<FractionalKnapsackItem> items, int capacity) {
		// Sort items by descending ratio of value/ weight
		//Implement Comparator interface and specify which variable('Ratio') of user defined class should the 'compare' method work on.
		//This needs to be done because this will be required in Sort method  
		items.forEach(i -> System.out.println(i));
		Comparator<FractionalKnapsackItem> comparator = new Comparator<FractionalKnapsackItem>() {
			@Override
			public int compare(FractionalKnapsackItem o1, FractionalKnapsackItem o2) {
				if(o2.getRatio() > o1.getRatio())
					return 1;
				else
					return -1;
			}
		};
		//Sort all the objects stored in the Arraylist by 'Ratio' variable
		Collections.sort(items, comparator);
		System.out.println("Sorted");
		items.forEach(i -> System.out.println(i));
		
		//Run greedy algo
		int usedCapacity = 0;
		double totalValue = 0;
		for (FractionalKnapsackItem item : items) {
			//if full consumption possible then consume it
			if(usedCapacity + item.getWeight() <= capacity) {
				usedCapacity += item.getWeight();
				totalValue += item.getValue();
				System.out.println("Taken Complete : "+item);
			}
			else {
				//else consume fractionally
				int usedWeight = capacity - usedCapacity;
				double usedvalue = item.getRatio() * usedWeight;
				System.out.println(
						"Taken Fraction : " + item
						+ ", used value = " + usedvalue
						+ ", used weight = " + usedWeight
						+ "]");
				usedCapacity += usedWeight;
				totalValue += usedvalue;
			}
			//if capacity is full then break
			if(usedCapacity==capacity)
				break;
		}
		//print finally obtained value
		System.out.println("\nTotal value obtained: "+ totalValue);
	}//end of method
	
}//end of class
