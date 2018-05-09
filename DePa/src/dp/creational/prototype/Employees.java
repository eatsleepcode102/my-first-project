package dp.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Employees implements Cloneable{

	private List<String> empList;
	
	Employees(){
		empList=new ArrayList<String>();
	}
	
	Employees(List<String> list){
		empList=list;
	}
	
	public void loadData(){
		empList.add("A");
		empList.add("B");
		empList.add("C");
		empList.add("D");
		
	}
	
	public List<String> getEmpList() {
		return empList;
	}

	@Override
	protected Object clone() {
		// TODO Auto-generated method stub
		List<String> temp=new ArrayList<String>();
		for(String a: empList){
			temp.add(a);
		}
		return new Employees(temp);
	}
}
