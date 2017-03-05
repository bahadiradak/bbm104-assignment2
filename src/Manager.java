/**
 * Manager
 * @author Bahadir
 */

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Manager extends Personnel
/** {@inheritDoc}
 */
{
	Float employeeSalary;
	/**
	 * @return the employeeSalary
	 */
	public Float getemployeeSalary() {
		return employeeSalary;
	}
	/**
	 * @param employeeSalary the manager's salary
	 * @return the employeeSalary
	 */
	public Object setemployeeSalary(Float employeeSalary) 
	{
		return this.employeeSalary = employeeSalary;
	}
	/**
	 * @param args the read text which are Personnel.txt and Monitoring.txt
	 * @throws FileNotFoundException if file not found
	 * @throws UnsupportedEncodingException if the character encoding is not supported
	 */
	public void manager(String[] args) throws FileNotFoundException, UnsupportedEncodingException
	{
		Read read =new Read();
		
		read.readSplitPrint(args[1]);
		read.readPrint(args[0]);
		
		Manager m = new Manager();
		for (int i=0,j=0;i<read.PersonnelInfo.size() && j<read.MonitoringInfo.size(); i++,j++ )
		{
			if(read.PersonnelInfo.get(i).get(2).equals("MANAGER"))
			{
				Object m1 = m.setBaseSalary("1800");
				Object m2 = m.setw1(read.MonitoringInfo.get(j).get(1));
				Object m3 = m.setw2(read.MonitoringInfo.get(j).get(2));
				Object m4 = m.setw3(read.MonitoringInfo.get(j).get(3));
				Object m5 = m.setw4(read.MonitoringInfo.get(j).get(4));
				Object m6 = m.setStartDuty(read.PersonnelInfo.get(i).get(3));  
				Object m7 = m.setemployeeSalary(m.overWorkSalary(m2, m3, m4, m5)+ m.severancePay(m6) + m.ssBenefit(m1) + 1800);
				m.setTotalSalary(m7);
				m.setName(read.buildName(read.PersonnelInfo.get(i).get(0)));
				m.setSurname(read.buildSurname(read.PersonnelInfo.get(i).get(0)));
				m.setPersonelregistration(read.PersonnelInfo.get(i).get(1));
				m.setPosition(read.PersonnelInfo.get(i).get(2));
				m.setStartDuty(read.MonitoringInfo.get(j).get(0));
				m.setStart(m6);
				m.finalSums(read.PersonnelInfo.get(i).get(1));
			}
		}
	}
}

