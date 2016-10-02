import javax.swing.JOptionPane;
public class CCC2015S1
{
    public static void main (String[] args)
    {
	String input = JOptionPane.showInputDialog ("Enter number of integers.");
	int k = Integer.parseInt (input);

	String numbers = "";
	for (int i = 0 ; i < k ; i++)
	{
	    input = JOptionPane.showInputDialog ("Enter number " + (i + 1));
	    numbers += input;

	    //System.out.println (numbers);

	    if (Integer.parseInt (input) == 0)
	    {
		numbers = numbers.substring (0, numbers.length () - 2);
	    }
	    //System.out.println (numbers+"\n");
	}

	int sum = 0;

	for (int i = 0 ; i < numbers.length () ; i++)
	{
	    sum += Integer.parseInt (numbers.substring (i, i + 1));
	}

	System.out.println (sum);




    } // main method
} // CCC2015S1 class
