/**
 * Worker
 * @author Bahadir
 */
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Worker extends Fulltime 
/** {@inheritDoc}
 */
{
	/**
	 * @param args the read text which are Personnel.txt and Monitoring.txt
	 * @throws FileNotFoundException if file not found
	 * @throws UnsupportedEncodingException if the character encoding is not supported
	 */
	public void worker(String[] args) throws FileNotFoundException, UnsupportedEncodingException
	{
		Read read =new Read();
		read.readSplitPrint(args[1]);
		read.readPrint(args[0]);
		
		Officer o = new Officer();
		Manager m = new Manager();
		
		for (int i=0,j=0;i<read.PersonnelInfo.size() && j<read.MonitoringInfo.size(); i++,j++ )
		{
			if(read.PersonnelInfo.get(i).get(2).equals("WORKER"))
			{
				Object w2 = o.setw1(read.MonitoringInfo.get(j).get(1));
				Object w3 = o.setw2(read.MonitoringInfo.get(j).get(2));
				Object w4 = o.setw3(read.MonitoringInfo.get(j).get(3));
				Object w5 = o.setw4(read.MonitoringInfo.get(j).get(4));
				Object w6 = m.setStartDuty(read.PersonnelInfo.get(i).get(3));
				Object w7 = m.setemployeeSalary(o.overWorkSalary(w2, w3, w4, w5)+ m.severancePay(w6) + 1460);
				o.setTotalSalary(w7);
				o.setName(read.buildName(read.PersonnelInfo.get(i).get(0)));
				o.setSurname(read.buildSurname(read.PersonnelInfo.get(i).get(0)));
				o.setPersonelregistration(read.PersonnelInfo.get(i).get(1));
				o.setPosition(read.PersonnelInfo.get(i).get(2));
				o.setStart(w6);
				o.finalSums(read.PersonnelInfo.get(i).get(1));
			}
		}
	}
}
