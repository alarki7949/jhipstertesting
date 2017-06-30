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
        String[] pieces = System.getProperty("user.dir").split(System.getProperty("file.separator"));
        String splitter = System.getProperty("file.separator");
        String path1 = "";

        try{
            //Mac
            if(splitter.equals("/")){
                for(int i = 0; i < pieces.length-1; i++){
                    path1 += pieces[i] + splitter;
                }
                path1 += "NewFiles/";
            }
            //Windows
            else{
                System.out.println("You are using a Windows!");
                for(int i = 0; i < pieces.length-1; i++){
                    path1 += pieces[i] + splitter + splitter;
                }
                path1 +="NewFiles\\";
            }

            //Create file if it doesn't exist
            File angularcli = new File(path1 + ".angular-cli.json");

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