// The "CCC2015S2" class.
import javax.swing.JOptionPane;
public class CCC2015S2
{
    public static void main (String[] args)
    {
	String input = JOptionPane.showInputDialog ("Enter number of jerseys J");
	int bigJ = Integer.parseInt (input); //number of jerseys
	input = JOptionPane.showInputDialog ("Enter number of atheletes A");
	int bigA = Integer.parseInt (input); //number of atheletes

	int[] j = new int [bigJ + 1];
	int[] aSize = new int [bigA + 1];
	int[] aNum = new int [bigA + 1];

	int count = 0;

	for (int i = 0 ; i < bigJ ; i++)
	{
	    input = JOptionPane.showInputDialog ("Enter the size of jersey #" + (i + 1));

	    if (input.equals ("S"))
	    {
		input = "1";
	    }
	    else if (input.equals ("M"))
	    {
		input = "2";
	    }
	    else
	    {
		input = "3";
	    }

	    j [i + 1] = Integer.parseInt (input); //0th index empty
	}

	for (int i = 0 ; i < bigA ; i++)
	{
	    input = JOptionPane.showInputDialog ("Enter the size and number of athelete #" + (i + 1));

	    if (input.substring (0, 1).equals ("S"))
	    {
		aSize [i + 1] = 1;
	    }
	    else if (input.substring (0, 1).equals ("M"))
	    {
		aSize [i + 1] = 2;
	    }
	    else
	    {
		aSize [i + 1] = 3;
	    }

	    aNum [i + 1] = Integer.parseInt (input.substring (2, 3)); //0th index empty
	}

	/*        //debugging
	for (int i = 0 ; i < bigJ ; i++)
	{
	    System.out.println (j [i + 1]);
	}
	for (int i = 0 ; i < bigA ; i++)
	{
	    System.out.println (aSize [i + 1]);
	    System.out.println (aNum [i + 1]);

	}*/

	//match each a in J to all a in A
	for (int i = 0 ; i < bigJ ; i++)
	{
	    for (int k = 0 ; k < bigA ; k++)
	    {
		if (aNum [k + 1] == (i + 1) && j [i + 1] >= aSize [k + 1])  //number matches and size >= player request
		{
		    count++;
		    break; //only a max of 1 player of the same requested number can be satisfied. 
		    //if you find a fit for one player number, move to the next number 
		}
	    }
	}
	
	System.out.println(count);



    } // main method
} // CCC2015S2 class
