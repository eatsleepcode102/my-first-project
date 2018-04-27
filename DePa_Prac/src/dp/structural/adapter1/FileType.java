package dp.structural.adapter1;

public enum FileType {
	AVI {
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "AVI";
		}
	},
	
	MP3 {
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "MP3";
		}
	}
}

enum WhoisRIR {
    ARIN("whois.arin.net"),
    RIPE("whois.ripe.net"),
    APNIC("whois.apnic.net"),
    AFRINIC("whois.afrinic.net"),
    LACNIC("whois.lacnic.net"),
    JPNIC("whois.nic.ad.jp"),
    KRNIC("whois.nic.or.kr"),
    CNNIC("ipwhois.cnnic.cn"),
    UNKNOWN("");

    private String url;

    WhoisRIR(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
    
    public boolean containNet() {
    	return url.contains("net");
    }
}

enum Week {
	Mon("Monday", 2),
	Tue("Tuesday", 3);
	
	private String full;
	private int notfull;
	
	Week(String full, int notfull){
		this.full=full;
		this.notfull=notfull;
	}
	
	public Object[] getInfo() {
		return new Object[] {full, notfull};
	}
}