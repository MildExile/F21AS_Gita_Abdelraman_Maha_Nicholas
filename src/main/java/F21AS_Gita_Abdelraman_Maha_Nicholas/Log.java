package F21AS_Gita_Abdelraman_Maha_Nicholas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
/**
 * Singleton log class which records all the Thread events and produce the final output on a separate file of type txt
 * @author Abdelrahman
 *
 */
public final class Log {

    private static final Log instance = new Log();
    private ArrayList<String> logArrayList = new ArrayList<String>();;
    private PrintWriter fileOut;
    public String info;

    private Log()
    {

    }
    /**
     * a method which takes a stirng infromation as a parameter
     * pass that string into the logArrayList in order to hold it
     * @param information
     */
    public synchronized void insertLogsIntoArray(String information)
    {
        //	logArrayList.add(information);
        this.info= information;
        logArrayList.add(information);

    }

    public String getInfo()
    {
        return info;
    }

    /**
     * a method which traverse the logArrayList that contains all the log information
     * Printwriter is used to display the output
     * print each entry of the ArrayList into a separate file using PrintWriter Object
     */
    public void writeLogIntoFile()
    {
        try
        {
            fileOut = new PrintWriter("src/main/resources/output.txt");

            for(int i = 0 ; i < logArrayList.size();i++)
            {
                fileOut.println(logArrayList.get(i));
                fileOut.flush();
            }

        }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            fileOut.close();
        }


    }
    public synchronized static  Log getInstance()
    {
        //if(instance == null)
        //	instance = new Log();
        return instance;
    }
}
