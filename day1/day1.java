import java.util.*;
import java.io.*;
import java.lang.*;

public class day1
{
    public static void main(String [] args) throws FileNotFoundException
    {
       int result = 0; 
       int temp = 0;
       boolean found = false;
       BitSet posSeen = new BitSet();
       BitSet negSeen = new BitSet();

       if(args.length > 0)
       {
           String filename = new String(args[0]);
           while(!found)
           {
               Scanner infile = new Scanner(new File(filename));

               while(infile.hasNext() && !found) 
               {
                   result += infile.nextInt();
                   if(result < 0)
                   {
                       temp = Math.abs(result);
                       if(negSeen.get(temp))
                       {    
                           System.out.println("Frequency: " + result + " seen twice!");
                           found = true;
                       }
                       else
                       {
                           negSeen.set(temp);
                       }
                   }
                   else
                   {
                       if(posSeen.get(result))
                       {
                           System.out.println("Frequency: " + result + " seen twice!");
                           found = true; 
                       }
                       else
                       {
                           posSeen.set(result);
                       }
                   }
               }
           }
           System.out.println("Answer = " + result);
       }
       else
       {
           System.out.println("Invalid filename, exiting..");
       }

    }
}
