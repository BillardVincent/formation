package fr.dawan.java_interm;

import java.util.ArrayList;
import java.util.List;

import beans.Contact;
import beans.Film;
import beans.Mediatheque;
import beans.ObjectFactory;
import fr.dawan.java_interm.genericity.ImportExportTools;
import fr.dawan.java_interm.reflection.ReflectTools;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Contact c = new Contact(1, "Bob", "Bob@bob.fr");
        String filePath = "co.bin";
        String filePathXml = "co.xml";
        String filePathXmlJaxb = "coJaxb.xml";


        
        try {
        	
        	
			ImportExportTools.toBin( c, filePath);
			
			System.out.println("bin serilized");
			
			Contact c2 = ImportExportTools.fromBin(filePath);
			System.out.println("deserilized");

			System.out.println(c2.toString());
			
			System.out.println("xml serilized");
			ImportExportTools.toXml(c, filePathXml);
			System.out.println("xml deserilized");

			Contact c3 = ImportExportTools.fromXml(filePathXml);
			System.out.println(c3.toString());
			
			
			System.out.println("xmlJaxb serilized");
			ImportExportTools.toXmlJaxb(c, filePathXmlJaxb, Contact.class, ObjectFactory.class);
			System.out.println("xmlJaxb deserilized");
			Contact c4 = ImportExportTools.fromXmlJaxb(filePathXmlJaxb, Contact.class, ObjectFactory.class);
			System.out.println(c4.toString());
			
			Mediatheque mediatheque = new Mediatheque();

			Film f1 = new Film();
			f1.setId(1);
			f1.setTitre("titre");
			f1.setDescription("desc");
			mediatheque.getFilm().add(f1);;

			
			Film f2 = new Film();
			f2.setId(2);
			f2.setTitre("titre2");
			f2.setDescription("desc2");
			mediatheque.getFilm().add(f2);;

			
			Film f3 = new Film();
			f3.setId(3);
			f3.setTitre("titre3");
			f3.setDescription("desc3");
			mediatheque.getFilm().add(f3);;
			
			System.out.println("xmlJaxb List serilized");
			ImportExportTools.toXmlJaxb(mediatheque, "mediatheque.xml", Mediatheque.class, Film.class, ObjectFactory.class);
			System.out.println("xmlJaxb List deserilized");
			Mediatheque mediatheque2 = ImportExportTools.fromXmlJaxb("mediatheque.xml", Mediatheque.class, Film.class, ObjectFactory.class);
			System.out.println(mediatheque2.toString());
			for (Film f : mediatheque2.getFilm()) {
				System.out.println(f.toString());
				
			}


			
			// NE FONCTIONNE PAS
			//ImportExportTools.toXmlJaxb(lstC,"coJaxbList.xml", Contact.class, ObjectFactory.class);

			
			//------------------------------------------------------- CSV -----------------------------------------------
			
			try {
				ReflectTools.toCsv( mediatheque.getFilm(), "media.csv", ";", "desc", "titre");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("bin serilized");
			
			//List<Film> lstF = ImportExportTools.fromCsv(filePath);
			System.out.println("deserilized");

			System.out.println(c2.toString());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        // ----------------------------------- code mohamed ---------------------------------
        try {
			List<Contact> lstC = new ArrayList<Contact>();
			lstC.add(new Contact(1, "toto", "toto@dawan.fr"));
			lstC.add(new Contact(2, "tata", "tata@dawan.fr"));
			
			System.out.println("complete export");
			ReflectTools.toCsv(lstC, "lst2.csv", ";");
			System.out.println("csv file generated");
			
			
			System.out.println("import / export (name, email)__________________________");
			String  fileN = "lst.csv";
			ReflectTools.toCsv(lstC, fileN, ";", "name", "email");
			System.out.println("csv file generated");
			
			List<Contact> importedLst1 =  ReflectTools.fromCsv(Contact.class, fileN, ";", "name","email");
			for (Contact cx : importedLst1) {
				System.out.println(cx);
			}
			
			System.out.println("import / export (id, name, email)__________________________");
			ReflectTools.toCsv(lstC, fileN, ";", "id","name", "email");
			System.out.println("csv file generated");
			
			importedLst1 =  ReflectTools.fromCsv(Contact.class, fileN, ";", "id","name","email");
			for (Contact cx : importedLst1) {
				System.out.println(cx);
			}
			
			System.out.println("import / export (email, name)__________________________");
			ReflectTools.toCsv(lstC, fileN, ";", "email","name");
			System.out.println("csv file generated");
			
			importedLst1 =  ReflectTools.fromCsv(Contact.class, fileN, ";", "email","name");
			for (Contact cx : importedLst1) {
				System.out.println(cx);
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
}
