/*	Program Name:	MyMethods.java
	Programmer:		Rafael Mejia
	Date:			9/9/21

	This is software that we will add to throuhgout the year to make our lives
	easier.  All methods will STATIC and accessable to the user.  */

// Import statements
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.NumberFormat;
import java.util.Formatter;
import java.util.Random;
import java.io.IOException;

public class MyMethods{

	// Method to print the title to the top of my programs
	public static void programTitle(String incomingTitle)
	{
		System.out.println("\nProgram Name:\t" + incomingTitle + ".java");
		System.out.println("Written By:\tRafael Mejia");
		System.out.println("Date:\t\t" + getStringDate());
	}

	public static Date getDate()
	{
		Date today = new Date();

		return today;
	}

	// Helper methods for getting the date and then changing to a string
	private static String getStringDate()
	{
		// declare Date variable to hold todays date
		Date today = new Date(); // defaults to the currents days date

		// Set the format to print the date
		String format = "MM/dd/yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);

		return dateFormat.format(today);
	}

	// Random Number Generator - generic one (no limits)
	public static int getRandomInt()
	{
		// Declare random number generator
		Random gen = new Random();

		return gen.nextInt();

	}

	// Random Number Generator - specific, (between 1 and some upperLimit)
	public static int getRandomInt(int upperLimit)
	{
		return (Math.abs(getRandomInt()) % upperLimit );
	}

	// Random Number Generator - specific, (between lowerLimit and some upperLimit)
	public static int getRandomInt(int lowerLimit, int upperLimit)
	{
		return (getRandomInt(upperLimit - lowerLimit) + lowerLimit);
	}


	// Method for string input - return a string to the calling method
	public static String getString()
	{
		// Declare a string variable
		String returnString;

		// Create the scanner
		Scanner inputScanner = new Scanner(System.in);

		// fill the return string
		returnString = inputScanner.nextLine();

		// return the string
		return returnString;
	}

	// Method to get a string, but this one receives the prompt
	public static String getString(String prompt)
	{
		System.out.print(prompt);

		return getString();
	}

	// going to be used for integer input
	public static int getInt()
	{
		// Using theInteger class to change text numbers to actual numbers
		boolean numberEntered;
		Integer stringInt = new Integer("0");

		do{
			// error checking -try/catch error checking
			try{
				stringInt = new Integer(getString());

				numberEntered = true;

			}catch(NumberFormatException e) // catches the NumberFormatException - always looks the same
			{
				System.out.println("You didn't enter a number.");
				System.out.print("Please re-enter a number: ");

				numberEntered = false;
			}
		}while(!numberEntered);

		return stringInt.intValue();
	}

	public static int getInt(String prompt)
	{
		System.out.print(prompt);

		return getInt();
	}

	// going to be used for double input
	public static double getDouble()
	{
		// Using the Double class to change text numbers to actual numbers
		boolean numberEntered;
		Double stringDouble = new Double("0.0");

		// error checking -try/catch error checking
		do{
			try{
				stringDouble = new Double(getString());

				numberEntered = true;

			}catch(NumberFormatException e) // catches the NumberFormatException - always looks the same
			{
				System.out.println("You didn't enter a number.");
				System.out.print("Please re-enter: ");

				numberEntered = false;
			}
		}while(!numberEntered);

		return stringDouble.doubleValue();
	}

	// Gets the prompt from the user to send to the screen before we recieve double
	public static double getDouble(String prompt){
		System.out.print(prompt);

		return getDouble();
	}

	// Money formatter
	public static String toMoney(double incomingMoney)
	{
		NumberFormat formatter = NumberFormat.getCurrencyInstance();

		return formatter.format(incomingMoney);
	}

	// Percent formatter
	public static String toPercent(double incomingNumber, int places)
	{
		NumberFormat percent = NumberFormat.getPercentInstance();
		percent.setMinimumFractionDigits(places);

		return percent.format(incomingNumber);
	}

	// Decimal Formatter
	public static String toDecimal(double incomingNumber, int places)
	{
		NumberFormat decimal = NumberFormat.getInstance();

		// ternery operator - modified "if" statement
		// if decimal print 2 places, if integer print 0 decimal places
		places = (incomingNumber % 1 != 0) ? places : 0;

		decimal.setMaximumFractionDigits(places);

        return decimal.format(incomingNumber);
	}

	// Pausing and clearing the screen
	public static void clearScreen(){
		// Pause
		System.out.print("Press any key to continue . . .");
		new Scanner(System.in).nextLine();
		// Clear
		try{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}catch (IOException | InterruptedException e){}
	}
}


