package is.ru.stringcalculator;
import java.util.Vector;


public class Calculator {

	public static int add(String text) {
		String delim = ",|\n";

		if (text.startsWith("//")) {
			delim = String.valueOf(text.charAt(2));
			text = text.substring(text.indexOf("\n") + 1);
		}

		if(text.equals("")) {
			return 0;
		}
		else if (delim != ",|\n" || text.contains(",") || text.contains("\n")) {
			return sum(splitNumbers(text, delim));
		}
		return toInt(text);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String breaker){
	     return numbers.split(breaker);
	}
      
    private static int sum(String[] numbers){

 	    int total = 0;
 	  	Vector<String> Veccio = new Vector<String>();
        for(String number : numbers){
        	int temp = toInt(number);
        	if(temp < 0)
        	{
        		Veccio.add(number);
        	}

		    total += toInt(number);
		}
		if(Veccio.size() > 0)
		{
			String message = "Negatives not allowed: ";
			for(int i = 0; i < Veccio.size(); i++)
			{
				message += Veccio.elementAt(i);
				message += ",";
			}
			message = message.substring(0, message.length() -1);
			throw new RuntimeException(message);
		}
		return total;
    }

}