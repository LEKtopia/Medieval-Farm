package farm.property;

public class Crop {

	private String type;				// Variables
	private int seedPerAcre;
	private int yieldPerAcre;
	private boolean isWinterCrop = false;
	private double variance;
									
	public Crop() {}					// Constructor (default)			 	
	
	public Crop(String cropType) {		// Constructor (overloaded)
		if(cropType.equalsIgnoreCase("wheat")) {			
			this.type = "wheat";
			this.seedPerAcre = 2;
			this.yieldPerAcre = 10;
			this.variance = .5;
			this.isWinterCrop = true;			
		} else if(cropType.equalsIgnoreCase("barley")) {
			this.type = "barley";
			this.seedPerAcre = 4;
			this.yieldPerAcre = 20;
			this.variance = .3;
			this.isWinterCrop = true;			
		} else if(cropType.equalsIgnoreCase("oats")) {
			this.type = "oats";
			this.seedPerAcre = 4;
			this.yieldPerAcre = 18;
			this.variance = .2;			
		} else if(cropType.equalsIgnoreCase("lentils")) {			
			this.type = "lentils";
			this.seedPerAcre = 3;
			this.yieldPerAcre = 22;
			this.variance = .6;			
		} 
	}									
	public String getType() {			// Getters & Setters
		return type;
	}	
	public void setType(String type) {
		this.type = type;	
	}	
	public int getSeedPerAcre() {
		return seedPerAcre;
	}
	public void setSeedPerAcre(int seedPerAcre) {
		this.seedPerAcre = seedPerAcre;
	}
	public int getYieldPerAcre() {
		return yieldPerAcre;
	}
	public void setYieldPerAcre(int yieldPerAcre) {
		this.yieldPerAcre = yieldPerAcre;
	}
	public boolean isWinterCrop() {
		return isWinterCrop;
	}
	public void setWinterCrop(boolean isWinterCrop) {
		this.isWinterCrop = isWinterCrop;
	}
	public double getVariance() {
		return variance;
	}
	public void setVariance(double variance) {
		this.variance = variance;
	}
}
