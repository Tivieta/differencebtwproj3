import java.util.*;


class PriceComparator implements Comparator<Car>{
	@Override
	public int compare( Car car1 , Car car2 ){
		return Double.compare(car1.getPrice(), car2.getPrice());
	}

}

class MileageComparator implements Comparator<Car>{
	@Override
	public int compare( Car car1 , Car car2 ){
		return Integer.compare(car1.getMileage(), car2.getMileage());
	}


}


class CarPQ{
	
	IndexMinPQ<Car> prices;
	IndexMinPQ<Car> mileage;
	List<Car> carList = new ArrayList<Car>(); // should I keep this?
	//maps VIN to Car
	//HashMap<String, Car> ncarList = new HashMap<String, Car>();	
	int size =0;
	private int max;	
	//Car car;// = new Car();
	
	public CarPQ(){
		max = 100;
		prices = new IndexMinPQ(100, new PriceComparator());
		mileage = new IndexMinPQ(100, new MileageComparator());
		//carList = new Car[100];
	}
	
	public CarPQ( int n ){
		max = n;
		prices = new IndexMinPQ(n, new PriceComparator());
		mileage = new IndexMinPQ(n, new MileageComparator());
		//carList = new Car[n]; 
	}
	
	public void add( Car car ){
		if(size >= max ) {
			System.out.print("too many cars!");
			return;
		}
		carList.add(car);
		prices.insert(size, car);
		mileage.insert(size, car);
		size++;
		
	}

	public void updateColor (int i, String color){
		for(Car c : carList){ //would be faster with a hash map
			if(c.equals(carList.get(i)))
			{
				c.setColor(color);
			}
		}

	}
	
	public void updatePrice(int i, double x){
		Car car = new Car(carList.get(i));
		car.setPrice(x);
		prices.change(i, car);
		mileage.change(i,car);
		carList.set(i, car);
		
	}
	
	public void updateMileage(int i, int x){
		Car car = new Car(carList.get(i));
		car.setMileage(x);
		prices.change(i, car);
		mileage.change(i, car);
		carList.set(i, car);
		
	}
	
	public void delete( int i ){
		prices.delete(i);
		mileage.delete(i);
		carList.set(i, carList.get(size-1));
		carList.remove(size-1);
		//prices.change(i, carList.get(i).getRent());
		//mileage.change(i, carList.get(i).getSqFeet());
		size--;
		
	}
	
	public Car minPrice(){
		return carList.get( prices.minIndex() );
		//return null;
	}
	
	public Car minMileage(){
		return carList.get(mileage.minIndex());
		//return null;
	}
}

