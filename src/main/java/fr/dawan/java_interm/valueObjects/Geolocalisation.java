package fr.dawan.java_interm.valueObjects;

public class Geolocalisation {
	double longitude;
	double lattitude;
	public Geolocalisation(double longitude, double lattitude) {
		super();
		this.longitude = longitude;
		this.lattitude = lattitude;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(lattitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Geolocalisation other = (Geolocalisation) obj;
		if (Double.doubleToLongBits(lattitude) != Double.doubleToLongBits(other.lattitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		return true;
	}
	

}
