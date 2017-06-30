package mustachejava;

import java.io.IOException;
import java.util.Scanner;

import java.io.*;

/**
 * Created by larkiav1 on 6/29/17.
 */
public class ReWriterRunner {
    static String projectName;

    public String getProjectName1() {
        return projectName;
    }

    public void setProjectName1(String projectName1) {
        this.projectName = projectName1;
    }

    public static String getPath(){
        String s;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the directory name under which the project files are stored.");
        System.out.println("Example: C:\\Users\\guptad1\\work\\jhipstertesting)");
        System.out.println("Use double slashes when typing.");
        s = in.nextLine();
        return s;
    }

    public static String getProperty(String propertyName) throws Exception{
        String thisLine = null;
        String toReturn = " ";

        try {
            // open input stream test.txt for reading purpose.
            FileReader properties = new FileReader("properties.txt");
            BufferedReader br = new BufferedReader(properties);

            while ((thisLine = br.readLine()) != null) {
                if(thisLine.substring(0,propertyName.length()).equals(propertyName)){
                    toReturn = thisLine;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        toReturn = toReturn.substring(toReturn.indexOf('[')+1,toReturn.indexOf(']'));
        return toReturn;

    }

    public static void main(String[] args) throws Exception{
        AngularCliReWriter run1 = new AngularCliReWriter();
        PackageReWriter run2 = new PackageReWriter();
        ReadMeReWriter run3 = new ReadMeReWriter();
        YorcReWriter run4 = new YorcReWriter();
        PomReWriter run5 = new PomReWriter();

        try{
            projectName = getProperty("projectName");
            run1.main(null);
            run2.main(null);
            run3.main(null);
            run4.main(null);
            run5.main(null);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
