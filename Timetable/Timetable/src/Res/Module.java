package Res;
import java.util.LinkedList;

public class Module {
		private LinkedList<Tutorial> tutorials = new LinkedList<Tutorial>() ;
		public Module previous;
		public Module next;
		public String Program;
		public String Mcode;
		public String Mname;
		public String Lec;
		public String Catagory;
		public String Day;
		public String Start;
		public String End;
		public String Hours;
		public String Group;
		public String Gsize;
		public String Staff;
		public String Rtype;
		public boolean isClashing;
		public Module(String Program, String Mcode, String Mname,String Lec,String 
				Catagory,String Day, String Start,
				String End, String Hours,String Group, String Gsize, String Staff,String Rtype) 
		{
			this.Program =Program;
			this.Mcode= Mcode;
			this.Mname = Mname;
			this.Lec = Lec;
			this.Catagory = Catagory;
			this.Day = Day;
			this.Start = Start;
			this.End = End;
			this.Hours = Hours;
			this.Group = Group;
			this.Gsize = Gsize;
			this.Staff = Staff;
			this.Rtype = Rtype;
			
			
		}
		
		
		public LinkedList<Tutorial> getTutorials()
		{
			return tutorials;
		}
		
		
		
	
public boolean isClashing()
{
	return isClashing;
}
public void setClash(boolean flag)
{
	isClashing = flag;
}
}

