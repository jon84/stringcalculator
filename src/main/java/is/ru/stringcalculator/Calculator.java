package is.ru.stringcalculator;



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
 	  	
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }

}