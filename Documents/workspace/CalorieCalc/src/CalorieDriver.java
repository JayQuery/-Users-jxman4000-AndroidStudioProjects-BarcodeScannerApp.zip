/**
 * 
 */

/**
 * @author Jarrett
 *
 */
import javax.swing.JOptionPane;

public class CalorieDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		CalcData();
		System.exit(0);

	}
	/**
	 * Gee I wonder if someone entered an invalid input
	 * @param your value entered
	 * @return whether the value you entered is valid
	 */
	public static boolean isValid(String a)
	{
		if(a.equalsIgnoreCase("male"))
			return true;
		else if(a.equalsIgnoreCase("female"))
			return true;
		else
			return false;
	}
	
	public static void CalcData()
	{
		CalorieCalc A = new CalorieCalc();
		String input = "", B;
		int C = 0;
		double D = 0;
		input = JOptionPane.showInputDialog("Please enter your gender (male/female)");
		if (isValid(input) == false)
		{
			JOptionPane.showMessageDialog(null, "You have enetered an invalid value."
					+ "\nPlease make sure to type either (male/female)");
			input = JOptionPane.showInputDialog("Please enter your gender (male/female)");
		}
		A.setGender(input);
		
		input = JOptionPane.showInputDialog("Please enter your height (in total inches");
		D = Double.parseDouble(input);
		A.setHeight(D);
		
		input = JOptionPane.showInputDialog("Please enter your weight");
		D = Double.parseDouble(input);
		A.setWeight(D);
		
		input = JOptionPane.showInputDialog("Please enter your age");
		C = Integer.parseInt(input);
		A.setAge(C);
		System.out.println(A.toString());
		
		input = JOptionPane.showInputDialog("Please select your current activity level."
				+"\n1. Sedentary (no excercise)"
				+"\n2. Light Activity "
				+"\n3. Moderate Activity"
				+"\n4. Heavy Activity"
				+"\n5. Very Heavy Activity");
		//B = Integer.parseInt(input);
		A.setTDEE(input);
		
		
		System.out.println(A.toTDEE());
		
	}

}
