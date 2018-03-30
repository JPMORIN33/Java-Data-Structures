/**
 * Train carr class that holds the cargo type, the weight capacity and the car identification number
 * @author jmori156
 *
 */
public class TrainCar 
{
	public String cargoType;
	public int carNumber;
	public double weightCapacity;
	public TrainCar link;
	public TrainCar(int weightCapacity)
	{
		this.weightCapacity = weightCapacity;
	}
	public TrainCar()
	{
		link = null;
	}
	public TrainCar(String cargo, int number , double weightLimit)//constructs the train car with its variables
	{
		cargoType = cargo;
		carNumber = number;
		weightCapacity = weightLimit; 
		link = null;

	}
	/**
	 * Displays the properties of the train car
	 */
	public void display()
	{
		System.out.println("Train " + carNumber + " is carrying " + cargoType +  " with a weight capacity of " + weightCapacity);
	}
}
