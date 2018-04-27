package dp.creational.builder;

public class BuilderMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stu=new Student.StudentBuilder("albert", 23)
				.setSingle(true)
				.setChieucao(1.65)
				.setCannang(66).build();
		System.out.println(stu);
	}

}
