package monitor;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.sun.javafx.scene.control.Logging;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.software.os.OperatingSystem.ProcessSort;
import oshi.util.platform.windows.WmiUtil;

public class monitor {

//	static Logger logger = Logger.getLogger(monitor.class);
//
//	 static List<String> processesNames = new ArrayList<String>();
	 	
	
	
//	public static void main(String[] args) throws IOException {
//
//		// TODO Auto-generated method stub
//		
//		//out = new PrintWriter(new FileWriter(System.getProperty("user.home") + "\\Desktop\\output55.txt", true), true);
//		
//		BasicConfigurator.configure();
//
//	     logger.info("Entering application.");
//	     
//	
////	     
////		 OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
////		  for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
////		    method.setAccessible(true);
////		    if (method.getName().startsWith("get")
////		        && Modifier.isPublic(method.getModifiers())) {
////		            Object value;
////		        try {
////		            value = method.invoke(operatingSystemMXBean);
////		        } catch (Exception e) {
////		            value = e;
////		        } // try
////		        System.out.println(method.getName() + " = " + value);
////		        out.write(method.getName() + " = " + value+System.lineSeparator());
////		       
////		    } 
////		  } 
//		
//	
//		
//		processesNames.add("Afcon.Pcim.Server.Service.AlarmPublisher.exe");
//		processesNames.add("Afcon.Pcim.Server.Manager.exe");
//		monitorProcess mP= new monitorProcess(processesNames);
//		Timer timer = new Timer();
//		
//		timer.scheduleAtFixedRate(new TimerTask() {
//			  @Override
//			  public void run() {
//				  
//					mP.printTotalPreformance();
//					mP.printProcesses();
//					mP.closeFile();
//			  }
//			}, 15*1000,15*1000);
//		
//		
//		
//		
////		SystemInfo si = new SystemInfo();
////		
////		OperatingSystem os = si.getOperatingSystem();
////		Iterator<String> it = processesNames.iterator();
////		while (it.hasNext()){
////			String prcName= it.next();
////			for (OSProcess process: os.getProcesses(200, ProcessSort.NAME)){
////				if (process.getName().contentEquals(prcName))
////				{
////					//prcessId.add(process.getProcessID());
////					long privateWorkingSet = Long.parseLong(WmiUtil.selectStringFrom(null,"Win32_PerfRawData_PerfProc_Process", "WorkingSetPrivate", "WHERE IDProcess = "+ process.getProcessID() ))/1024;
////					long workingSet = process.getResidentSetSize()/1024;
////					System.out.println(process.getName());
////					String s =process.getName()+" : "+ process.getProcessID()+", Total Memeory " +workingSet+",  Private Memeory"+privateWorkingSet;
////					System.out.println(s);
////					out.write(s+System.lineSeparator());
////				}
////			}
////		}
//		
//
//		
//		  //out.close();
//
//	}
//	

	  
	

}
