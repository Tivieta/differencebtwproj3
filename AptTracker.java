import java.util.Scanner;

class CarTracker{
	
	static CarPQ CarList = new CarPQ();
	
	
	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		
		while(true){
			
			System.out.println("Options:\n(1) Add car");
			System.out.println("(2) Update car");
			System.out.println("(3) Remove car");
			System.out.println("(4) Find lowest priced car");
			System.out.println("(5) Find highest sqfootage car");
			System.out.println("(6) Find lowest priced car in a city");
			System.out.println("(7) Find highest sqfootage car in a city");
			System.out.println("(8) Exit");
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
					for( int items =0; items<CarList.size;items++){
						System.out.printf("(%d) %s\n",items,CarList.cars.get(items));
					}
					option = in.nextInt();
					CarList.delete( option );
				break;
				case 4: 
					//lowest priced car
					System.out.printf("%s\n",CarList.minPrice().toString());
					
				break;
				case 5: 
					//highest sqfootage car
					System.out.printf("%s\n",CarList.maxSQFeet().toString());
					
				break;
				case 6: {
					//lowest priced car in a city
					CarPQ carPQ = new CarPQ();
					System.out.println("Finding lowest priced city");
					System.out.println("Enter city: ");
					String x = in.nextLine();
					x = cityFormatting(x);
					for( int items =0; items<carPQ.size;items++){
						if( carPQ.cars.get(items).getCity().equals(x) )
							carPQ.add(CarList.cars.get(items));
					
					}
					System.out.printf("%s\n",carPQ.minPrice().getRent());
					
					break;
				}
				case 7:{
					CarPQ carPQ = new CarPQ();
					System.out.println("Findinghighest sqfootage car in a city");
					System.out.println("Enter city: ");
					String x = in.nextLine();
					x = cityFormatting(x);
					for( int items =0; items<carPQ.size;items++){
						if( carPQ.cars.get(items).getCity().equals(x) )
							carPQ.add(CarList.cars.get(items));
					
					}
					System.out.printf("%s\n",carPQ.maxSQFeet().toString());
					//highest sqfootage car in a city
					break; 
				}
				case 8: 
					//exit
					for( int items =0; items<CarList.size;items++){ //optional for printing out list afterwards
						System.out.printf("(%d) %s\n",items,CarList.cars.get(items));
					}
					System.out.println("Bye!");
				return;
				
			}
		}
		
	}
	
	public static void add(){
		Scanner in = new Scanner(System.in);
		Car apt  = new Car();
		System.out.println("enter Street Address:");
		apt.setStreetAddress(in.nextLine());
		System.out.println("enter Car Number:");
		apt.setCarNum(in.nextLine());
		System.out.println("enter ZIP code:");
		apt.setZIP(in.nextInt());
		
		System.out.println("enter City:");
		apt.setCity(in.next());
		
		System.out.println("enter Rent:");
		apt.setRent(in.nextDouble());
		System.out.println("enter Square Feet:");
		apt.setSqFeet(in.nextInt());
		
		CarList.add(apt);
	}
	
	public static void update(){
		Scanner in = new Scanner(System.in);
		System.out.println("which car would you like to update?");
		for( int items =0; items<CarList.size;items++){
			System.out.printf("(%d) %s",items,CarList.cars.get(items));
		}
		int i = in.nextInt();
		System.out.println("what would you like to update?");
		System.out.println("(1) price");
		System.out.println("(2) SQ feet");
		int option = in.nextInt();
		if(option == 1){ 
			System.out.println("what would you like to update the price too?");
			double x= in.nextDouble();
			CarList.updatePrice(i,x);
		}
		else if(option == 1){ 
			System.out.println("what would you like to update the footage too?");
			int x= in.nextInt();
			CarList.updateFootage(i,x);
		}
		

	}
	
	
	
	public static String cityFormatting(String x){// doesn't capitalize multiword cities
		x = x.trim();
		x.toLowerCase();
		return ""+ x; //+ x.substring(1);
		
		
	}

}