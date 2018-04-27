package resource_handling;

import javax.inject.Named;

@Named
public class RHName {
	 private String first;
	    private String last;

	    public RHName() {
	    }

	    public RHName(String first, String last) {
	        this.first = first;
	        this.last = last;
	    }

	    public String getFirst() {
	        return first;
	    }

	    public void setFirst(String first) {
	        this.first = first;
	    }

	    public String getLast() {
	        return last;
	    }

	    public void setLast(String last) {
	        this.last = last;
	    }

	    public String toString() {
	        return last + ", " + first;
	    }
}
