package mustachejava;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by larkiav1 on 6/29/17.
 */
public class ReWriterRunner {
    String projectName1 = "My Project";

    public String getProjectName1() {
        return projectName1;
    }

    public void setProjectName1(String projectName1) {
        this.projectName1 = projectName1;
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

    public static void main(String[] args){
        AngularCliReWriter run1 = new AngularCliReWriter();
        PackageReWriter run2 = new PackageReWriter();
        ReadMeReWriter run3 = new ReadMeReWriter();
        YorcReWriter run4 = new YorcReWriter();
        PomReWriter run5 = new PomReWriter();

        try{
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
