package fr.dawan.java_interm.designPattern.structure.adapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "mediatheque")

public class Supplier {
    
	@XmlElement(required = true)

	private long id;
    @XmlElement(required = true)

	private String name;
	public Supplier(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Supplier() {
		super();
	}
	
	

}
