package implicit;

public class CalculationLogic {
	
	public static void main(String[] args){
		CalculationLogic logic = new CalculationLogic();
		
		int start = 1;
		int end = 10;
		
		int result = logic.sumBetweenTwoNumbers(start, end);
		
		if(result == 55){
			System.out.println("정답");
		}else{
			System.out.println("오답");
		}
		
		result = logic.sumBetweenTwoNumbers(start+2, end+2);
		
		if(result == 75){
			System.out.println("정답");
		}else{
			System.out.println("오답");
		}
	}

	public int sumBetweenTwoNumbers(int start, int end) {
		int min=Math.min(start, end);
		int max = Math.max(start, end);
		
		int sumResult = 0;
		for(int i=min; i<=max; i++){
			sumResult += i;
		}
		return sumResult;
	}
	
}
