// The "MultipleChoiceGrader" class.
import hsa.Console;
import java.io.*;
import java.util.*;

public class MultipleChoiceGraderV2
{
    public static void main (String[] args) throws IOException
    {

	Console cons = new Console ();
	char[] [] responses = new char [1] [1]; //student responses
	char[] answerKey = new char [1]; //answer key inputted by teacher

	int numQuestions;
	String responsesFilePath = "Responses.txt";

	numQuestions = getKey (answerKey, cons);
	getResponses (responses, numQuestions, responsesFilePath);

	int[] grades = new int [numQuestions]; //grade assigned to each student

	calculateGrades (responses, answerKey, grades, cons);
	displayGrades (grades, cons);


	// Place your code here
    } // main method



    public static int getKey (char[] key, Console c)  //returns number of questions
    {
	String input;
	int numQ; //number of questions

	c.println ("Enter the full answer key in one line without spaces.");
	input = c.readString ().toUpperCase (); //ensures the key is in upper case

	key = new char [input.length ()];
	numQ = key.length;

	for (int question = 0 ; question < 10 ; question++)
	{
	    key [question] = input.charAt (0); //stores answer to each question in the array
	}
	return numQ;
    }


    public static void getResponses (char[] [] resp, int numQ, String filePath) throws IOException
    {
	BufferedReader br = new BufferedReader (new FileReader (filePath));
	String studentLine = br.readLine ();

	//count number of students
	int numS = 0; //student number
	while (studentLine != null)
	{
	    studentLine = br.readLine (); //read the line of answers for the next student
	    numS++;
	}

	//reset to read the first line of the responses file
	br.close ();
	br = new BufferedReader (new FileReader (filePath));
	
	//replace the responses array with the correct number of students and questions
	resp = new char[numS][numQ];

	//read responses file and store into array
	for (int student = 0 ; student < numS ; student++)
	{
	    System.out.println ("reading student " + student);
	    studentLine = br.readLine (); //read the line of answers for this student
	    for (int question = 0 ; question < numQ ; question++)
	    {
		//assuming each student answers all questions
		resp [student] [question] = studentLine.charAt (question * 2);
		System.out.print(resp [student] [question]+" ");
	    }
	    System.out.println("");
	}

    }



    public static void calculateGrades (char[] [] responses, char[] key, int[] numCorrect, Console c)
    {
	int correct;

	for (int student = 0 ; student < 8 ; student++)
	{
	    correct = 0; //reset correct count for this student
	    for (int question = 0 ; question < 10 ; question++)
	    {
		if (responses [student] [question] == key [question])
		{
		    correct++;
		}
	    }
	    numCorrect [student] = correct; //enter this student's grade to the grades array
	}
    }


    public static void displayGrades (int[] numCorrect, Console c)
    {
	for (int student = 0 ; student < 8 ; student++)
	{
	    c.println ("Student " + (student + 1) + "'s correct count is " + numCorrect [student]);
	}
    }
} // MultipleChoiceGrader class
