import java.util.*;
import java.io.*;

public class day1
{
    public static void main(String [] args) throws FileNotFoundException
    {
       if(args.length > 0)
       {
           String filename = new String(args[0]);

           Scanner infile = new Scanner(new File(filename));

           while(infile.hasNext())
           {
                System.out.println(infile.nextLine());
           }
       }
       else
       {
           System.out.println("Invalid filename, exiting..");
       }

    }
}
