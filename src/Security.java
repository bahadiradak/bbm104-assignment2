/**
 * Security
 * @author Bahadir
 */
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Security extends Personnel 
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
		if (30 <= week1 && week1 <=54)
		{
			total.add((float) ((Float) week1*6.5));
		}
		else if(week1>54)
		{
			total.add((float) ((float) 54*6.5));
		}
		
		
		float week2 = a2;
		if (30 <= week2 && week2 <=54)
		{
			total.add((float) ((Float) week2*6.5));
		}
		else if(week2>54)
		{
			total.add((float) ((float) 54*6.5));
		}
		
		
		float week3 = a3;
		if (30 <= week3 && week3 <=54)
		{
			total.add((float) ((Float) week3*6.5));
		}
		else if(week3>54)
		{
			total.add((float) ((float) 54*6.5));
		}
		
		
		float week4 = a4;
		if (30 <= week4 && week4 <=54)
		{
			total.add((float) ((Float) week4*6.5));
		}
		else if(week4>54)
		{
			total.add((float) ((float) 54*6.5));
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
	public void security(String[] args) throws FileNotFoundException, UnsupportedEncodingException
	{
		Read read =new Read();
		read.readSplitPrint(args[1]);
		read.readPrint(args[0]);
		
		Parttime p = new Parttime();
		Security s = new Security();
		Manager m = new Manager();
		
		for (int i=0,j=0;i<read.PersonnelInfo.size() && j<read.MonitoringInfo.size(); i++,j++ )
		{
			if(read.PersonnelInfo.get(i).get(2).equals("SECURITY"))
			{
				Object s2 = s.setw1(read.MonitoringInfo.get(j).get(1));
				Object s3 = s.setw2(read.MonitoringInfo.get(j).get(2));
				Object s4 = s.setw3(read.MonitoringInfo.get(j).get(3));
				Object s5 = s.setw4(read.MonitoringInfo.get(j).get(4));
				Object s6 = m.setStartDuty(read.PersonnelInfo.get(i).get(3));
				Object s7 = m.setemployeeSalary(s.hourOfWork(s2, s3, s4, s5)+ m.severancePay(s6) + 24*5 + 24*4);
				p.setTotalSalary(s7);
				p.setName(read.buildName(read.PersonnelInfo.get(i).get(0)));
				p.setSurname(read.buildSurname(read.PersonnelInfo.get(i).get(0)));
				p.setPersonelregistration(read.PersonnelInfo.get(i).get(1));
				p.setPosition(read.PersonnelInfo.get(i).get(2));
				p.setStart(s6);
				p.finalSums(read.PersonnelInfo.get(i).get(1));
			}
		}
	}
}
