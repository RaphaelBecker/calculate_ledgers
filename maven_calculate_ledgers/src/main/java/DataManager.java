import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class DataManager {
	
	// Attributes
	private double doubleAmount, doubleBalance, doubleFee;
	public int numberOfUsedAssets;
	private LinkedList<Entry> EntryList;
	private LinkedList<Entry> ArrayOfAssetBuckets[];
	private LinkedList<TradePair> TradePairs;
	
	// Constructor
	public DataManager(int numberOfUsedAssets) {
		this.numberOfUsedAssets = numberOfUsedAssets;
		this.ArrayOfAssetBuckets = new LinkedList[numberOfUsedAssets];
		this.EntryList = new LinkedList();
		this.TradePairs = new LinkedList();
	}

	// Fills Linked List with all Entries from csvReader:
	public void fillDataStructure(String path) {
		
		try {
			// create a reader object
			Reader reader4 = Files.newBufferedReader(Paths
					.get(path));

			// define a instance of CSVRecords as record:
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()
					.parse(reader4);

			// write entries from CSV list to the index of the array of linked lists according to  
			for (CSVRecord record : records) {

				// Parse amount from String to Double
				try {
					doubleAmount = Double.parseDouble(record.get("amount"));
				} catch (NumberFormatException e) {
					doubleAmount = 0;
				} catch (NullPointerException e) {
					doubleAmount = 0;
				}
				// Parse balance from String to Double
				try {
					doubleBalance = Double.parseDouble(record.get("balance"));
				} catch (NumberFormatException e) {
					doubleBalance = 0;
				} catch (NullPointerException e) {
					doubleBalance = 0;
				}
				// parse fee from String to Double
				try {
					doubleFee = Double.parseDouble(record.get("fee"));
				} catch (NumberFormatException e) {
					doubleBalance = 0;
				} catch (NullPointerException e) {
					doubleBalance = 0;
				}
				
				// Header: [aclass, amount, asset, balance, fee, refid, time, txid, type]
				EntryList.add(new Entry((int)record.getRecordNumber(), record.get("aclass"), doubleAmount, record.get("asset"), doubleBalance, doubleFee, record.get("refid"), record.get("time"),
						record.get("txid"), record.get("type")));
			}

			// close the reader
			reader4.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	// prints Linked List with Entries on screen:
	public void printDataStructure() {
		
		for(Entry item: this.EntryList){
		    System.out.println(item);
		}
	}
	
	public void buildTradePairDataStructure() {
				
		Entry first = new Entry();
		Entry second = new Entry();
		
        for (int i = 0; i < this.EntryList.size() - 1; i++) {
            
        	first = this.EntryList.get(i);
            
            int y = i + 1;
            // search for y, for same items
            while (!first.getRefid().equals(this.EntryList.get(y).getRefid()) && y < (this.EntryList.size() - 2)) {
            	y++;
            }
            // found same items 
            if (first.getRefid().equals(this.EntryList.get(y).getRefid())) {
            second = this.EntryList.get(y);
            
            // for debugging:******************************************
            //System.out.println("first: " + first);
            //System.out.println("second: " + second);
            //System.out.println("-------------------");
            //*********************************************************
            
            // build TradePair Data structure
            TradePairs.add(new TradePair(first, second));
            // if the same Entries are beneath list, there is no need for iterating through the rest of the lsit anymore
            if (first.getRecordNumber() == (second.getRecordNumber() - 1)) {
            	i++;
            }
            }
            // TODO Case: If second is not in list. What values has second to be to not crash calculation?
        }
	}
	
	public void printTradePairDataStructure() {
		
		for(TradePair item : TradePairs) {
			System.out.println("Tradepair: " + item);
			if (item.checkTradePair()){
			System.out.println("TradePair: Ok");
			} else {System.out.println("TradePair: ERROR!"); }
		}
	}
	
	
	// Getter ********************************************************************
	public int getSizeOfTradePairs() {

		return TradePairs.size();
	}

	public LinkedList<TradePair> getTradePairs() {
		return TradePairs;
	}
	
	
	
	
	
	
	// ---------------------------------------------------------------------------
	// NOT USED:
	// ---------------------------------------------------------------------------
	// builds an Array of Linked Lists. One Linked List for one asset
	public void buildDataStructureByAssetBuckets() {
		for (int i = 0; i < this.numberOfUsedAssets; i++) {
			ArrayOfAssetBuckets[i] = new LinkedList<Entry>();
		}
	}
	
	// copies Entries from CSV file to array of Linked Lists. Every asset is copied in the according index linked list 
	public void fillDataStructureByAssetBuckets(ArrayList<String> usedAssets) {
		
		try {
			// create a reader object
			Reader reader3 = Files.newBufferedReader(Paths
					.get("/Users/Hasi/eclipse-workspace/maven-cryptoTax/src/main/resources/ImputData/ledgers.csv"));

			// define a instance of CSVRecords as record:
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()
					.parse(reader3);

			// write entries from CSV list to the index of the array of linked lists according to  
			for (CSVRecord record : records) {

				// Parse amount from String to long
				try {
					doubleAmount = Double.parseDouble(record.get("amount"));
				} catch (NumberFormatException e) {
					doubleAmount = 0;
				} catch (NullPointerException e) {
					doubleAmount = 0;
				}
				// Parse balance from String to long
				try {
					doubleBalance = Double.parseDouble(record.get("balance"));
				} catch (NumberFormatException e) {
					doubleBalance = 0;
				} catch (NullPointerException e) {
					doubleBalance = 0;
				}
				// parse fee from String to Double
				try {
					doubleFee = Double.parseDouble(record.get("fee"));
				} catch (NumberFormatException e) {
					doubleFee = 0;
				} catch (NullPointerException e) {
					doubleFee = 0;
				}
				
				// Header: [aclass, amount, asset, balance, fee, refid, time, txid, type]
				ArrayOfAssetBuckets[usedAssets.indexOf(record.get("asset"))]
				.add(new Entry((int)record.getRecordNumber(), record.get("aclass"), doubleAmount, record.get("asset"), doubleBalance, doubleFee, record.get("refid"), record.get("time"),
						record.get("txid"), record.get("type")));
				
				// Fill the DataStructure with csv data
//				System.out.println("INDEX OF " + record.get("asset") + " IN USEDASSETS: "
//						+ csvReader.usedAssets.indexOf(record.get("asset")));
//				System.out.println(" -------- ");
			}

			// close the reader
			reader3.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// prints ArrayOfAssetBuckets
	public void printDataStructureByAssetBuckets() {
		
		for (int i = 0; i < this.numberOfUsedAssets; i++) {
			System.out.println(ArrayOfAssetBuckets[i]);
		}
	}
	
}
