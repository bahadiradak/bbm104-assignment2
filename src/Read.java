/**
 * Read
 * @author Bahadir
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Read 

{
	/**
	 * @param args the read text which are Personnel.txt and Monitoring.txt
	 */
	public void main(String[] args) {
		if(args.length==2){
			readPrint(args[0]);
			readSplitPrint(args[1]);
		} 
		else
			System.out.println("It needs two arguments for running");
	}
	
	String name,surname;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the personnel's name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the personnel's surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	ArrayList<ArrayList<String>> PersonnelInfo= new ArrayList<ArrayList<String>>();
	ArrayList<ArrayList<String>> MonitoringInfo= new ArrayList<ArrayList<String>>();
	
	/**
	 * @param path read second argument that is Monitoring.txt
	 */
	public void readSplitPrint(String path)
	{ 
		try 
		{
			for (String line : Files.readAllLines(Paths.get(path))) 
			{
				String[] split = line.split(" ");
				for (int i = 0; i < split.length; i++)
				{
					ArrayList<String> onebyone1 = new ArrayList<String>(Arrays.asList(line.split("\t")));
					MonitoringInfo.add(onebyone1);			
				}
			}
			
		} catch (IOException e) { 
			e.printStackTrace();
		}		
	}
	
	/**
	 * @param path read first argument that is Personnel.txt
	 */
	public  void readPrint(String path) 
	{
		try {
			for (String line : Files.readAllLines(Paths.get(path))) 
			{
				ArrayList<String> onebyone2 = new ArrayList<String>(Arrays.asList(line.split("\t")));
				PersonnelInfo.add(onebyone2);	
				
			} 
			
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
	
	/**
	 * @param h if personnel has 2 name all of them including name
	 * @return the name
	 */
	public String buildName(Object h)
	{
		this.name = (String) h;
		String[] splitName = ((String) h).split(" ");
		List<String> onlyName = new ArrayList<String>();
		for (int k=0; k<splitName.length -1 ; k++)
		{
			onlyName.add(splitName[k]);
		}
		String result = String.join(" ", onlyName);
		return (String) result;
	}
	
	/**
	 * @param i personnel's surname take last index of splited name
	 * @return the surname
	 */
	public String buildSurname(Object i)
	{
		this.surname = (String) i;
		String[] splitName = ((String) i).split(" ");
		String result = (splitName[splitName.length-1]);
		return (String) result;
	}
	
}
