package monitor;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.sun.javafx.scene.control.Logging;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.software.os.OperatingSystem.ProcessSort;
import oshi.util.platform.windows.WmiUtil;

public class monitorProcess {
	
	static Logger logger = Logger.getLogger(monitor.class);
	 static PrintWriter out ;
	 static List<String> processesNames;
	 static SystemInfo si ;
	 static OperatingSystem os ;
	 private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	
	 
	public monitorProcess(List<String> processesNames)  {
		
		// TODO Auto-generated constructor stub
		try {
			out = new PrintWriter(new FileWriter(System.getProperty("user.home") + "\\Desktop\\ProcessesMemory.txt", true), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		monitorProcess.processesNames = processesNames;
		si = new SystemInfo();
		 os = si.getOperatingSystem();
		 System.out.println("Time ,PID, Total Memory, Private Memory, Process Name");
		 out.write("Time ,PID, Total Memory, Private Memory, Process Name"+System.lineSeparator());
		 out.flush();
		 
	}
	
	public void printProcesses(){
		Iterator<String> it = processesNames.iterator();
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		OSProcess[] processesList = os.getProcesses(50, ProcessSort.NAME);
		while (it.hasNext()){
			String prcName= it.next();
			for (OSProcess process:processesList ){
				if (process.getName().contentEquals(prcName))
				{
					
					long privateWorkingSet = Long.parseLong(WmiUtil.selectStringFrom(null,"Win32_PerfRawData_PerfProc_Process", "WorkingSetPrivate", "WHERE IDProcess = "+ process.getProcessID() ))/1024;
					//long threadCount = Long.parseLong(WmiUtil.selectStringFrom(null,"Win32_PerfRawData_PerfProc_Process", "ThreadCount", "WHERE IDProcess = "+ process.getProcessID() ));
					long workingSet = process.getResidentSetSize()/1024;
					System.out.println(process.getName());
					//String sa =process.getName()+" "+ process.getProcessID()+"  ,"+sdf.format(timeStamp)+"  ,Total Memeory," +workingSet+"  ,Private Memeory:,"+privateWorkingSet;   //+" , thread count: "+threadCount;
					String s = sdf.format(timeStamp)+" ,"+process.getProcessID()+" ,"+workingSet+" ,"+privateWorkingSet+" ,"+process.getName();
					System.out.println(s);
					out.write(s+System.lineSeparator());
					out.flush();
					break;
				}
			}
		}
	}
	
	
	
	public void printTotalPreformance(){
		  
		 OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
		  for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
		    method.setAccessible(true);
		    if (method.getName().startsWith("get")
		        && Modifier.isPublic(method.getModifiers())) {
		            Object value;
		        try {
		            value = method.invoke(operatingSystemMXBean);
		        } catch (Exception e) {
		            value = e;
		        } // try
		        System.out.println(method.getName() + " = " + value);
		        out.write(method.getName() + " = " + value+System.lineSeparator());
		       
		    } 
		  } 
	}
	
	public void closeFile(){
		out.flush();
		out.close();
	}
	 	

}
