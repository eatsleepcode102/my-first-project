package dp.creational.prototype;

import java.util.List;

public class PrototypePatternTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Employees empList=new Employees();
		empList.loadData();
		
		Employees emp1=(Employees) empList.clone();
		Employees emp2=(Employees) empList.clone();
		
		List<String> list1=emp1.getEmpList();
		list1.add("RR");
		List<String> list2=emp2.getEmpList();
		list2.add("TT");		
		
		System.out.println(empList.getEmpList());
		System.out.println(list1);
		System.out.println(list2);	
	}
}
