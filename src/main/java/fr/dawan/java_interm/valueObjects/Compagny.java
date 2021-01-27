package fr.dawan.java_interm.valueObjects;

public class Compagny {
	
private long id;
private String name;
private Geolocalisation location;




public Compagny(long id, String name, Geolocalisation location) {
	super();
	this.id = id;
	this.name = name;
	this.location = location;
}


public int compareByName(Compagny c) {
	
	return this.name.compareTo(c.name);
}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Compagny [id=").append(id).append(", name=").append(name).append(", location=").append(location)
			.append("]");
	return builder.toString();
}




@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (id ^ (id >>> 32));
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
	Compagny other = (Compagny) obj;
	if (id != other.id)
		return false;
	return true;
}



}
