import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.lang.*;


public class day2
{
    public static void main(String [] args) throws FileNotFoundException
    {
        String currString = new String();
        int[] counts = new int[4];

        if(args.length > 0)
        {
            Scanner infile = new Scanner(new File(args[0]));
            while(infile.hasNext())
            {
                currString = infile.nextLine();
                counts = processId(currString, counts);
            }
        }
        System.out.println(counts[2] + " times " + counts[3] + " = " + counts[2] * counts[3]);

    }
    private static int [] processId(String currString, int [] counts)
    {
       Map<Character,Integer> seenChars = new HashMap<Character,Integer>(); 
       int temp = 0, currCount;
       boolean twoSeen = false;
       boolean threeSeen = false;

       for(int i = 0; i < currString.length(); i++)
       {
                temp = seenChars.getOrDefault(currString.charAt(i),0) + 1;
                seenChars.put(currString.charAt(i), temp);          

       }
       Iterator mapIt = seenChars.entrySet().iterator();
       while(mapIt.hasNext())
       {
            Map.Entry mapping = (Map.Entry) mapIt.next();

            currCount = (int)mapping.getValue();
            if(currCount == 2 && !twoSeen)
            {
                counts[2]++;
                twoSeen = true;
            }
            else if(currCount == 3 && !threeSeen)
            {
                counts[3]++;
                threeSeen = true;
            }
       }

        return counts;
    }
}
