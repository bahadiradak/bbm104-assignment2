/**
 * Parttime
 * @author Bahadir
 */
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Parttime extends Employee 
/** {@inheritDoc}
 */
{
	@Override
	public Float hourOfWork (Object b,Object c, Object d, Object e)
	{
		this.w1 = (String) b;
		this.w2 = (String) c;
		this.w3 = (String) d;
		this.w4 = (String) e;
		
		float a1 = Float.parseFloat((String) b);
		float a2 = Float.parseFloat((String) c);
		float a3 = Float.parseFloat((String) d);
		float a4 = Float.parseFloat((String) e);
		
		List<Float> total=new ArrayList<Float>();
		
		float week1 = a1;
		if (10 <= week1 && week1 <=20)
		{
			total.add((Float) week1*12);
		}
		else if(week1>20)
		{
			total.add((float) ((float) 20*12));
		}
		
		
		float week2 = a2;
		if (10 <= week2 && week2 <=20)
		{
			total.add((Float) week2*12);
		}
		else if(week2>20)
		{
			total.add((float) ((float) 20*12));
		}
		
		
		float week3 = a3;
		if (10 <= week3 && week3 <=20)
		{
			total.add((Float) week3*12);
		}
		else if(week3>20)
		{
			total.add((float) ((float) 20*12));
		}
		
		
		float week4 = a4;
		if (10 <= week4 && week4 <=20)
		{
			total.add((Float) week4*12);
		}
		else if(week4>20)
		{
			total.add((float) ((float) 20*12));
		}
		
		
		Float sum = (float) 0;
		for (Float x : total)
		{
			sum+=x;
		}

		Float totalSalary = (float) (sum);
		
		return totalSalary;
	}
	/**
	 * @param args the read text which are Personnel.txt and Monitoring.txt
	 * @throws FileNotFoundException if file not found
	 * @throws UnsupportedEncodingException if the character encoding is not supported
	 */
	public void parttime(String[] args) throws FileNotFoundException, UnsupportedEncodingException
	{
		Read read =new Read();
		read.readSplitPrint(args[1]);
		read.readPrint(args[0]);
		
		Parttime p = new Parttime();
		for (int i=0,j=0;i<read.PersonnelInfo.size() && j<read.MonitoringInfo.size(); i++,j++ )
		{
			if(read.PersonnelInfo.get(i).get(2).equals("PARTTIME_EMPLOYEE"))
			{
				Object p2 = p.setw1(read.MonitoringInfo.get(j).get(1));
				Object p3 = p.setw2(read.MonitoringInfo.get(j).get(2));
				Object p4 = p.setw3(read.MonitoringInfo.get(j).get(3));
				Object p5 = p.setw4(read.MonitoringInfo.get(j).get(4));
				Object p6 = p.setStart(read.MonitoringInfo.get(j).get(0));
				Object p7 = p.hourOfWork(p2, p3, p4, p5);
				p.setTotalSalary(p7);
				p.setName(read.buildName(read.PersonnelInfo.get(i).get(0)));
				p.setSurname(read.buildSurname(read.PersonnelInfo.get(i).get(0)));
				p.setPersonelregistration(read.PersonnelInfo.get(i).get(1));
				p.setPosition(read.PersonnelInfo.get(i).get(2));
				p.setStart(p6);
				p.finalSums(read.PersonnelInfo.get(i).get(1));
			}
		}
	}
}
