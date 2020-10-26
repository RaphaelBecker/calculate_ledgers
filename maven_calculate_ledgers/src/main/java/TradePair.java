
public class TradePair {
	

	// Attributes ************************************************
	private int recordNumber1;
	private String aclass1;
	private double amount1;
	private String asset1;
	private double balance1;
	private double fee1;
	private String refid1;
	private String time1;
	private String txid1;
	private String type1;
	
	private int recordNumber2;
	private String aclass2;
	private double amount2;
	private String asset2;
	private double balance2;
	private double fee2;
	private String refid2;
	private String time2;
	private String txid2;
	private String type2;

	
	// Constructor ************************************************
	// Two Entries
	TradePair(Entry first, Entry second) {

		this.recordNumber1 = first.getRecordNumber();
		this.aclass1 = first.getAclass();
		this.amount1 = first.getAmount();
		this.asset1 = first.getAsset();
		this.balance1 = first.getBalance();
		this.fee1 = first.getFee();
		this.refid1 = first.getRefid();
		this.time1 = first.getTime();
		this.txid1 = first.getTxid();
		this.type1 = first.getType();
		
		this.recordNumber2 = second.getRecordNumber();
		this.aclass2 = second.getAclass();
		this.amount2 = second.getAmount();
		this.asset2 = second.getAsset();
		this.balance2 = second.getBalance();
		this.fee2 = second.getFee();
		this.refid2 = second.getRefid();
		this.time2 = second.getTime();
		this.txid2 = second.getTxid();
		this.type2 = second.getType();
	}

	// Single values
	TradePair(int recordNumber1, String aclass1, double amount1, String asset1, double balance1, double fee1, String refid1, String time1,
			String txid1, String type1, int recordNumber2, String aclass2, double amount2, String asset2, double balance2, double fee2, String refid2, String time2,
			String txid2, String type2) {

		this.recordNumber1 = recordNumber1;
		this.aclass1 = aclass1;
		this.amount1 = amount1;
		this.asset1 = asset1;
		this.balance1 = balance1;
		this.fee1 = fee1;
		this.refid1 = refid1;
		this.time1 = time1;
		this.txid1 = txid1;
		this.type1 = type1;
		
		this.recordNumber2 = recordNumber2;
		this.aclass2 = aclass2;
		this.amount2 = amount2;
		this.asset2 = asset2;
		this.balance2 = balance2;
		this.fee2 = fee2;
		this.refid2 = refid2;
		this.time2 = time2;
		this.txid2 = txid2;
		this.type2 = type2;
	}

	

	// Methods ****************************************************
	public boolean checkTradePair() {
		
		// fisrst and second are the same Entry or diffrent refidIds means not same trade Entry
		if (this.recordNumber1 == this.recordNumber2 || !this.refid1.equals(this.refid2)) {
		return false;	
		}
		return true;
	}
	
	public String toString() {
		return recordNumber1 + " " + aclass1 + " " + amount1 + " " + asset1 + " " + balance1 + " "
				+ refid1 + " " + time1 + " " + txid1 + " " + type1 + " " + recordNumber2 + " " + aclass2 + " " + amount2 + " " + asset2 + " " + balance2 + " "
				+ refid2 + " " + time2 + " " + txid2 + " " + type2;
	}
	
	
	
	// GETTER *****************************************************
	
	public int getRecordNumber1() {
		return recordNumber1;
	}

	public String getAclass1() {
		return aclass1;
	}

	public double getAmount1() {
		return amount1;
	}
	

	public String getAsset1() {
		return asset1;
	}

	public double getBalance1() {
		return balance1;
	}
	
	public double getFee1() {
		return fee1;
	}

	public String getRefid1() {
		return refid1;
	}

	public String getTime1() {
		return time1;
	}

	public String getTxid1() {
		return txid1;
	}

	public String getType1() {
		return type1;
	}

	public int getRecordNumber2() {
		return recordNumber2;
	}

	public String getAclass2() {
		return aclass2;
	}

	public double getAmount2() {
		return amount2;
	}

	public String getAsset2() {
		return asset2;
	}

	public double getBalance2() {
		return balance2;
	}
	
	public double getFee2() {
		return fee2;
	}

	public String getRefid2() {
		return refid2;
	}

	public String getTime2() {
		return time2;
	}

	public String getTxid2() {
		return txid2;
	}

	public String getType2() {
		return type2;
	}
	

}
