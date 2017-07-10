package mustachejava;

import java.io.IOException;
import java.util.Scanner;

import java.io.*;

/**
 * Created by larkiav1 on 6/29/17.
 */
public class ReWriterRunner {
    static String projectName;

    public static String getProjectDescription() {
        return projectDescription;
    }

    public static void setProjectDescription(String projectDescription) {
        ReWriterRunner.projectDescription = projectDescription;
    }

    static String projectDescription;

    public String getProjectName1() {
        return projectName;
    }

    public void setProjectName1(String projectName1) {
        this.projectName = projectName1;
    }

    static String packageName;

    public static String getPackageName() {
        return packageName;
    }

    public static void setPackageName(String packageName) {
        ReWriterRunner.packageName = packageName;
    }

    static String packageFolder;

    public static String getPackageFolder() {
        return packageFolder;
    }

    public static void setPackageFolder(String packageFolder) {
        ReWriterRunner.packageFolder = packageFolder;
    }

    public static String getProperty(String propertyName) throws Exception{
        String thisLine = null;
        String toReturn = " ";

        try {
            FileReader properties = new FileReader("properties.txt");
            BufferedReader br = new BufferedReader(properties);

            while ((thisLine = br.readLine()) != null) {
                if(thisLine.length() > propertyName.length() &&thisLine.substring(0,propertyName.length()).equals(propertyName)){
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
            projectDescription = getProperty("projectDescription");
            packageName = getProperty("packageName");
            packageFolder = getProperty("packageFolder");
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
