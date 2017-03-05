/**
 * Officer
 * @author Bahadir
 */
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Officer extends Personnel
/** {@inheritDoc}
 */
{
	@Override
	public Float overWorkSalary (Object b,Object c, Object d, Object e)
	{
		this.w1 = (String) b;
		this.w2 = (String) c;
		this.w3 = (String) d;
		this.w4 = (String) e;
				
		float a1 = Float.parseFloat((String) b);
		float a2 = Float.parseFloat((String) c);
		float a3 = Float.parseFloat((String) d);
		float a4 = Float.parseFloat((String) e);
		
		float sum = a1 + a2 + a3 + a4 ;
		float over = (sum-160);
		
		Float oWs = null;
		if(over >= 40)
		{
			oWs =(float) (40*4);
			
		}
		else if(over<40)
		{
			oWs = (float) (over * 4);
			
		}
		return oWs;
	}
	
	@Override
	public Float ssBenefit(Object a)
	{
		this.BaseSalary = (String) a;
		int a6 = Integer.parseInt((String) a);
		
		float ssB = (a6*49)/100;
		return (float) ssB;
	}
	/**
	 * @param args the read text which are Personnel.txt and Monitoring.txt
	 * @throws FileNotFoundException if file not found
	 * @throws UnsupportedEncodingException if the character encoding is not supported
	 */
	public void officer(String[] args) throws FileNotFoundException, UnsupportedEncodingException
	{
		Read read =new Read();
		read.readSplitPrint(args[1]);
		read.readPrint(args[0]);
		
		Officer o = new Officer();
		Manager m = new Manager();
		for (int i=0,j=0;i<read.PersonnelInfo.size() && j<read.MonitoringInfo.size(); i++,j++ )
		{
			if(read.PersonnelInfo.get(i).get(2).equals("OFFICER"))
			{
				Object o1 = o.setBaseSalary("1800");
				Object o2 = o.setw1(read.MonitoringInfo.get(j).get(1));
				Object o3 = o.setw2(read.MonitoringInfo.get(j).get(2));
				Object o4 = o.setw3(read.MonitoringInfo.get(j).get(3));
				Object o5 = o.setw4(read.MonitoringInfo.get(j).get(4));
				Object o6 = m.setStartDuty(read.PersonnelInfo.get(i).get(3));
				Object o7 = m.setemployeeSalary(o.overWorkSalary(o2, o3, o4, o5)+ m.severancePay(o6) + o.ssBenefit(o1) + 1800);
				o.setTotalSalary(o7);
				o.setName(read.buildName(read.PersonnelInfo.get(i).get(0)));
				o.setSurname(read.buildSurname(read.PersonnelInfo.get(i).get(0)));
				o.setPersonelregistration(read.PersonnelInfo.get(i).get(1));
				o.setPosition(read.PersonnelInfo.get(i).get(2));
				o.setStart(o6);
				o.finalSums(read.PersonnelInfo.get(i).get(1));
			}
		}
	}
}
