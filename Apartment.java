class Apartment{

	private String streetAdress;
	private String aptNum;//should it be string or int?
	private int apartmentZIP;
	private String city;
	double rent;
	private int squareFeet;
	
	
	public Apartment(){
		streetAdress = "4200 Forbes Ave";
		aptNum = "3601";//should it be string or int?
		city = "Pittsburgh";
		apartmentZIP = 15213;
		rent = 1000;
		squareFeet = 500;
	}
	
	public Apartment( Apartment apt ){
		this.streetAdress = apt.streetAdress;
		this.aptNum = apt.aptNum;//should it be string or int?
		this.city = apt.city;
		this.apartmentZIP = apt.apartmentZIP;
		this.rent = apt.rent;
		this.squareFeet = apt.squareFeet;
	}
	
	public String getStreetAddress(){return streetAdress;}
	public void setStreetAddress( String x ){streetAdress = x;}
	
	public String getAptNum(){return aptNum;}
	public void setAptNum( String x ){aptNum = x;}

	public int getZIP(){return apartmentZIP;}
	public void setZIP( int x ){apartmentZIP = x;}	
	
	public String getCity(){return city;}
	public void setCity( String x ){city = x;}
	
	public double getRent(){return rent;}
	public void setRent( double x ){rent = x;}	
	
	public int getSqFeet(){return squareFeet;}
	public void setSqFeet( int x ){squareFeet = x;}	
	
	
	@Override public String toString(){
		
		return "apartment number "+aptNum+ " at "+streetAdress +" "+city+", "+apartmentZIP+ " is "+ squareFeet+ " and costs $"+rent+" per month"; 
	}
	public static void main(String args[]){
	
	Apartment apt =  new Apartment();
	System.out.println(apt);
	System.out.println(apt.getStreetAddress());
	System.out.println(apt.getAptNum());
	System.out.println(apt.getZIP());
	System.out.println(apt.getCity());
	System.out.println(apt.getRent());
	System.out.println(apt.getSqFeet());
	
	}
}

