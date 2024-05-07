package Assignment;

import java.util.HashMap;

public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		
		hashMap.put(9, "banana");
		hashMap.put(7, "Apple");
		hashMap.put(11, "orange");
		hashMap.put(1, "mango");
		hashMap.put(8, "carrot");
		
		for (int key : hashMap.keySet()) {
            System.out.println("Key: " + key + ",    Value: " + hashMap.get(key));
        }
	}

}
