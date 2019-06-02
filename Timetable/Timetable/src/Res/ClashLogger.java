package Res;
import java.util.LinkedList;

import javax.swing.DefaultListModel;

import Res.*;

public class ClashLogger {

	private DefaultListModel<String> m;
	private LinkedList<Module> modules;
	private String teacherClash;

	public ClashLogger(DefaultListModel<String> m, LinkedList<Module> modules)
	{
		this.m =m;
		this.modules = modules;
	
	}
	
	public void CheckForClash(Tutorial t)
	{

		String report;
		Module tempModule = modules.getFirst();
		
		while(tempModule != null)
		{
		
				if(isClashing(t.Start,t.End,tempModule.Start,tempModule.Start) && t.Day.equals(tempModule.Day))
				{
				
					if(!t.Mcode.equals(tempModule.Mcode) )
					{
						if(comparator(t.Lec,tempModule.Lec,"&") && comparator(t.Staff,tempModule.Staff,"/")) {
					m.addElement("Clashes with"+" Module: "
				+tempModule.Mname+"("+tempModule.Mcode+")"+" Group:("+tempModule.Group +")"+ "at time: "+ tempModule.Start+"-"+tempModule.End+"Staff Name: "+teacherClash);
					t.setClash(true);
						}
					}
				}
				if(tempModule.getTutorials().size() >0)
				{
			Tutorial tempTutorial = tempModule.getTutorials().getFirst();
			while(tempTutorial != null)
			{
				
				if(isClashing(t.Start,t.End,tempTutorial.Start,tempTutorial.Start) && t.Day.equals(tempTutorial.Day))
				{
					if(!t.Mcode.equals(tempTutorial.Mcode)) {
						if(comparator(t.Lec,tempTutorial.Lec,"&") && comparator(t.Staff,tempTutorial.Staff,"/")) {
					m.addElement("Clashes with"+" Tutorial: "
							+tempTutorial.Mname+"("+tempTutorial.Mcode+")"+" Group:("+tempTutorial.Group +")"+ "at time: "+ tempTutorial.Start+"-"+tempTutorial.End+"Staff Name: "+teacherClash);
					t.setClash(true);
						}
					}
				}
				tempTutorial = tempTutorial.GetNext();
			}
				}
			tempModule = tempModule.next;
			
		}
		
	}
	public void CheckForClash(Module t)
	{	//m.clear();
	
	System.out.println("sadwadsdawd");
		String report;
		Module tempModule = modules.getFirst();
		while(tempModule != null)
		{
			
				if(isClashing(t.Start,t.End,tempModule.Start,tempModule.Start) && t.Day.equals(tempModule.Day))
				{
					
					if(!t.Mcode.equals(tempModule.Mcode))
					{

						if(comparator(t.Lec,tempModule.Lec,"&") && comparator(t.Staff,tempModule.Staff,"/")) {
					m.addElement("Clashes with"+" Module: "
				+tempModule.Mname+"("+tempModule.Mcode+")"+" Group:("+tempModule.Group +")"+ "at time: "+ tempModule.Start+"-"+tempModule.End+"Staff Name: "+teacherClash);
					System.out.println("Module clash "+tempModule.Mname);
						
						}
				}
					
				}
				
				if(tempModule.getTutorials().size() >0)
				{
			Tutorial tempTutorial = tempModule.getTutorials().getFirst();
			while(tempTutorial != null)
			{
				
				if(isClashing(t.Start,t.End,tempTutorial.Start,tempTutorial.Start) && t.Day.equals(tempTutorial.Day))
				{
					if(!t.Mcode.equals(tempTutorial.Mcode))
					{
						if(comparator(t.Lec,tempTutorial.Lec,"&") && comparator(t.Staff,tempTutorial.Staff,"/")) {
					m.addElement("Clashes with"+" Tutorial: "
							+tempTutorial.Mname+"("+tempTutorial.Mcode+")"+" Group:("+tempTutorial.Group +")"+ "at time: "+ tempTutorial.Start+"-"+tempTutorial.End+"Staff Name: "+teacherClash);
				
				}
					}
					}
				tempTutorial = tempTutorial.GetNext();
			}
				}
			tempModule = tempModule.next;
			
		}
		
	}
	
	private boolean isClashing(String startTime1,String endTime1, String startTime2,String endTime2)
	{	try {
		int startTime1Int = TimerParser.TimeToInt(startTime1);
		int endTime1Int = TimerParser.TimeToInt(endTime1);
	
		int startTime2Int = TimerParser.TimeToInt(startTime2);
		int endTime2Int = TimerParser.TimeToInt(endTime2);
	
		
		if(startTime1Int<= startTime2Int && endTime1Int > startTime2Int)
		{
			return true;
		}
		else return false;
	} catch(NumberFormatException e)
	{
		
	}
		return false;
		
	}
	
	private boolean comparator(String val1, String val2,String delimeter)
	{
		if(val1.equals(val2))
		{
			if(delimeter.equals("/"))
			{
				teacherClash = val1;
			}
			return true;
		}
		else {
			if(val1.contains(delimeter))
			{
				String terms1[] = val1.split(delimeter);
				for(String t: terms1)
				{
					if(t.equals(val2))
					{
						if(delimeter.equals("/"))
						{
							teacherClash = t;
						}
						return true;
					}
				}
			}
			if(val2.contains(delimeter))
			{
				String terms2[] = val2.split(delimeter);
				for(String t: terms2)
				{
					
					if(t.equals(val1))
					{
						if(delimeter.equals("/"))
						{
							teacherClash = t;
						}
						return true;
					}
				}
			}
			
		}
		return false;
		
	}


	
	

}
