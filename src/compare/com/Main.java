package compare.com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;



public class Main
{

    public static void main(String[] args) throws IOException
    {
        JSONObject obj = new JSONObject();
        File file1 = new File("C:\\Users\\bhargavi\\Desktop\\filereader\\file1.txt");
        File file2 = new File("C:\\Users\\bhargavi\\Desktop\\filereader\\file2.txt");

        FileReader r1 = new FileReader(file1);
        FileReader r2 = new FileReader(file2);

        BufferedReader reader1 = new BufferedReader(r1);
        BufferedReader reader2 = new BufferedReader(r2);

        String str1 = reader1.readLine();
        String str2 = reader2.readLine();
        char[] arr = str1.toCharArray();
        int wordCount = 0;
        int LineNumber = 0;
        boolean areEqual = false;

        while (str1 != null && str2 != null)
        {
            if (str1.equalsIgnoreCase(str2))
            {
                areEqual = true;
                LineNumber++;
                for (int i = 0; i < arr.length; i++)
                {
                    if (arr[i] == ' ') {
                        wordCount++;
                    }
                }

            } else
            {
                areEqual = false;
                break;
            }
            str1 = reader1.readLine();
            str2 = reader2.readLine();
            wordCount++;
        }

        if (areEqual) {
            FileWriter MyWriter = new FileWriter("C:\\Users\\bhargavi\\Desktop\\jsonfiles\\file3.json");
            //		BufferedWriter newWriter = new BufferedWriter(MyWriter);
            System.out.println("Files are same:");
            obj.put("Words", "No Of words " + wordCount);
            MyWriter.write(obj.toString());
            System.out.println("no of words=" +wordCount);
            MyWriter.flush();
            MyWriter.close();
        } else {
            System.out.println("File are not same");
        }

    }
}
