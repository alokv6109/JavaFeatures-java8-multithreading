package interviewCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class ListTraverse {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("alok");
		list.add("sita");
		list.add("john rogan");
		list.add("aniket");
		
		//simple loop
		//list is indexed traversal
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("----------------------------------------------------------------------------");
		
		//works for all the collections, sometimes the collection is not indexed type but this will always work 
		//enhacnced for : Iterable goives you forEach
		for(String str: list) {
			System.out.println(str);
		}
		
		System.out.println("------------------------------------------------------------------------------");
		
		//using iterator, as the list is child of collection and collection has an iterator() method and hence list will also have an iterator mehtod
		//baiscally iterator means you've got a pointer and now woth the help of pointer we will fetch th values
		//forward direction only

		Iterator<String> itr = list.iterator();
		System.out.println(itr);
		while(itr.hasNext()) {
			String element  = itr.next();
			System.out.println(element);
		}
		
		System.out.println("-------------------------------------------------------------------------------");
		
		//list iterator : forward adn back ward both are possible only present with the list - ArrayList, LiunkedList and Vector
		//as the indexed thing and hence it is very understandable
		ListIterator<String> listItr = list.listIterator();
		System.out.println(listItr);
		while(listItr.hasNext()) {
			String element  = listItr.next();
			System.out.println(element);
		}
		
		System.out.println("---------------Backward iteration- using list iterator-----------------------------");
		ListIterator<String> iterator = list.listIterator(list.size());
		System.out.println(iterator.getClass().descriptorString());
		while(iterator.hasPrevious()) {
			String element=  iterator.previous();
			System.out.println(element);
		}
		
		System.out.println("------------------------------------------------------------------------------------");
		
		List<String> vector =  new Vector<>();
		vector.add("alok ");
		vector.add("aniket");
		
		ListIterator<String> iterator2 = vector.listIterator();
		while (iterator2.hasNext()) {
			String string = iterator2.next();
			System.out.println(string);
		}
		
		System.out.println("-------------------------------------------------------------------------------------");
		
		//for Each method - demands a consumere ie a lambda to get the elenent
		list.forEach((ele)->{
			System.out.println(ele);
		});
		
		System.out.println("--------------------------------------------------------------");
		
		//for the stream API , for each
//		study more about this in the strream video
		list.stream().forEach((e)->{
			System.out.println(e);
		});
		
	}
}
