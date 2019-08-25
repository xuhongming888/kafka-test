import java.io.*;
import java.util.List;

/**
 * @description:
 * @author: xuzh1
 * @create: 2019-08-25 16:02
 **/
public class Main {

    public static void main(String[] args) throws Exception{
        String fileContent = getFileContent("D:\\log.txt");
        System.out.println(fileContent);
    }


    private static String getFileContent(String filePath) throws Exception {
        FileInputStream fis = new FileInputStream(filePath);
        StringBuilder sb = new StringBuilder();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line).append("\n");
        }

        return sb.toString();
    }


}
