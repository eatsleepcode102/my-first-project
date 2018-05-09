package dp.behavioral.observer;

public class MyTopicSubcriber implements Observer{

	private String name;
	private Subject topic;
	
	public MyTopicSubcriber(String nm) {
		// TODO Auto-generated constructor stub
		this.name=nm;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		String msg=(String) topic.getUpdate(this);
		if(msg ==null) {
			System.out.println(name+ ":: No new message");
		} else {
			System.out.println(name+":: Consuming mesage::"+msg);
		}
	}

	@Override
	public void setSubject(Subject sub) {
		// TODO Auto-generated method stub
		this.topic=sub;
	}
}
