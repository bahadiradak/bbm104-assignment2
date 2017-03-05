/**
 * Main
 * @author Bahadir
 */
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Main {
	/**
	 * @param args the read text which are Personnel.txt and Monitoring.txt
	 * @throws FileNotFoundException if file not found
	 * @throws UnsupportedEncodingException if the character encoding is not supported
	 */
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException
	{
		Manager manageroutput = new Manager();
		manageroutput.manager(args);
		
		Officer officeroutput = new Officer();
		officeroutput.officer(args);
	
		Security securityoutput = new Security();
		securityoutput.security(args);
		
		Parttime parttimeoutput = new Parttime();
		parttimeoutput.parttime(args);

		Worker workeroutput = new Worker();
		workeroutput.worker(args);
		
		Chief chiefoutput = new Chief();
		chiefoutput.chief(args);
	}
}
