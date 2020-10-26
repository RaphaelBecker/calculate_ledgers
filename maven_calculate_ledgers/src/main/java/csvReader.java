
/*
 * https://attacomsian.com/blog/read-write-csv-files-apache-commons-csv
*/

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.*;

public class csvReader {

	// Used Assets:
	private ArrayList<String> usedAssets;
	private int numberOfAssets, numberOfEntries, earliestYear;
	
	public csvReader() {
		
		this.numberOfAssets = 0;
		this.numberOfEntries = 0;
		this.usedAssets = new ArrayList<String>();
		
	}

	// determines used assets, number of assets, number of entires, oldest year of trade
	public void determineTradedAsssets(String path) {
		try {
			String prevYear = "99999999";
			// create a reader
			Reader reader1 = Files.newBufferedReader(Paths
					.get(path));

			// read csv file
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()
					.parse(reader1);

			// Header: [aclass, amount, asset, balance, fee, refid, time, txid, type]
			// Print Entries:
			for (CSVRecord record : records) {
				
				numberOfEntries++;
				if (!usedAssets.contains(record.get("asset"))) {
					usedAssets.add(record.get("asset"));
					numberOfAssets++;
				}
				if (!prevYear.equals(record.get("time").substring(0, 4))){
					if (Integer.parseInt(prevYear) > Integer.parseInt(record.get("time").substring(0, 4))) {
						prevYear = record.get("time").substring(0, 4);
					}
				} 
				earliestYear = Integer.parseInt(prevYear);
			}

			// close the reader
			reader1.close();

		} catch (

		IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
	public int getNumberOfAssets() {
		return this.numberOfAssets;
	}
	
	public int getnumberOfEntries() {
		return this.numberOfEntries;
	}

	public int getEarliesTRadeYear() {
		return this.earliestYear;
	}
	
	// return -1 if String asset is not traded
	public int hashStringToIndex(String asset) {

		for(int i = 0; i < usedAssets.size(); i++)
			if (usedAssets.get(i).equals(asset))
			{
			return i;
			}
			return -1;
	}
	
	public void printTradedAssets() {
		System.out.println("Used assets: " + usedAssets);
		System.out.println("-----------------------------------------------------------------------");
	}
	
	public ArrayList<String> getUsedAssets(){
		return this.usedAssets;
	}
	
	public void printCSVList() {
		try {
			// create a reader
			Reader reader2 = Files.newBufferedReader(Paths
					.get("/Users/Hasi/eclipse-workspace/maven-cryptoTax/src/main/resources/ImputData/ledgers.csv"));

			// read csv file
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()
					.parse(reader2);

			// Header: [aclass, amount, asset, balance, fee, refid, time, txid, type]
			// Print Entries:
			for (CSVRecord record : records) {

				System.out.println("Entry " + record.getRecordNumber());
				System.out.println("aclass: " + record.get("aclass"));
				System.out.println("amount: " + record.get("amount"));
				System.out.println("asset: " + record.get("asset"));
				System.out.println("balance: " + record.get("balance"));
				System.out.println("refid: " + record.get("refid"));
				System.out.println("time: " + record.get("time"));
				System.out.println("txid: " + record.get("txid"));
				System.out.println("type: " + record.get("type"));

				// Shows index of asset bucket in array
				System.out.println("INDEX OF " + record.get("asset") + " IN USEDASSETS: "
						+ usedAssets.indexOf(record.get("asset")));
				System.out.println(" -------- ");
			}

			// close the reader
			reader2.close();

		} catch (

		IOException ex) {
			ex.printStackTrace();
		}
	}
	
}
