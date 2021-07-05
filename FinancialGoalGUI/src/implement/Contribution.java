package implement;

public enum Contribution {

	DAILY(), WEEKLY(), MONTHLY(), ANNUAL();
 
 

	 
	public int getValue() {
		switch (this) {
		case DAILY:
			return  360;
		case WEEKLY:
			return  52;
		case MONTHLY:
			return 12;
		case ANNUAL:
			return  1;
		default:
			return 0;
		}

	}

}
