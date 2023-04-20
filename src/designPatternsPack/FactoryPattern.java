package designPatternsPack;

interface vehicle 
{
	public void drive(); 
}

class Car implements vehicle
{
	private String color;
	public Car(String color) {
	  this.color = color;
	}
	@Override
	public void drive() {
	
		System.out.println("Car of "+color+"is ready");
	}
}
class Bus implements vehicle
{
	private String color;
	public Bus(String color) {
		this.color = color;
	}
	@Override
	public void drive() {
		System.out.println("Bus of color "+color+ "is ready");
	}
}
class vehicleFactory
{
	public static vehicle createVehicle(String vehicleType ,String color)
	{
		if(vehicleType.equalsIgnoreCase("car"))
			return new Car(color);
		else if(vehicleType.equalsIgnoreCase("bus"))
			return new Bus(color);
		else throw new IllegalArgumentException("Invalid vehicle request"+vehicleType + "is unavailable");
	}
}
public class FactoryPattern {

	/*
	 * public static void main(String[] args) { vehicle redBus =
	 * vehicleFactory.createVehicle("bus", "red"); redBus.drive(); vehicle purpleCar
	 * = vehicleFactory.createVehicle("car", "purple"); purpleCar.drive(); }
	 */
}
