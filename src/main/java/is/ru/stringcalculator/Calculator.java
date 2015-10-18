package is.ru.stringcalculator;



public class Calculator {

	public static int add(String text){
		
		if(text.equals("")){
			return 0;
		}
		else if (text.startsWith("//")){
			String cutter = text.substring(text.indexOf('\n') + 1);
			String delim = String.valueOf(text.charAt(2));
			return sum(splitNumbers(cutter, delim));
		}
		else if (text.contains("\n") && text.contains(",")) {
			return sum(splitNumbers(text));
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}

			return toInt(text);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}
	private static String[] splitNumbers(String numbers){
			return numbers.split(",|\n");
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