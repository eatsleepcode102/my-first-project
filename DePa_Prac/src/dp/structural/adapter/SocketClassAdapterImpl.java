package dp.structural.adapter;

public class SocketClassAdapterImpl extends Socket implements SocketAdapter {

	@Override
	public Volt get3Volts() {
		// TODO Auto-generated method stub
		return new Volt(this.getVolt().getVolts()/40);
	}

	@Override
	public Volt get12Volts() {
		// TODO Auto-generated method stub
		return new Volt(this.getVolt().getVolts()/10);
	}

	@Override
	public Volt get120Volts() {
		// TODO Auto-generated method stub
		return this.getVolt();
	}

}
