package mustachejava;

import java.io.IOException;

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

    public static void main(String[] args){
        AngularCliReWriter run1 = new AngularCliReWriter();
        PackageReWriter run2 = new PackageReWriter();
        ReadMeReWriter run3 = new ReadMeReWriter();
        YorcReWriter run4 = new YorcReWriter();


        try{
            run1.main(null);
            run2.main(null);
            run3.main(null);
            run4.main(null);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
