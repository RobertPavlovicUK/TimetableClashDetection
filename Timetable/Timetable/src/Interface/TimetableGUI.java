package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Res.ClashLogger;
import Res.Module;
import Res.Tutorial;

import javax.swing.JLabel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;

public class TimetableGUI extends JFrame implements ListSelectionListener {

	private JPanel contentPane;
	private LinkedList<Module> modules;
	private Module currentModule;
	private Tutorial currentTutorial;
	 DefaultListModel<String> clashes = new DefaultListModel<String>();
	 DefaultListModel<Tutorial> tutorials = new DefaultListModel<Tutorial>();
	JLabel lblModuleInfo;
	JLabel lblProgram = new JLabel("New label");
	JLabel lblCategory = new JLabel("New label");
	JLabel lblLectureType = new JLabel("New label");
	JLabel lblDay = new JLabel("New label");
	JLabel lblStart = new JLabel("New label");
	JLabel lvlEebd = new JLabel("New label");
	JLabel lblStaff = new JLabel("New label");
	JLabel lblDuration = new JLabel("New label");
	JLabel lblGroupN = new JLabel("New label");
	JLabel lblGroupS = new JLabel("New label");
	JLabel lblGroup = new JLabel("New label");
	JButton btnNext;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private ClashLogger logger;
	private boolean Displayed = false;
	private JScrollPane scrollPane_1;
	   JList<Tutorial> list_2 = new JList<Tutorial>(tutorials);
	/**
	 * Launch the application.
	

	/**
	 * Create the frame.
	 */
	public TimetableGUI(LinkedList<Module> list) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		currentModule = list.getFirst();
		if(currentModule.getTutorials().size() != 0)
		{
		currentTutorial = currentModule.getTutorials().getFirst();
		RenderTutorialList();
		
		}
		modules = list;
		setBounds(100, 100, 806, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 btnNext = new JButton("Next Module ->");
		btnNext.setToolTipText("");
		
	
		btnNext.setBounds(651, 50, 137, 25);
		contentPane.add(btnNext);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 776, 33);
		contentPane.add(panel);
		
		 lblModuleInfo = new JLabel();
		 panel.add(lblModuleInfo);
		 lblModuleInfo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		 lblModuleInfo.setHorizontalAlignment(SwingConstants.CENTER);
		 
		 panel_1 = new JPanel();
		 panel_1.setBounds(290, 46, 190, 18);
		 contentPane.add(panel_1);
		 logger = new ClashLogger(clashes,list);
		  
		  	
		  	lblProgram = new JLabel("New label");
		  	panel_1.add(lblProgram);
		  	 
		  	 panel_2 = new JPanel();
		  	 panel_2.setBounds(34, 169, 266, 30);
		  	 contentPane.add(panel_2);
		  	 
		  	 lblLectureType = new JLabel("New label");
		  	 panel_2.add(lblLectureType);
		  	 
		  	 panel_3 = new JPanel();
		  	 panel_3.setBounds(251, 93, 263, 30);
		  	 contentPane.add(panel_3);
		  	 
		  	  lblCategory = new JLabel("New label");
		  	  panel_3.add(lblCategory);
		  	  
		  	  panel_4 = new JPanel();
		  	  panel_4.setBounds(290, 212, 190, 25);
		  	  contentPane.add(panel_4);
		  	  
		  	   lblDay = new JLabel("New label");
		  	   panel_4.add(lblDay);
		  	   
		  	   panel_5 = new JPanel();
		  	   panel_5.setBounds(345, 174, 36, 25);
		  	   contentPane.add(panel_5);
		  	   
		  	    lblStart = new JLabel("New label");
		  	    panel_5.add(lblStart);
		  	    
		  	     lblDuration = new JLabel("-");
		  	     panel_5.add(lblDuration);
		  	    
		  	    panel_6 = new JPanel();
		  	    panel_6.setBounds(383, 174, 32, 25);
		  	    contentPane.add(panel_6);
		  	    
		  	    lvlEebd = new JLabel("New label");
		  	    panel_6.add(lvlEebd);
		  	    
		  	    panel_7 = new JPanel();
		  	    panel_7.setBounds(193, 131, 367, 25);
		  	    contentPane.add(panel_7);
		  	    
		  	     lblStaff = new JLabel("New label");
		  	     panel_7.add(lblStaff);
		  	     
		  	     panel_8 = new JPanel();
		  	     panel_8.setBounds(170, 270, 200, 25);
		  	     contentPane.add(panel_8);
		  	     
		  	      lblGroupN = new JLabel("New label");
		  	      panel_8.add(lblGroupN);
		  	      
		  	      panel_9 = new JPanel();
		  	      panel_9.setBounds(460, 270, 119, 26);
		  	      contentPane.add(panel_9);
		  	      
		  	       lblGroupS = new JLabel("New label");
		  	       panel_9.add(lblGroupS);
		  	       	list_2.addListSelectionListener(this);
		  	       
		  	     
		  	       			
		  	 
		  	       
		  	    
		  	       
		  	       JList list_1 = new JList(clashes);
		  	       JScrollPane scrollPane = new JScrollPane(list_1);
		  	       scrollPane.setBounds(33, 324, 740, 107);
		  	       contentPane.add(scrollPane);
		  	       
