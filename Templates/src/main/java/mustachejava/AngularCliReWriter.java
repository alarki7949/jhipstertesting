package mustachejava;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.IOException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class AngularCliReWriter {
    ReWriterRunner info = new ReWriterRunner();
    String projectName = info.getProjectName1();

    public static void main(String[] args) throws IOException {
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile(".angular-cli.json.mustache");
        BufferedWriter bw = null;

        try{
            //Create file path
            String dirpath = new ReWriterRunner().getPath()+"\\NewFiles";

            //Create directory if it doesn't exist
            File path = new File(dirpath);
            if (!path.exists()) {
                path.mkdir();
            }

            //Create file if it doesn't exist
            File angularcli = new File(dirpath+"\\.angular-cli.json");
            if (!angularcli.exists()) {
                angularcli.createNewFile();
            }

            //Initialize filewriter
            FileWriter fw = new FileWriter(angularcli);
            bw = new BufferedWriter(fw);

            //Print filled in mustache template
            mustache.execute(bw, new AngularCliReWriter()).flush();
            System.out.println("File written Successfully");

        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        finally
        {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }
    }

}