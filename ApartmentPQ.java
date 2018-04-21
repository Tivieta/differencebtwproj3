import java.util.*;


class CarPQ{
	
	IndexMinPQ<Double> prices;
	IndexMaxPQ<Integer> footage;
	List<Car> carList = new ArrayList<Car>(); 	
	int size =0;
	private int max;	
	//Car car;// = new Car();
	
	public CarPQ(){
		max = 100;
		prices = new IndexMinPQ(100);
		footage = new IndexMaxPQ(100);
		//carList = new Car[100];
	}
	
	public CarPQ( int n ){
		max = n;
		prices = new IndexMinPQ(n);
		footage = new IndexMaxPQ(n);
		//carList = new Car[n]; 
	}
	
	public void add( Car car ){
		if(size >= max ) {System.out.print("too mant cars!");return;}
		carList.add(car);
		prices.insert(size, car.getRent());
		footage.insert(size, car.getSqFeet());
		size++;
		
	}
	
	public void updatePrice(int i, double x){
		prices.change(i, x);
		Car car = new Car(carList.get(i));
		car.setRent(x);
		carList.set(i, car);
		
	}
	
	public void updateFootage(int i, int x){
		footage.change(i, x);
		Car car = new Car(carList.get(i));
		car.setSqFeet(x);
		carList.set(i, car);
		
	}
	
	public void delete( int i ){
		prices.delete(i);
		footage.delete(i);
		carList.set(i, carList.get(size-1));
		carList.remove(size-1);
		//prices.change(i, carList.get(i).getRent());
		//footage.change(i, carList.get(i).getSqFeet());
		size--;
		
	}
	
	public Car minPrice(){
		return carList.get( prices.minIndex() );
		//return null;
	}
	
	public Car maxSQFeet(){
		return carList.get(footage.maxIndex());
		//return null;
	}
}

