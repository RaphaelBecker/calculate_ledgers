import java.util.LinkedList;
import java.lang.Math;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;


// ICH WILL WISSEN: GEWINN/VERLUST PRO TRADE NACH FIFO, STEUERN PRO TRADE, INVESTITIONSSUMME, ANZAHL AN TRADES, GESAMT GEWINN/VERLUST; 
// PRO JAHR!		

public class Calculator {

	private int fromYear, toYear;
	private double gain, tax;
	private double[] Balance;
	private double[] Fee;

	// Constructor
	Calculator(int numberOfAssets, int fromYear, int toYear) {
		this.Balance = new double[numberOfAssets];
		this.Fee = new double[numberOfAssets];
		this.fromYear = fromYear;
		this.toYear = toYear;
	}
	
	public double format(double amount, String asset){
		
		if (asset.equals("ZEUR")) {
			DecimalFormat EUR = new DecimalFormat("#.###");
			EUR.setRoundingMode(RoundingMode.FLOOR);
			try {
			return DecimalFormat.getNumberInstance().parse(EUR.format(amount)).doubleValue();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} 
		if (asset.equals("XXBT")) {
			DecimalFormat BTC = new DecimalFormat("#.#########");
			BTC.setRoundingMode(RoundingMode.FLOOR);
			try {
			return DecimalFormat.getNumberInstance().parse(BTC.format(amount)).doubleValue();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} 
		
		if (asset.equals("XETH")) {
			DecimalFormat ETH = new DecimalFormat("#.#####");
			ETH.setRoundingMode(RoundingMode.FLOOR);
			try {
			return DecimalFormat.getNumberInstance().parse(ETH.format(amount)).doubleValue();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		if (asset.equals("LINK")) {
			DecimalFormat LINK = new DecimalFormat("#.###");
			LINK.setRoundingMode(RoundingMode.FLOOR);
			try {
			return DecimalFormat.getNumberInstance().parse(LINK.format(amount)).doubleValue();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		if (asset.equals("ADA")) {
			DecimalFormat ETH = new DecimalFormat("#");
			ETH.setRoundingMode(RoundingMode.FLOOR);
			try {
			return DecimalFormat.getNumberInstance().parse(ETH.format(amount)).doubleValue();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		if (asset.equals("XXRP")) {
			DecimalFormat XRP = new DecimalFormat("#");
			XRP.setRoundingMode(RoundingMode.FLOOR);
			try {
			return DecimalFormat.getNumberInstance().parse(XRP.format(amount)).doubleValue();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		if (asset.equals("XLTC")) {
			DecimalFormat LTC = new DecimalFormat("#.###");
			LTC.setRoundingMode(RoundingMode.FLOOR);
			try {
			return DecimalFormat.getNumberInstance().parse(LTC.format(amount)).doubleValue();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		if (asset.equals("DASH")) {
			DecimalFormat DASH = new DecimalFormat("#.###");
			DASH.setRoundingMode(RoundingMode.FLOOR);
			try {
			return DecimalFormat.getNumberInstance().parse(DASH.format(amount)).doubleValue();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		if (asset.equals("KAVA")) {
			DecimalFormat KAVA = new DecimalFormat("#.###");
			KAVA.setRoundingMode(RoundingMode.FLOOR);
			try {
			return DecimalFormat.getNumberInstance().parse(KAVA.format(amount)).doubleValue();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		// TODO: Implement XETH, LINK, ADA, XXRP, XLTC, DASH, KAVA]
		
		return -1;

	}  

	public boolean datelaterThanYear(LinkedList<TradePair> TradePairs, String Date, int year) {

		if (year <= Integer.parseInt(Date.substring(0, 4))) {
			return false;
		}else {
		
		return true;
		}
	}

	public void printBalance(csvReader csvReader, int year) {
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("YEAR:  " + year + "   --------");
		for (int y = 0; y < csvReader.getNumberOfAssets(); y++) {
			System.out.println("Asset: " + csvReader.getUsedAssets().get(y) + " Amount: " + Balance[y]);
		}
	}
	
	public void printFees(csvReader csvReader) {
		for (int y = 0; y < csvReader.getNumberOfAssets(); y++) {
			System.out.println("Asset: " + csvReader.getUsedAssets().get(y) + " Fee: " + Fee[y]);
		}

	}
	
	public void calculateBalanceAllTime(LinkedList<TradePair> TradePairs, csvReader csvReader, int oldestTradeYear, boolean printLog) {

		double prevBalance1 = 0;
		double prevBalance2 = 0;
		double amount1 = 0;
		double amount2 = 0;
		double balance1 = 0;
		double balance2 = 0;
		double fee1 = 0;
		double fee2 = 0;
		int assetIndex1 = -1; 
		int assetIndex2 = -1;
		int RecNumber1 = 0;
		int RecNumber2 = 0;
		int prevYear = oldestTradeYear;
		
		for (int i = 0; i < TradePairs.size(); i++) {

			if (prevYear < Integer.parseInt(TradePairs.get(i).getTime1().substring(0, 4))){
				printBalance(csvReader, prevYear);
				System.out.println("---------------------");
				printFees(csvReader);
				prevYear = Integer.parseInt(TradePairs.get(i).getTime1().substring(0, 4));
				}
			
			
			// get all variables for better readability
			prevBalance1 = format(Balance[csvReader.hashStringToIndex(TradePairs.get(i).getAsset1())], TradePairs.get(i).getAsset1());
			prevBalance2 = format(Balance[csvReader.hashStringToIndex(TradePairs.get(i).getAsset2())], TradePairs.get(i).getAsset2());
			amount1 = format(TradePairs.get(i).getAmount1(), TradePairs.get(i).getAsset1());
			amount2 = format(TradePairs.get(i).getAmount2(), TradePairs.get(i).getAsset2());
			balance1 = format(TradePairs.get(i).getBalance1(), TradePairs.get(i).getAsset1());
			balance2 = format(TradePairs.get(i).getBalance2(), TradePairs.get(i).getAsset2());
			fee1 = format(TradePairs.get(i).getFee1(), TradePairs.get(i).getAsset1());
			fee2 = format(TradePairs.get(i).getFee2(), TradePairs.get(i).getAsset2());
			assetIndex1 = csvReader.hashStringToIndex(TradePairs.get(i).getAsset1());
			assetIndex2 = csvReader.hashStringToIndex(TradePairs.get(i).getAsset2());
			RecNumber1 = TradePairs.get(i).getRecordNumber1();
			RecNumber2 = TradePairs.get(i).getRecordNumber2();
			
			// If deposit or withdrawal then only take one of the two amounts into the balance array
			if (TradePairs.get(i).getType1().equals("deposit") || TradePairs.get(i).getType1().equals("withdrawal") && TradePairs.get(i).getAsset1().equals("ZEUR")) {		
				//Balance[assetIndex1] = format(prevBalance1 + (amount1 - fee1), TradePairs.get(i).getAsset1());
				//System.out.println("Debugg Balance: " + Balance[assetIndex1] + " = " + prevBalance1 + " + " + amount1 + " - " + fee1);
				
			}
			// if trade, then take the two different amounts into the different balance array buckets
			else if (TradePairs.get(i).getType1().equals("trade")) {
				
				Balance[assetIndex1] = format(prevBalance1 + (amount1 - fee1), TradePairs.get(i).getAsset1());
				Balance[assetIndex2] = format(prevBalance2 + (amount2 - fee2), TradePairs.get(i).getAsset2());
				//System.out.println("Debugg1: Balance: " + Balance[assetIndex1] + " = " + prevBalance1 + " + " + amount1 + " - " + fee1);
				//System.out.println("Debugg2: Balance: " + Balance[assetIndex2] + " = " + prevBalance2 + " + " + amount2 + " - " + fee2);
			}
			
			if (printLog) {
			System.out.println("----------------------------------------------------------------------------------------------------------");
			System.out.println("RN: " + RecNumber1 
					+ ",	" + TradePairs.get(i).getAsset1() 
					+ ",	Amount: " + amount1
					+ ",		Balance: " + Balance[assetIndex1]
					+ ",		Balance CSV: " + balance1 
					+ ",	Type: " + TradePairs.get(i).getType1()
					+ ",	Fee: " + fee1);

			System.out.println(
					"RN: " + RecNumber2 
					+ ",	 " + TradePairs.get(i).getAsset2() 
					+ ",	Amount: " + amount2
					+ ",		Balance: " + Balance[assetIndex2]
					+ ",		Balance CSV: " + balance2 
					+ ",	Type: " + TradePairs.get(i).getType2()
					+ ",	Fee: " + fee2);
			}

			// Collect fees:
			Fee[assetIndex1] = format(Fee[assetIndex1] + TradePairs.get(i).getFee1(), TradePairs.get(i).getAsset1());
			Fee[assetIndex2] = format(Fee[assetIndex2] + TradePairs.get(i).getFee2(), TradePairs.get(i).getAsset2());
		}
		printBalance(csvReader, prevYear);
		System.out.println("---------------------");
		printFees(csvReader);
	}




}
