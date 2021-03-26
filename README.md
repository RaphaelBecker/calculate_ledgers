# calculate_ledgers
This Java Maven Project takes ledgers.csv and calculates gains, losses, potential taxes etc. for each year in FIFO logic.
The program calculates the values without guarantee of completeness and correctness and should be considered as an estimate only.
This program is not finished yet.
- To use this project, add your path to the main.java file: path = "add_path_to_ledger.cvs_here";

- Currently provided:
  - Only ledger.csv from KRAKEN
  - currencies: [ZEUR, XXBT, XETH, LINK, ADA, XXRP, XLTC, DASH, KAVA]
  - To add new currencies, add new format and rounding option in the Calculator.java class.

- Wish List:
  - Introduce BigDecimal to avoid rounding issues
  - Enable List PDF export per annum:
    - Gains and losses per trade
    - Tax estimation in FIFO logig      
