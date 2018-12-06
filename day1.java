import java.util.*;
import java.io.*;

public class day1
{
    public static void main(String [] args) throws FileNotFoundException
    {
       int result = 0; 


       if(args.length > 0)
       {
           String filename = new String(args[0]);

           Scanner infile = new Scanner(new File(filename));
           while(infile.hasNext())
           {
                
                result += infile.nextInt();
           }
           System.out.println("Answer = " + result);
       }
       else
       {
           System.out.println("Invalid filename, exiting..");
       }

    }
}
