package dp.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public class ChannelCollectionImpl implements ChannelCollection {

	private List<Channel> channelsList;
	
	public ChannelCollectionImpl() {
		channelsList=new ArrayList<>();
	}

	@Override
	public void addChannel(Channel c) {
		// TODO Auto-generated method stub
		channelsList.add(c);
	}

	@Override
	public void removeChannel(Channel c) {
		// TODO Auto-generated method stub
		channelsList.remove(c);
	}

	@Override
	public ChannelIterator iterator(ChannelTypeEnum type) {
		// TODO Auto-generated method stub
		return new ChannelIteratorImpl(type, channelsList);
	}

}
