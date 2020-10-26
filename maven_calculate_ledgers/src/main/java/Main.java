
public class Main {

	private static String path;
	
	public static void main(String[] args) {
		
		// Path to Kraken ledgers.csv
		path = "add_path_to_ledger.cvs_here";

		// finds out which assets have been traded and stores them in csvReader.usedAssets ArrayList
		csvReader Reader = new csvReader();
		Reader.determineTradedAsssets(path);
		Reader.printTradedAssets();
		// Reader.printCSVList();  // prints CSV in and figure out which index of ArrayOfAssetBuckets belongs to the asset bucket (EntryLinkedList)
		
		
		// builds Data Structure: ArrayList (ArrayOfAssetBuckets) of empty asset buckets (EntryLinkedList)
		DataManager Manager = new DataManager(Reader.getNumberOfAssets());
		Manager.fillDataStructure(path);
		// Manager.printDataStructure();
		
		Manager.buildTradePairDataStructure();
		//Manager.printTradePairDataStructure();

		
		// TODO: ICH WILL WISSEN: GEWINN/VERLUST PRO TRADE NACH FIFO, STEUERN PRO TRADE, INVESTITIONSSUMME, ANZAHL AN TRADES, GESAMT GEWINN/VERLUST; 
		Calculator Calc = new Calculator(Reader.getNumberOfAssets(), 2019, 2020);
				
		Calc.calculateBalanceAllTime(Manager.getTradePairs(), Reader, Reader.getEarliesTRadeYear(), false);
		System.out.println("--------------------------");
		
		Calc.datelaterThanYear(Manager.getTradePairs(), "2018-01-04 08:19:46", 2017);


		
	}
}
