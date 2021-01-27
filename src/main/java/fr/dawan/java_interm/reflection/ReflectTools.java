package fr.dawan.java_interm.reflection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectTools {
	 public static <T> void toCsv(List<T> lstC, String filePath, String separator, String... fieldsToWrite)
             throws Exception {
     try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
             for (T obj : lstC) {
                     Class<?> clazz = obj.getClass();
                     Field[] fieldsArr = clazz.getDeclaredFields();// rÃ©cupÃ©rer l'ensemble des attributs de la classe
                     int i = 0;
                     StringBuilder line = new StringBuilder();
                     for (Field f : fieldsArr) {
                             f.setAccessible(true);// pour pouvoir accÃ©der aux champs mÃªme s'ils sont private ou protected
                             if (!Modifier.isStatic(f.getModifiers())) {
                                     
                                     if (fieldsToWrite == null || fieldsToWrite.length == 0) {
                                             line.append(f.get(obj).toString());
                                             if(i<fieldsArr.length-1)
                                                     line.append(";");
                                             i++;
                                     } else {
                                             if (Arrays.asList(fieldsToWrite).contains(f.getName())) {
                                                     line.append(f.get(obj).toString());
                                                     if(i<fieldsArr.length-1)
                                                             line.append(";");
                                                     i++;
                                             }
                                     }
                             }
                     }
                     writer.write(line.substring(0,  line.length()-1));
                     writer.newLine();
             }
     }
}

	public static <T> List<T> fromCsv(Class<T> clazz, String filePath, String separator, String... fieldsToWrite) throws Exception {
		List<T> result = new ArrayList<T>();
		Field[] fieldsArr = clazz.getDeclaredFields();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				line = line.trim();
				if (!line.isEmpty()) {
					String[] arr = line.split(separator);
					
					int countF = fieldsArr.length;
					if(fieldsToWrite!=null && fieldsToWrite.length>0)
						countF = fieldsToWrite.length;
					
					if (arr.length == countF) {  
						T obj = clazz.newInstance();
						int j = 0;
						for (int i = 0; i < fieldsArr.length; i++) {
							if (!Modifier.isStatic(fieldsArr[i].getModifiers())) {
								fieldsArr[i].setAccessible(true);
								
								if(fieldsToWrite!=null && fieldsToWrite.length>0) { 
									if(Arrays.asList(fieldsToWrite).contains(fieldsArr[i].getName())){
										setFieldValue(fieldsArr, i,j, obj, arr);
										j++;
									}
								}else {
									setFieldValue(fieldsArr,i, j,obj, arr);
									j++;
								}
							}

						}
						result.add(obj);
					}
				}
			}
		}
		return result;
	}

	private static <T> void setFieldValue(Field[] fieldsArr, int i, int j, T obj, String[] arr) throws Exception{
		switch (fieldsArr[i].getType().getName()) {
		case "long":
			fieldsArr[i].set(obj, Long.parseLong(arr[j]));
			break;
		case "int":
			fieldsArr[i].set(obj, Integer.parseInt(arr[j]));
			break;
		case "double":
			fieldsArr[i].set(obj, Double.parseDouble(arr[j]));
			break;
		case "boolean":
			fieldsArr[i].set(obj, Boolean.parseBoolean(arr[j]));
			break;
		case "float":
			fieldsArr[i].set(obj, Float.parseFloat(arr[j]));
			break;
		case "Byte":
			fieldsArr[i].set(obj, Byte.parseByte(arr[j]));
			break;
		default:
			fieldsArr[i].set(obj, fieldsArr[i].getType().cast(arr[j]));
			break;
		}
	}

}