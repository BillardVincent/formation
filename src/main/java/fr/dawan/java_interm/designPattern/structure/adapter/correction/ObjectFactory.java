package fr.dawan.java_interm.designPattern.structure.adapter.correction;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

	public Supplier createSupplier() {
		return new Supplier();
	}
}
