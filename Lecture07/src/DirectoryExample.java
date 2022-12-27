import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryExample {
	
	// List directories
	public static File[] listDirectories(String path) {
    return new File(path).listFiles(File::isDirectory);
  }
	
	// List files in directory
	public static File[] listFilesInDirectory(final File folder) {
    return folder.listFiles(File::isFile);
  }
	
	// List files in directory recursively
	public static List<File> listAllFiles(String path) {
    List<File> all = new ArrayList<File>();
    File[] list = new File(path).listFiles();

    if (list != null) {  // In case of access error, list is null
      for (File f : list) {
        if (f.isDirectory()) {
          all.addAll(listAllFiles(f.getAbsolutePath()));
        } else {
          all.add(f.getAbsoluteFile());
        }
      }
    }
    return all;
  }
	
	public static void main(String[] args) {
		
		File[] directories = DirectoryExample.listDirectories("C:\\");
		System.out.println("Directory count: " + directories.length);
		for(File dir : directories) {
			System.out.println(dir.toString());
		}
		
		File[] files = DirectoryExample.listFilesInDirectory(directories[4]);
		System.out.println("File count: " + files.length);
		for(File file : files) {
			System.out.println(file.toString());
		}
		
		List<File> filelist = DirectoryExample.listAllFiles("C:\\AMD");
		for(File file : filelist) {
			System.out.println(file.toString());
		}
	}
}
