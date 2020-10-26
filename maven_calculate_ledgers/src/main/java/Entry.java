
// import java.util.LinkedList;

public class Entry {

	private int recordNumber;
	private String aclass;
	private double amount;
	private String asset;
	private double balance;
	private double fee;
	private String refid;
	private String time;
	private String txid;
	private String type;

	// Empty Constructor
	Entry(){};
	
	// Constructor: HEADER [aclass, amount, asset, balance, fee, refid, time, txid, type]
	Entry(int recordNumber, String aclass, double amount, String asset, double balance, double fee, String refid, String time,
			String txid, String type) {

		this.recordNumber = recordNumber;
		this.aclass = aclass;
		this.amount = amount;
		this.asset = asset;
		this.balance = balance;
		this.fee = fee;
		this.refid = refid;
		this.time = time;
		this.txid = txid;
		this.type = type;
	}

	public String toString() {
		return recordNumber + " " + aclass + " " + amount + " " + asset + " " + balance + " "
				+ refid + " " + time + " " + txid + " " + type;
	}

	public int getRecordNumber() {
		return recordNumber;
	}

	public String getAclass() {
		return aclass;
	}

	public double getAmount() {
		return amount;
	}

	public String getAsset() {
		return asset;
	}

	public double getBalance() {

		return balance;
	}
	
	public double getFee() {
		return fee;
	}

	public String getRefid() {
		return refid;
	}

	public String getTime() {
		return time;
	}

	public String getTxid() {
		return txid;
	}

	public String getType() {
		return type;
	}

}