/**
 * Chief
 *@author Bahadir
 */
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Chief extends Fulltime
/** {@inheritDoc}
 */
{
	/**
	 * @param args the read text which are Personnel.txt and Monitoring.txt
	 * @throws FileNotFoundException if file not found
	 * @throws UnsupportedEncodingException if the character encoding is not supported
	 */
	public void chief(String[] args) throws FileNotFoundException, UnsupportedEncodingException
	{
		Read read =new Read();
		read.readSplitPrint(args[1]);
		read.readPrint(args[0]);
		
		Officer o = new Officer();
		Manager m = new Manager();
		
		for (int i=0,j=0;i<read.PersonnelInfo.size() && j<read.MonitoringInfo.size(); i++,j++ )
		{
			if(read.PersonnelInfo.get(i).get(2).equals("CHIEF"))
			{
				Object c2 = m.setw1(read.MonitoringInfo.get(j).get(1));
				Object c3 = m.setw2(read.MonitoringInfo.get(j).get(2));
				Object c4 = m.setw3(read.MonitoringInfo.get(j).get(3));
				Object c5 = m.setw4(read.MonitoringInfo.get(j).get(4));
				Object c6 = m.setStartDuty(read.PersonnelInfo.get(i).get(3));
				Object c7 = m.setemployeeSalary(m.overWorkSalary(c2, c3, c4, c5)+ m.severancePay(c6) + 1680);
				o.setTotalSalary(c7);
				o.setName(read.buildName(read.PersonnelInfo.get(i).get(0)));
				o.setSurname(read.buildSurname(read.PersonnelInfo.get(i).get(0)));
				o.setPersonelregistration(read.PersonnelInfo.get(i).get(1));
				o.setPosition(read.PersonnelInfo.get(i).get(2));
				o.setStart(c6);
				o.finalSums(read.PersonnelInfo.get(i).get(1));
			}
		}
	}

}
