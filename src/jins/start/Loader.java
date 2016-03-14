package jins.start;  

import jins.start.Person;  
import java.io.*;  
import java.util.ArrayList;  
import java.util.HashMap;  
/**
 * ╪стьнд╪Ч
 * @author jinhang
 *
 */
public class Loader  
{  
	public Loader()  
	{  
	}  
	public static ArrayList loadPlayerList(String path)  
	{  
		ArrayList list;  
		BufferedReader reader;  
		list = new ArrayList();  
		reader = null;  
		try {  
			reader = new BufferedReader(new FileReader(path));  
		} catch (FileNotFoundException e) {  
			// TODO Auto-generated catch block  
			e.printStackTrace();  
		}  
		try {  
			for (String line = ""; (line = reader.readLine()) != null;)  
			{  
				String array[] = line.split(",");  
				list.add(new Person(-1, Integer.parseInt(array[0]), Integer.parseInt(array[1]), Integer.parseInt(array[2]), Integer.parseInt(array[3]), Integer.parseInt(array[4]), Integer.parseInt(array[5]), Integer.parseInt(array[6])));  
			}  
		} catch (NumberFormatException e) {  
			// TODO Auto-generated catch block  
			e.printStackTrace();  
		} catch (IOException e) {  
			// TODO Auto-generated catch block  
			e.printStackTrace();  
		}  
		if (reader != null)  
		{  
			try  
			{  
				reader.close();  
			}  
			catch (IOException e1)  
			{  
				e1.printStackTrace();  
			}  
			reader = null;  
		}  

		//e;  




		return list;  
	}  
	public static HashMap loadSampleMap(String path, int gender)  
	{  
		HashMap map;  
		BufferedReader reader;  
		map = new HashMap();  
		reader = null;  
		try {  
			reader = new BufferedReader(new FileReader(path));  
		} catch (FileNotFoundException e) {  
			// TODO Auto-generated catch block  
			e.printStackTrace();  
		}  
		try {  
			for (String line = ""; (line = reader.readLine()) != null;)  
			{  
				String array[] = line.split(",");  
				int id = Integer.parseInt(array[0]);  
				map.put(Integer.valueOf(id), new Person(id, gender, Integer.parseInt(array[1]), Integer.parseInt(array[2]), Integer.parseInt(array[3]), Integer.parseInt(array[4]), Integer.parseInt(array[5]), Integer.parseInt(array[6])));  
			}  
		} catch (NumberFormatException e) {  
			e.printStackTrace();  
		} catch (IOException e) {  
			e.printStackTrace();  
		}  
		try {  
			reader.close();  
		} catch (IOException e) {  
			e.printStackTrace();  
		}  
		return map;  
	}  
}  