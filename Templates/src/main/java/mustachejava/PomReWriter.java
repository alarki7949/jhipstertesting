package mustachejava;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.IOException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.regex.Pattern;


public class PomReWriter {
    ReWriterRunner info = new ReWriterRunner();
    String projectName = info.getProjectName1();

    public static void main(String[] args) throws IOException {
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("pom.xml.mustache");
        BufferedWriter bw = null;
        String splitter = System.getProperty("file.separator");
        String path1 = "";

        try{
            //Mac
            if(splitter.equals("/")){
                String[] pieces = System.getProperty("user.dir").split(System.getProperty("file.separator"));
                for(int i = 0; i < pieces.length-1; i++){
                    path1 += pieces[i] + splitter;
                }
                path1 += "NewFiles/";
            }
            //Windows
            else{
                System.out.println("You are using a Windows!");
                String pattern = Pattern.quote(System.getProperty("file.separator"));
                String[] pieces = System.getProperty("user.dir").split(pattern);
                for(int i = 0; i < pieces.length-1; i++){
                    path1 += pieces[i] + splitter + splitter;
                }
                path1 +="NewFiles\\";
            }

            //Create file if it doesn't exist
            File pom = new File(path1 + "pom.xml");

            //Initialize filewriter
            FileWriter fw = new FileWriter(pom);
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