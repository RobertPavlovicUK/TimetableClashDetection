package Res;

public class TimerParser {

	public static int TimeToInt(String time) throws NumberFormatException
	{
		
		String[] split = time.split(":");
		
		return Integer.parseInt(split[0]);
	}
}
