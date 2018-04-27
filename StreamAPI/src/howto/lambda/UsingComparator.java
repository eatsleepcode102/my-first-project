package howto.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UsingComparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=new ArrayList<>();
		list.add(2);
		list.add(3);
		// classic way
		list.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1- o2;
			}
		});
		System.out.println(list);
		//lambda way, the shortest way
		list.sort((a,b) -> a-b);
		System.out.println(list);
		//apply the lambda way in persons list
		List<Person> pers=new ArrayList<>();
		pers.add(new Person("1","Abc1", "home"));
		pers.add(new Person("1","Abc3", "home"));
		pers.add(new Person("1","Abc2", "home"));
		
		pers.sort((p1, p2)-> p1.id.compareTo(p2.id));
		System.out.println(pers);
		
		Add a1=Integer::sum;
		System.out.println(a1.add(3, 5));
	}	
}

class Person {
	public String id;
	public String lastName;
	public String firstName;
	
	public Person(String id, String lastName, String firstName) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person: "+ id+","+lastName+","+ firstName;
	}
}

@FunctionalInterface
interface Add {
	public int add(int i1, int i2);
}
