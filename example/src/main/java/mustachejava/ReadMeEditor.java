package mustachejava;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.IOException;
import java.io.PrintWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReadMeEditor {

    String projectName = "MyProject";

    public static void main(String[] args) throws IOException {
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("README.md.mustache");
        mustache.execute(new PrintWriter(System.out), new ReadMeEditor()).flush();

        BufferedWriter bw = null;

        try{
            String mycontent = "This is a test and" +
                    " I hope it works!";

            //Create file and specify path
            File readme = new File("README.md");

	        //Create file if it doesn't exist
            if (!readme.exists()) {
                readme.createNewFile();
            }

            //Initialize filewriter
            FileWriter fw = new FileWriter(readme);
            bw = new BufferedWriter(fw);
            bw.write(mycontent);
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
