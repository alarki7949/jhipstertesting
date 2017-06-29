package mustachejava;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.IOException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class ReadMeReWriter {

    public static void main(String[] args) throws IOException {
        ReWriterRunner info = new ReWriterRunner();
        String projectName = info.getProjectName1();
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("README.md.mustache");
        BufferedWriter bw = null;

        try{
            //Create file and specify path
            File readme = new File("README.md");

            //Create file if it doesn't exist
            if (!readme.exists()) {
                readme.createNewFile();
            }

            //Initialize filewriter
            FileWriter fw = new FileWriter(readme);
            bw = new BufferedWriter(fw);

            //Print filled in mustache template
            mustache.execute(bw, new ReadMeReWriter()).flush();
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