		  	       JButton btnPrevModule = new JButton("<- Prev. Module");
		  	       btnPrevModule.addActionListener(new ActionListener() {
		  	       	public void actionPerformed(ActionEvent arg0) {
		  	       		clashes.clear();
		  	       	
		  	       		if(currentModule.previous != null)
		  	       		{	
		  	       	
						
		  	       			currentModule = currentModule.previous;
		  	       			
		  	       			setModule();
		  	       		if(currentModule.getTutorials().size() != 0)
						{
						currentTutorial = currentModule.getTutorials().getFirst();
					
						}
							
		  	       		}
		  	       		
		  	       	}
		  	       });
		  	       btnPrevModule.setBounds(12, 50, 137, 25);
		  	       contentPane.add(btnPrevModule);
		  	     list_2.setCellRenderer(new DefaultListCellRenderer() {
		  	    	 
                     @Override
                     public Component getListCellRendererComponent(JList list, Object value, int index,
                               boolean isSelected, boolean cellHasFocus) {
                    	 
                          Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    
                      
                  		if(value instanceof Tutorial)
                  		{
                  			Tutorial t = (Tutorial) value;
                  			
                  			if(t.isClashing)
                  			{
                  			setBackground(Color.RED);
                  			}
                  			
                  			
                  		}
                          return c;
                     }

                });
		  	    
		  	       JScrollPane scrollPane1 = new JScrollPane(list_2);
		  	     scrollPane1.setBounds(591, 122, 182, 170);
		  	       contentPane.add(scrollPane1);
		  	       
		  	
		  	       
		  	       tutorials.addListDataListener(new ListDataListener() {

					@Override
					public void contentsChanged(ListDataEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void intervalAdded(ListDataEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void intervalRemoved(ListDataEvent arg0) {
						// TODO Auto-generated method stub
						
					}});
		  	       JLabel lblTutorials = new JLabel("Tutorials");
		  	       lblTutorials.setBounds(651, 105, 56, 16);
		  	       contentPane.add(lblTutorials);
		  	       
		  	     
		  	      setModule();
		  	     
		  	      
		  	      
		  		btnNext.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						clashes.clear();
						if(currentModule.next != null)
						{
						
						
							
						currentModule = currentModule.next;
					
						if(currentModule.getTutorials().size() != 0)
						{
						currentTutorial = currentModule.getTutorials().getFirst();
					
						}
						Displayed = false;
						setModule();
						 
						
						}
						
						
					}
				});
		  		
		  	
	}
	
	
	private void setModule()
	{
		System.out.println("Hello");
		list_2.removeListSelectionListener(this);
		lblModuleInfo.setText(currentModule.Mname+" "+ currentModule.Mcode);
		lblProgram.setText(currentModule.Program);
		lblLectureType.setText(currentModule.Lec);
		lblCategory.setText("Term"+currentModule.Catagory);
		lblDay.setText(currentModule.Day);
		lblStart.setText(currentModule.Start+" -");
		lvlEebd.setText(currentModule.End);
		lblStaff.setText("Lecturer: "+currentModule.Staff);
		lblGroupN.setText("Group number: "+currentModule.Group);
		lblGroupS.setText("Group size: "+currentModule.Gsize);
		logger.CheckForClash(currentModule);
		
	
		RenderTutorialList();
		list_2.addListSelectionListener(this);
		if(currentModule.getTutorials().size() > 0)
		{
		Tutorial temp = currentModule.getTutorials().getFirst();
		while(temp != null)
		{
		
			setTutorial(temp);
			temp = temp.GetNext();
		}
		}
	
	}
	private void setTutorial()
	{
		
		lblModuleInfo.setText(currentTutorial.Mname+" "+ currentTutorial.Mcode);
		lblProgram.setText(currentTutorial.Program);
		lblLectureType.setText(currentTutorial.Lec);
		lblCategory.setText("Term"+currentTutorial.Catagory);
		lblDay.setText(currentTutorial.Day);
		lblStart.setText(currentTutorial.Start+" -");
		lvlEebd.setText(currentTutorial.End);
		lblStaff.setText("Lecturer: "+currentTutorial.Staff);
		lblGroupN.setText("Group number: "+currentTutorial.Group);
		lblGroupS.setText("Group size: "+currentTutorial.Gsize);
		logger.CheckForClash(currentTutorial);
	
		
	}
	private void setTutorial(Tutorial t)
	{
		
	
		logger.CheckForClash(t);
		
		
		
	}
	private void RenderTutorialList()
	{	
		tutorials.clear();
	if(currentModule.getTutorials().size() != 0)
	{
		Tutorial temp = currentModule.getTutorials().getFirst();
		while(temp != null)
		{	
			
			tutorials.addElement(temp);
			temp = temp.GetNext();
		}
	}
		

	}


	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		
		Tutorial [] temps = new Tutorial [currentModule.getTutorials().size()];
		currentModule.getTutorials().toArray(temps);
		int i = arg0.getFirstIndex();
				
			currentTutorial = temps[list_2.getSelectedIndices()[0]];
			clashes.clear();
			setTutorial();
		
	}


	
	



}
