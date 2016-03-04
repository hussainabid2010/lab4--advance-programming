
package folder;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
 import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 *
 * @author habid.bscs13seecs
 */
public class Folder {
    public static HashMap<String, ArrayList<String>> dirFiles = new HashMap<String, ArrayList<String>>();

    public static void listFilesForFolder(File folder)
            throws IOException {

        if(folder.isDirectory()) {

            ArrayList<String> fileNames = new ArrayList<String>();
            for (final File fileEntry : folder.listFiles()) {
               // System.out.println(fileEntry.toString());
                if (fileEntry.isDirectory()) {
                //  System.out.println(fileEntry.toString());
                    listFilesForFolder(fileEntry);
                } else 
                {
                 String fileName = (fileEntry.getPath());
                 String getExtension=   fileName.substring(fileName.lastIndexOf('.'));
                 //System.out.println( "extension:" + getExtension );
                if (getExtension.equals(".txt"))
                   fileNames.add(fileEntry.getPath());

                }
            }
        
                dirFiles.put(folder.getName(), fileNames);
            
        }
    }
    
    private static void file_read(String filename) throws FileNotFoundException, IOException
    {
  /*      
        
        BufferedReader br = new BufferedReader(new FileReader(filename));
try {
    StringBuilder sb = new StringBuilder();
    String line = br.readLine();

    while (line != null) {
        sb.append(line);
        sb.append(System.lineSeparator());
        line = br.readLine();
    }
    String everything = sb.toString();
} finally {
    br.close();
}
          
          */
        
        
    }
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        System.out.print("please enter the word: ");
        Scanner scan = new Scanner(System.in);
            String a = scan.next();
           
        listFilesForFolder(new File("C:\\Users\\habid.bscs13seecs\\Documents\\NetBeansProjects\\mylab4\\folder"));
        for(Entry<String, ArrayList<String>> foldername : dirFiles.entrySet())
        {
            System.out.println(foldername.getKey() + " " + foldername.getValue());
            String listString="";
            for (String s : foldername.getValue())
            {
                listString += s + "\t";
            }
            
          
           file_read(listString);
          
        }
    }

}
