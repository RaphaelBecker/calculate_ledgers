import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {


	@Test
	void format() {
		csvReader Reader = new csvReader();
		Calculator CalcTest = new Calculator(Reader.getNumberOfAssets(), 2019, 2020);
		
		double expected = 0.073;
		double actual = CalcTest.format(0.073, "XXBT");
		assertEquals(expected, actual);
	}

	@Test
	void laterThanYear() {
		csvReader Reader = new csvReader();
		DataManager Manager = new DataManager(Reader.getNumberOfAssets());
		Calculator CalcTest = new Calculator(Reader.getNumberOfAssets(), 2019, 2020);
		
		boolean expected = false;
		boolean actual = CalcTest.datelaterThanYear(Manager.getTradePairs(), "2018-01-04 08:19:46", 2017);
		assertEquals(expected, actual);
	}
	
}
