package Res;

public class Tutorial {

	private Tutorial next = null;
	private Tutorial previous= null;
	
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
	
	public Tutorial(String Program, String Mcode, String Mname,String Lec,String 
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
	
	public void setNext(Tutorial t)
	{
	  next= t;
	}
	public void setPrevious(Tutorial t)
	{
		previous = t;
	}
	public Tutorial GetNext()
	{
		return next;
	}
	public Tutorial GetPrevious()
	{
		return previous;
	}
	
	@Override
	public String toString()
	{
		return Staff+"("+ Day+":"+Start+"-"+End+")";
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
