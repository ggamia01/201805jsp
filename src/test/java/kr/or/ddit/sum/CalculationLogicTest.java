package kr.or.ddit.sum;

import static org.junit.Assert.*;
import implicit.CalculationLogic;

import org.junit.Test;

public class CalculationLogicTest {

	//1~10까지의 합
	@Test
	public void sumBetweenTwoNumbers() {
		CalculationLogic logic = new CalculationLogic();
		
		int start = 10;
		int end = 1;
		
		int result = logic.sumBetweenTwoNumbers(start, end);
		
		assertEquals(55, result);
	}

	@Test
	public void sumBetweenTwoNumbers2() {
		CalculationLogic logic = new CalculationLogic();
		
		int start = 1;
		int end = 10;
		
		int result = logic.sumBetweenTwoNumbers(start+2, end+2);
		
		assertEquals(75, result);
	}
}
