package dp.creational.abstract_factory1;


public class Main {
	public static void main(String[] args) {
		
		AbstractSmartphone sm=SmartphoneFactory.getSmartphone(new SamSungFactory("500 GB","2 GB","1200 x 1204"));
		System.out.println(sm);
		AbstractSmartWatch sssw=SmartWatchFactory.getSmartWatch(new SamSungFactory("12 GB", "1.5 GB", "2d15"));
		System.out.println(sssw);
		AbstractLaptop sl=LaptopFactory.getLaptop(new SamSungFactory("750 GB", "4 GB", "1204 x 786"));
		System.out.println(sl);
		
		System.out.println("---");
		
		AbstractSmartWatch sw=SmartWatchFactory.getSmartWatch(new AppleFactory("24 GB", "1 GB", "2d30"));
		System.out.println(sw);
		AbstractLaptop am=LaptopFactory.getLaptop(new AppleFactory("1 TB", "16 GB", "2500 x 3690"));
		System.out.println(am);
		AbstractSmartphone asp=SmartphoneFactory.getSmartphone(new AppleFactory("1 TB", "16 GB", "2500 x 3690"));
		System.out.println(asp);
				
		System.out.println("---");
		
		AbstractLaptop sonyl=LaptopFactory.getLaptop(new SonyFactory("320 GB", "8 GB", "1200 x 2400"));
		System.out.println(sonyl);
		AbstractSmartphone sosm=SmartphoneFactory.getSmartphone(new SonyFactory("32 Gb", "2 GB", "320 x 460"));
		System.out.println(sosm);
		AbstractSmartWatch smsw=SmartWatchFactory.getSmartWatch(new SonyFactory("32 Gb", "2 GB", "320 x 460"));
		System.out.println(smsw);
		
		System.out.println("---");
		
		AbstractSelfDriveCar tc=SelfDriveCarProducer.getSelfDriveCar(new TesLaFactory("350 ML", "ubuntu"));
		System.out.println(tc);
		AbstractSmartphone tsm=SmartphoneFactory.getSmartphone(new TesLaFactory("32 Gb", "2 GB", "320 x 460"));
		System.out.println(tsm);
		
	}
}
