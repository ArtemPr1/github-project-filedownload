import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class main {
    public static void main (String[] args) {
        String url = "https://img.gazeta.ru/files3/397/14400397/chmonya-pic_32ratio_900x600-900x600-7396.jpg";
        String fileName = "C:/Users/artem/IdeaProjects/project_java/src/main/kot.jpg";


        FileOutputStream fout = null;
        BufferedInputStream in = null;


        try {
            in = new BufferedInputStream(new URL(url).openStream());
            fout = new FileOutputStream(fileName);
            byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data,0,1024)) !=-1){
                fout.write (data, 0,count);
                fout.flush();
            }
        }  catch (MalformedURLException e) {
                e.printStackTrace();
        }   catch (IOException e) {
                e.printStackTrace();

        } finally {
            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    fout.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }









}
