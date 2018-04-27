package dp.structural.adapter1;

public class MyPlayer implements Player {

	MyAudioPlayer map=new MyAudioPlayer();
	MyVideoPlayer mvp=new MyVideoPlayer();
	
	@Override
	public void play(FileType avi) {
		// TODO Auto-generated method stub
		if(FileType.AVI.equals(avi)) {
			mvp.videoPlay();
		} else if(FileType.MP3.equals(avi)) {
			map.audioPlay();
		}
	}

	
}
