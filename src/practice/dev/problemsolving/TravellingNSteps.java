package practice.dev.problemsolving;

public class TravellingNSteps {

	public static void main(String [] args) {
		travellingStepsTill(9);
	}
	
	public static void travellingStepsTill(int numberOfSteps) {
		int step = 0, stepsToIncrement = 0, stepsReached = 0, remainingSteps = 5; 
		
		while(step < numberOfSteps) {// start with 1,2,3,4 ... incrementally
			
			System.out.println("[ ");
			
			++stepsToIncrement;
			
			stepsReached = 0;// reset for each outer iteration
			remainingSteps = numberOfSteps;// reset for each outer iteration
			
			System.out.print("(");
			
			while(stepsReached < numberOfSteps) {// incremental jumps w.r.t each starting step, jump till u reach
				
				remainingSteps = (numberOfSteps - stepsReached);
				stepsReached += stepsToIncrement;//last iteration may exceed
				if(stepsReached > numberOfSteps) {
					
					System.out.print("," + remainingSteps);
					
					break;
				}
				
				System.out.print("," + stepsToIncrement);
				
			}
			
			++step;//Go for next step
			
			System.out.println(")");
			System.out.println("]");
			System.out.println();
		}
	}
}
