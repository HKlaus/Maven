package de.tom;
import java.util.Scanner;

public class Main 
{
	/*
	 * Main Methode
	 */
    public static void main( String[] args )
    {
        // TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in); /*Scanner*/
		String a = scan.nextLine();
		a = a.toUpperCase();
		System.out.println(a);
		scan.close();
    }
}