/**
 * 
 * @author Jarrett
 * This is a worker class for calculating calories of a specific individual.
 * Last update: 3/19/2016
 */
public class CalorieCalc {
	private String Gender;//Users gender
	private double Height;//Users height
	private double Weight;//Users weight
	private int Age;//Users Age
	private double BMR;//Users total calories burned per day
	private double BMI;//Users total Body Mass Index
	private double TDEE;//Users total daily energy expenditure 
	
	/**
	 * no-Arg constructor
	 */
	public CalorieCalc()
	{
		Gender = "";
		Height = 0;
		Weight = 0;
		Age = 0;
		BMR = 0;
		BMI = 0;
		TDEE = 0;
		
	}
	/**
	 * Constructor for each instance variable assignment
	 * @param A Gender
	 * @param B Height
	 * @param C Weight
	 * @param D Age
	 */
	public CalorieCalc(String A, double B, String C, int D)
	{
		Gender = A;
		Height = B;
		Weight = B;
		Age = D;
		setTDEE(C);
		
	}
	
	/**
	 * 
	 * @return Gender
	 */
	public String getGender() {
		return Gender;
	}

	/**
	 * 
	 * @param gender
	 */
	public void setGender(String gender) {
		Gender = gender;
	}

	/**
	 * 
	 * @return height
	 */
	public double getHeight() {
		return Height;
	}
	/**
	 * 
	 * @param height
	 */

	public void setHeight(double height) {
		this.Height = height;
	}

	/**
	 * 
	 * @return weight
	 */
	public double getWeight() {
		return Weight;
	}

	/**
	 * 
	 * @param weight
	 */
	public void setWeight(double weight) {
		Weight = weight;
	}

	public int getAge() 
	{
		return Age;
	}
	/**
	 * This method will calcuate the users BMR
	 * @return the total double value of BMR.
	 */
	public double getBMR()
	{
		double i = 0;
		if (Gender.equalsIgnoreCase("male"))
		{
			BMR = (Height * 12.7) + (Weight * 6.23) - (Age * 6.8);
			return BMR;
		}
		else if(Gender.equalsIgnoreCase("female"))
		{
			BMR = (Height * 4.7) + (Weight * 4.35) - (Age * 4.7);
			Female(BMR);
			return BMR;
		}
		else
			BMR = i;
		
		return BMR;
	}

	/**
	 * This method will set the age by input typed in.
	 * @param age
	 */
	public void setAge(int age) {
		Age = age;
	}
	/**
	 * This method will set and retrieve the BMI calculation
	 * @return BMI calculation
	 */
	public double getBMI()
	{
		BMI = (getWeight() * 703)/(Math.pow(getHeight(), 2));
		return BMI;
	}
	/**
	 * This method will set the TDEE based on daily activity selected.
	 * @param C choice selection called from the driver class.
	 */
	public void setTDEE(String C)
	{
		if(C.equals("Sedentary"))
		{
			TDEE = getBMR() * 1.2;
		}
		else if (C.equals("Light Activity"))
		{
			TDEE = getBMR() * 1.3;
		}
		else if (C.equals("Moderate Activity"))
		{
			TDEE = getBMR() * 1.55;
		}
		else if (C.equals("Heavy Activity"))
		{
			TDEE = getBMR() * 1.725;
		}
		else if (C.equals("Very Heavy Activity"))
		{
			TDEE = getBMR() * 1.9;
		}
		else
			TDEE = 0;
	}
	
	public double getTDEE()
	{
		return TDEE;
	}
	
	
	public void Female(double D)
	{
		BMR += 655;
	}
	/**
	 * This method will display the values entered and respective BMR 
	 * based on values entered.
	 */
	public String toString()
	{
		return "Gender: " + getGender()
				+ "\nAge: " + getAge() +" years old"
				+ "\nHeight: " + getHeight() + " Inches"
				+ "\nWeight: " + getWeight() +" Lbs" 
				+ "\nBMR: " + getBMR() + " Calories/day" 
				+ "\nBMI: " + getBMI() + " body mass index";			
	}
	/**
	 * A second toString method to print the TDEE
	 * @return Respective TDEE
	 */
	public String toTDEE()
	{
		return "TDEE: " + getTDEE() + " Daily Energy Expenditure"
				+"\nyou will need to achieve X number of excerciss per day"
				+"\n(to be continued)";
	}

}


