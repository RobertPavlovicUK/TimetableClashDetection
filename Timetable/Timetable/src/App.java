import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

import Interface.TimetableGUI;
import Res.Module;
import Res.Tutorial;



public class App {
	static LinkedList<Module> modules = new LinkedList<Module>();	
	static Module m1;
	static Tutorial previous;
	static Module prevModule = null;
	public static void main(String[] args) {
		
		LoadFile();
		
		
		Module m = modules.getFirst();
		
		while(m != null)
		{
		
			m = m.next;
		}

			
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimetableGUI frame = new TimetableGUI(modules);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	
	}
	
	public static void LoadFile()
	{
		String filename="test123.csv";
		File file = new File(filename);
		BufferedReader a;
		try {
		a = new BufferedReader(new FileReader(file));
		String l1;
		String Program,Mcode,Mname,Lec,Category,Day,Start,End,Hours,Group,Gsize,Staff,Rtype;
		while ((l1= a.readLine()) != null) {
		StringTokenizer bt = new StringTokenizer(l1,",");
		Program = bt.nextToken();
		Mcode = bt.nextToken();
		Mname = bt.nextToken();
		Lec = bt.nextToken();
		Category = bt.nextToken();
		Day = bt.nextToken();
		Start = bt.nextToken();
		End = bt.nextToken();
		Hours = bt.nextToken();
		Group = bt.nextToken();
		Gsize = bt.nextToken();
		Staff = bt.nextToken();
		Rtype = bt.nextToken();
		//System.out.println("Program: " + Program + "| Mcode: "+ Mcode + "|Mname: " + Mname + "| Lec: " + Lec + " |Category: "+ Category + "|Day: "+ Day + "|start: "+ Start +"|End: "+ End + "|Hours: "+ Hours +"|Group: "+ Group +"|Gsize: "+ Gsize +"|Staff: "+ Staff +"|Rtype: "+ Rtype +"");
		/// store this data in objects
		//store data in Moduel objec
		
		if(Lec.equals("Lecture") || Lec.equals("Lecture/tutorial")) {
		m1= new Module(Program,Mcode,Mname,Lec,Category,Day,Start,End,Hours,Group,Gsize,Staff,Rtype);
	
		
		modules.add(m1);
	
		previous = null;
		if(prevModule != null)
		{
			System.out.println("Gg");
			prevModule.next = m1;
			m1.previous = prevModule;
			
		}
		prevModule = m1;
	
		}
		if(Lec.equals("Practicals") || Lec.equals("Tutorial") ||Lec.equals("Practical"))
		{
			if(m1 != null)
			{
			Tutorial t = new Tutorial(Program,Mcode,Mname,Lec,Category,Day,Start,End,Hours,Group,Gsize,Staff,Rtype);
		
			
			m1.getTutorials().add(t);
			if(previous != null)
			{
				previous.setNext(t);
				t.setPrevious(previous);
				
			}
			previous = t;
		
			}
		}
		
			
				}
				a.close();

			} catch (FileNotFoundException e) {

				e.printStackTrace();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}


			

	}
		}


