package dp.behavioral.observer;

public class ObserverPatternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTopic topic=new MyTopic();
		Observer obj1=new MyTopicSubcriber("Obj1");
		Observer obj2=new MyTopicSubcriber("Obj2");
		Observer obj3=new MyTopicSubcriber("Obj3");
		Observer obj4=new MyTopicSubcriber("Obj4");
		topic.register(obj1);
		topic.register(obj2);
		topic.register(obj3);
		
		obj1.setSubject(topic);
		obj2.setSubject(topic);
		obj3.setSubject(topic);
		
		obj2.update();
		topic.register(obj4);
		obj4.setSubject(topic);
		topic.postMessage("New Messages");
		
	}
}
