package File;

import java.io.File;
import java.util.Arrays;

public class SeeFilesInOneDirectory {
    public static void main(String[] args) {

        File f = new File("/Users/ffadsasda/Documents");
        String[] filenames = f.list();

        assert filenames != null;

        Arrays.stream(filenames).forEach(System.out::println);


        File dir = new File("/User/fdasfds/Documents");
        File[] files = dir.listFiles();
        assert files != null;
        for (File file : files)
            System.out.println(file.getName() + " Can Write: "+file.canWrite()+
                    " Is Hidden: "+file.isHidden()+" Length: "+file.length()+" bytes");

    }
}
