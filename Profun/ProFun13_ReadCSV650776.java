import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ProFun13_ReadCSV650776 {
    public static void main(String[] args) {
        String path = "/C:/Users/Jaikwang/Desktop/employee.csv";
        String line ="";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            
                while((line = br.readLine()) != null){
                    System.out.println(line);
                }
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}