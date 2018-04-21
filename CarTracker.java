import java.util.*;
import java.io.*;




class CarTracker{
	
	//static CarPQ CarList = new CarPQ();
	static IndexMinPQ<Car> carPrice = new IndexMinPQ<Car>(100, new PriceComparator());
	static IndexMinPQ<Car> carMileage = new IndexMinPQ<Car>(100, new MileageComparator());
	//static HashSet<String> makeModel = new HashSet<String>();


	
	public static void main(String args[]) throws Exception{
		
		Scanner in = new Scanner(System.in);
		BufferedReader file = new BufferedReader(new FileReader("cars.txt"));

		file.readLine();// skips first line

		while(file.read()!= -1){

			String line = file.readLine();

			String words[] = line.split(":");
			//# VIN:Make:Model:Price:Mileage:Color
			Car car = new Car(words[0],words[1],words[2], Double.parseDouble(words[3]), Integer.parseInt(words[4]) , words[5]);
			add(car);

		}

		listCars();

		while(true){
			
			System.out.println("Options:\n(1) Add car");
			System.out.println("(2) Update car");
			System.out.println("(3) Remove car");
			System.out.println("(4) Find lowest priced car");
			System.out.println("(5) Find lowest mileage car");
			System.out.println("(6) Find lowest priced car in a certain make and model");
			System.out.println("(7) Find lowest mileage car in a certain make and model");
			System.out.println("(8) Exit and print all");
			System.out.println("(9) Exit");
			System.out.println("What would you like to do? [Type Number]");
			int option = in.nextInt();
			
			switch(option){
				case 1: 
					//addCar
					add();
				break;
				case 2: 
					//UpdateCar
					update();
					
				break;
				case 3: 
					//RemoveCar
					System.out.printf("select an car to remove:\n");
					listCars();
					option = in.nextInt();
					delete( option );
					
				break;
				case 4: 
					//lowest priced car
					System.out.printf("%s\n",carPrice.minT().toString());
					
				break;
				case 5: 
					//lowest mileage car
					System.out.printf("%s\n",carMileage.minT().toString());
					
				break;
				case 6: {
					//lowest priced car with a certain make and model
					IndexMinPQ<Car> carMake = new IndexMinPQ<Car>(100, new PriceComparator());
					System.out.println("Finding lowest priced make and model");
					System.out.println("Enter make : ");
					String x = in.next();
					System.out.println("Enter model : ");
					String y = in.next();

					for( int items =1; items<carPrice.size();items++){
						Car c = carPrice.keyOf(items);
						if( c.getMake().equals(x) && c.getModel().equals(y))
							carMake.insert(carMake.size(), c);
					}
					if(!carMake.isEmpty())
						System.out.printf("%s\n",carMake.minT());
					else
						System.out.println("make and model combo not found");
					
					break;
				}
				case 7:{
					IndexMinPQ<Car> carMake = new IndexMinPQ<Car>(100, new MileageComparator());
					System.out.println("Finding lowest Mileage car for a make and model ");
					System.out.println("Enter make : ");
					String x = in.next();
					System.out.println("Enter model : ");
					String y = in.next();
					for( int items =1; items<carPrice.size();items++){
						Car c = carPrice.keyOf(items);
						if( c.getMake().equals(x) && c.getModel().equals(y))
							carMake.insert(carMake.size(), c);
					}

					if(!carMake.isEmpty())
						System.out.printf("%s\n",carMake.minT());
					else
						System.out.println("make and model combo not found");
					
					break; 
				}
				case 8:
					System.out.println("Bye!");
					return;
				//break;
				case 9: 
					//exit
					listCars();

					System.out.println("Bye!");
				return;
				
			}
		}
		
	}

	public static void listCars(){
		for( int items =1; items<carPrice.size();items++){ //optional for printing out list afterwards
				Car c = carPrice.keyOf(items);
				System.out.printf("(%d) %s\n",items, c.toString() );
		}
	}

	// do you have food?

	public static void add(Car c){
		Car car  = new Car(c);
		//makeModelMap.put(c.getMake() +" "+ c.getModel());
		//makeModel.add(c.getMake() +" "+c.getModel());
		carPrice.insert(carPrice.size()+1, car);
		carMileage.insert(carMileage.size()+1, car);

	}
	
	public static void add(){
		Scanner in = new Scanner(System.in);
		Car car  = new Car();
		//VIN 
		System.out.printf("please enter %s:\n", "VIN");
		car.setVIN(in.nextLine());
		//make  
		System.out.printf("please enter %s:\n", "make");
		car.setMake(in.nextLine());
		
		//model 
		System.out.printf("please enter %s:\n", "model");
		car.setModel(in.nextLine());

		//price  
		System.out.printf("please enter %s:\n", "price");
		car.setPrice(in.nextInt());

		//mileage  
		System.out.printf("please enter %s:\n", "mileage");
		car.setMileage(in.nextInt());

		//color  
		System.out.printf("please enter %s:\n", "color");
		car.setColor(in.nextLine());

		add(car);
	}

	public static void delete(int i){
		carPrice.delete( i );
		carMileage.delete( i );
	}

	public static void update(int i, Car ca){
				Car c  = new Car(ca);
				carPrice.changeT(i,c);
				carMileage.changeT(i,c);
	}
	
	public static void update(){
		Scanner in = new Scanner(System.in);
		System.out.println("which car would you like to update?");
		for( int items =1; items<carPrice.size();items++){ //optional for printing out list afterwards
			Car c = carPrice.keyOf(items);
			System.out.printf("(%d) %s\n",items, c.toString() );
		}
		int i = in.nextInt();
		System.out.println("what would you like to update?");
		System.out.println("(1) price");
		System.out.println("(2) mileage");
		System.out.println("(3) color");
		int option = in.nextInt();
		switch(option){
			case 1: 
			{
				System.out.println("what would you like to update the price too?");
				double x= in.nextDouble();
				Car c  = carPrice.keyOf(i);
				c.setPrice(x);
				update(option, c);
				break;
			}
			case 2:
			{
				System.out.println("what would you like to update the mileage too?");
				int x= in.nextInt();
				Car c  = carPrice.keyOf(i);
				c.setMileage(x);
				update(option, c);
				//CarList.updateMileage(i,x);
				
			}
			case 3:
			{
				System.out.println("what would you like to update the color too?");
				String x= in.nextLine();
				Car c  = carPrice.keyOf(i);
				c.setColor(x);
				update(option, c);

			}
			
		}
		
		
		

	}

}