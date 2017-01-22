/**
 * 
 */

/**
 * @author Jarrett
 *
 */
public class BMICalc {
	private CalorieCalc A;
	private double BMI;
	
	public BMICalc()
	{
		BMI = 0;
	}
	
	public double getBMI()
	{
		BMI = (A.getWeight() * 703/(Math.pow(A.getHeight(), 2)));
		return BMI;
	}
	
	public String toString()
	{
		return "BMI : " + getBMI();
	}

}
