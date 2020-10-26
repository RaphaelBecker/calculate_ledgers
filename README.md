# calculate_ledgers
This Java Maven Project takes Kraken ledgers.csv and calculates gains, losses, potential taxes etc. for each year in FIFO logic.
The program calculates the values without guarantee of completeness and correctness and should be considered as an estimate only.
This programm is not finished yet. 

- Currently there is only ledger.csv from KRAKEN and teh currencies: [ZEUR, XXBT, XETH, LINK, ADA, XXRP, XLTC, DASH, KAVA] provided.
To add new currencies, you have to define the format and rounding option in the Calculator.java class.

- To use this project, add your path to the main.java file: path = "add_path_to_ledger.cvs_here";

- The output is currently the balances and fees each year in the ledgers.csv like.
Taxes per trade in FIFO logig are yet to come.

Output:
YEAR:  2018   --------
Asset: ZEUR Amount: 0.0
Asset: XXBT Amount: 0.0
Asset: XETH Amount: 0.0
Asset: LINK Amount: 0.0
Asset: ADA Amount: 0.0
Asset: XXRP Amount: 0.0
Asset: XLTC Amount: 0.0
Asset: DASH Amount: 0.0
Asset: KAVA Amount: 0.0
---------------------
Asset: ZEUR Fee: 0.0
Asset: XXBT Fee: 0.0
Asset: XETH Fee: 0.0
Asset: LINK Fee: 0.0
Asset: ADA Fee: 0.0
Asset: XXRP Fee: 0.0
Asset: XLTC Fee: 0.0
Asset: DASH Fee: 0.0
Asset: KAVA Fee: 0.0
------------------------------------------------------------------------
YEAR:  2019   --------
Asset: ZEUR Amount: 0.0
Asset: XXBT Amount: 0.0
Asset: XETH Amount: 0.0
Asset: LINK Amount: 0.0
Asset: ADA Amount: 0.0
Asset: XXRP Amount: 0.0
Asset: XLTC Amount: 0.0
Asset: DASH Amount: 0.0
Asset: KAVA Amount: 0.0
---------------------
Asset: ZEUR Fee: 0.0
Asset: XXBT Fee: 0.0
Asset: XETH Fee: 0.0
Asset: LINK Fee: 0.0
Asset: ADA Fee: 0.0
Asset: XXRP Fee: 0.0
Asset: XLTC Fee: 0.0
Asset: DASH Fee: 0.0
Asset: KAVA Fee: 0.0
