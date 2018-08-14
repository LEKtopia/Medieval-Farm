package farm.property;

import farm.people.Family;

public class Land {						// Variables
	private int acres = 0;
	private double quality = 0.65;
	private Crop crop;
	private boolean isPlanted = false;
	private int seasonsGrowth = 0;
	
	public boolean plant(Crop crop, Family fam) {		
		boolean result = false;		
		if(crop.getType().equalsIgnoreCase("wheat")) {			
			if(fam.getWheat() >= 20) {
				this.isPlanted = true;
				this.seasonsGrowth = 1;
				this.crop = crop;
				fam.setWheat(fam.getWheat() - 20);				
				result = true;
			}			
		} else if(crop.getType().equalsIgnoreCase("barley")) {			
			if(fam.getBarley() >= 40) {
				this.isPlanted = true;
				this.seasonsGrowth = 1;
				this.crop = crop;
				fam.setWheat(fam.getBarley() - 40);				
				result = true;
			}			
		} else if(crop.getType().equalsIgnoreCase("oats")) {			
			if(fam.getOats() >= 40) {
				this.isPlanted = true;
				this.seasonsGrowth = 1;
				this.crop = crop;
				fam.setWheat(fam.getOats() - 40);				
				result = true;
			}			
		}else if(crop.getType().equalsIgnoreCase("lentils")) {			
			if(fam.getLentils() >= 30) {
				this.isPlanted = true;
				this.seasonsGrowth = 1;
				this.crop = crop;
				fam.setWheat(fam.getLentils() - 30);				
				result = true;
			}			
		}
		return result;
	}		
	
	public int getAcres() {
		return acres;
	}	
	public void setAcres(int acres) {
		this.acres = acres;
	}

	public double getQuality() {
		return quality;
	}
	public void setQuality(double quality) {
		this.quality = quality;
	}

	public Crop getCrop() {
		return crop;
	}
	public void setCrop(Crop crop) {
		this.crop = crop;
	}
	
	public boolean isPlanted() {
		return isPlanted;
	}
	public void setPlanted(boolean isPlanted) {
		this.isPlanted = isPlanted;
	}
	public void prepForPlanting() {
		this.quality += .05;
	}
	
	public int getSeasonsGrowth() {
		return seasonsGrowth;
	}
	public void setSeasonsGrowth(int seasonsGrowth) {
		this.seasonsGrowth = seasonsGrowth;
	}
	
	
	public boolean isReadyToHarvest() {
		return this.seasonsGrowth >= 2;
	}	
	public int harvest() {
		int amtHarvested = 0;
				// TODO write harvest logic
		return amtHarvested;
	}	
	
	public Land copy() {
		Land tempLand = new Land();		
		tempLand.acres = this.acres;
		tempLand.crop = this.crop;
		tempLand.quality = this.quality;		
		return tempLand;
	}
}
