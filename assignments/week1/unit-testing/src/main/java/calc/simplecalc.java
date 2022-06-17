package calc;

import calc.exceptions.DivideBy0Exception;
import calc.exceptions.Number13Exception;

public class simplecalc {

	public int add(int a, int b) {
		if(a == 8 && b == 5 ) {
			throw new Number13Exception();
		}
		return a + b;
	}
	
	public int subtract(int a, int b) {
		return 0;
	}
	
	public int sumOfAnArray(int[] intArr) {
		return 0;
	}
	
	public int div(int a, int b) {
		if(b == 0) {
			throw new DivideBy0Exception();
		}
		return a / b;
	}

	

}
