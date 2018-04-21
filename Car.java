class Car implements Comparable<Car> {
	
	protected String VIN;
	protected String make;
	protected String model;
	protected double price;
	protected int mileage;
	protected String color;

	public Car(){
		// PUAF85WU5R6Q6H1P9:Ford:Fiesta:15020:1000:Red
		this.VIN = "PUAF85WU5R6Q6H1P9";
		this.make = "Ford";
		this.model = "Fiesta";
		this.price = 15020.00;
		this.mileage = 1000;
		this.color = "Red";
	
	}

	public Car( Car c )
	{
		this.VIN = c.getVIN();
		this.make = c.getMake();
		this.model = c.getModel();
		this.price = c.getPrice();
		this.mileage = c.getMileage();
		this.color = c.getColor();
	}

	public Car( String newVIN, String newMake, String newModel, double newPrice, int newMileage, String newColor)
	{
		this.VIN = newVIN;
		this.make = newMake;
		this.model = newModel;
		this.price = newPrice;
		this.mileage = newMileage;
		this.color = newColor;

	}

	public String getVIN() { return VIN; }
	public void setVIN( String x ){ this.VIN = x; }

	public String getMake() { return make; }
	public void setMake( String x  ){ this.make = x; }

	public String getModel() { return model; }
	public void setModel( String x ) { this.model = x; }

	public double getPrice() { return price; }
	public void setPrice(double x) { this.price = x; }

	public int getMileage() { return mileage; }
	public void setMileage( int x ){ this.mileage = x; }

	public String getColor() { return color; }
	public void setColor( String x ) { this.color = x; }

	@Override 
	public int compareTo( Car
	 other ){
		if(other instanceof Car ){
			if(((Car)other).getVIN().equals(this.getVIN()))
				return 0;
			else 
				return 1;
		}else{
			return -1;
		}
	}

	public boolean equals(Car c)
	{
		if( this.compareTo(c) == 0 ) return true;
		else return false;
	}

	@Override
	public String toString()
	{
		return String.format("VIN#: %s\n\tMake: %s\n\tModel: %s\n\tPrice: $%.2f\n\tMileage: %s miles \n\tcolor: %s\n", VIN, make, model, price, mileage, color);
	}

}