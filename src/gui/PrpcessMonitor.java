package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import monitor.monitorProcess;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;

public class PrpcessMonitor {

	private JFrame frame;
	private JTextField loopInterval;
	List<String> processesNames = new ArrayList<String>();
	monitorProcess mP;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrpcessMonitor window = new PrpcessMonitor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrpcessMonitor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 562, 351);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loopInterval = new JTextField();
		loopInterval.setText("60");
		
		loopInterval.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Loop interval (seconds)");
		
		JCheckBox chckbxAfconPcimServer = new JCheckBox("Afcon.Pcim.Server.exe",true);
		
		
		JCheckBox chckbxAfconpcimserverservicecallbackadaptorexe = new JCheckBox("Afcon.Pcim.Server.Service.CallbackAdaptor.exe",true);
	
		
		JCheckBox chckbxAfconpcimserverservicealarmpublisherexe = new JCheckBox("Afcon.Pcim.Server.Service.AlarmPublisher.exe",true);
		
		
		JCheckBox chckbxAfconpcimworkstationexe = new JCheckBox("Afcon.Pcim.WorkStation.exe",true);
		
		
		JCheckBox chckbxAfconpulseserverservicedataloggerpublisherexe = new JCheckBox("Afcon.Pulse.Server.Service.DataLoggerPublisher.exe",false);
		
		JCheckBox chckbxAfconpcimserverserviceschedulerexe = new JCheckBox("Afcon.Pcim.Server.Service.Scheduler.exe",false);
		
		JCheckBox chckbxAfconpcimserverserviceeventmanagementpublisherexe = new JCheckBox("Afcon.Pcim.Server.Service.EventManagementPublisher.exe",false);
		
		JCheckBox chckbxAfconpcimserverservicedatasheetpublisherexe = new JCheckBox("Afcon.Pcim.Server.Service.DataSheetPublisher.exe",false);
		
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int loopInt=Integer.parseInt(loopInterval.getText());
				
				if (chckbxAfconPcimServer.isSelected())
					processesNames.add(chckbxAfconPcimServer.getText());
				if (chckbxAfconpcimserverservicecallbackadaptorexe.isSelected())
					processesNames.add(chckbxAfconpcimserverservicecallbackadaptorexe.getText());
				if (chckbxAfconpcimserverservicealarmpublisherexe.isSelected())
					processesNames.add(chckbxAfconpcimserverservicealarmpublisherexe.getText());
				if (chckbxAfconpcimworkstationexe.isSelected())
					processesNames.add(chckbxAfconpcimworkstationexe.getText());
				
				if (chckbxAfconpulseserverservicedataloggerpublisherexe.isSelected())
					processesNames.add(chckbxAfconpulseserverservicedataloggerpublisherexe.getText());
				if (chckbxAfconpcimserverserviceschedulerexe.isSelected())
					processesNames.add(chckbxAfconpcimserverserviceschedulerexe.getText());
				if (chckbxAfconpcimserverserviceeventmanagementpublisherexe.isSelected())
					processesNames.add(chckbxAfconpcimserverserviceeventmanagementpublisherexe.getText());
				if (chckbxAfconpcimserverservicedatasheetpublisherexe.isSelected())
					processesNames.add(chckbxAfconpcimserverservicedatasheetpublisherexe.getText());
				
				 mP= new monitorProcess(processesNames);
					
				 
				 btnStart.setEnabled(false);
				
				Timer timer = new Timer();
				timer.scheduleAtFixedRate(new TimerTask() {
					  @Override
					  public void run() {
						  
							//mP.printTotalPreformance();
							mP.printProcesses();
							
					  }
					}, loopInt*1000,loopInt*1000);
			}
		});
		
		
		
		JButton btnStop = new JButton("stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mP.closeFile();
				System.exit(0);
			}
		});
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(loopInterval, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(57)
							.addComponent(btnStart)
							.addGap(56)
							.addComponent(btnStop))
						.addComponent(chckbxAfconpcimserverservicecallbackadaptorexe)
						.addComponent(chckbxAfconPcimServer)
						.addComponent(chckbxAfconpcimserverservicealarmpublisherexe)
						.addComponent(chckbxAfconpcimworkstationexe)
						.addComponent(chckbxAfconpulseserverservicedataloggerpublisherexe)
						.addComponent(chckbxAfconpcimserverserviceschedulerexe)
						.addComponent(chckbxAfconpcimserverserviceeventmanagementpublisherexe)
						.addComponent(chckbxAfconpcimserverservicedatasheetpublisherexe))
					.addContainerGap(110, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(chckbxAfconPcimServer)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxAfconpcimserverservicecallbackadaptorexe)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxAfconpcimserverservicealarmpublisherexe)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxAfconpcimworkstationexe)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxAfconpulseserverservicedataloggerpublisherexe)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxAfconpcimserverserviceschedulerexe)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxAfconpcimserverserviceeventmanagementpublisherexe)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chckbxAfconpcimserverservicedatasheetpublisherexe)
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(loopInterval, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(btnStart)
						.addComponent(btnStop))
					.addGap(22))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
