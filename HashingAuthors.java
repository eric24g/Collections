import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class HashingAuthors {
	
	public <E> void printMap(Set<E> entrySet) {
		Iterator<E> iterator = entrySet.iterator();
		
		while(iterator.hasNext()) {
			E entry = iterator.next();
			System.out.println(entry);
		}
	}

	public static void main(String[] args) {
		Map<String, List<String>> hashMap = new HashMap<String, List<String>>();
		System.out.println("Enter in the authors last name and book seperated by a space. Typ -q to end input. ");
		Scanner scan = new Scanner(System.in);
		
		while(scan.hasNextLine()){
			String input = scan.nextLine();
			
			if(input.contains("-q")) {
				break;
			} else {
				String [] entry = new String[2];
				entry[0] = input.substring(0, input.indexOf(' '));
				entry[1] = input.substring(input.indexOf(' ') +1);
				List<String> entryList = new ArrayList<String>();
				
				if(hashMap.containsKey(entry[0])) {
					entryList = hashMap.get(entry[0]);
					entryList.add(entry[1]);
					hashMap.put(entry[0], entryList);
				} else {
					entryList.add(entry[1]);
					hashMap.put(entry[0], entryList);
				}
			}
		}
		
		HashingAuthors authors = new HashingAuthors();
		Set entrySet = hashMap.entrySet();
		authors.printMap(entrySet);
		scan.close();
	}

}
