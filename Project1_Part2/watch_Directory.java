import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
public class watch_Directory {
    public static void main(String[] args) {
       try {
           WatchService watchService
                   = FileSystems.getDefault().newWatchService();

           String path  = Paths.get("").toAbsolutePath().toString();
           File watchfile = new File(path + "\\Client\\");
           Path directory = watchfile.toPath();
           WatchKey keywatch = directory.register(
                   watchService,
                   StandardWatchEventKinds.ENTRY_CREATE,
                   StandardWatchEventKinds.ENTRY_DELETE,
                   StandardWatchEventKinds.ENTRY_MODIFY);
           while (true) {
               try{
                   for (WatchEvent<?> eventwatch : keywatch.pollEvents()) {


                       WatchEvent<Path> pathEvent = (WatchEvent<Path>) eventwatch;

                       Path fileName = pathEvent.context();

                       // inorder to chtype of event.
                       WatchEvent.Kind<?> kindwatch = eventwatch.kind();

                       // perform necessary action with the event
                       if (kindwatch == StandardWatchEventKinds.ENTRY_CREATE) {

                           Thread.sleep(500);
                           

                           Path u = Paths.get(path+"\\Client\\"+fileName);
                           Path v = Paths.get(path+"\\Server\\"+fileName);
                           Files.copy(u, v,StandardCopyOption.REPLACE_EXISTING);
                           System.out.println("File copied to server");
                       }

                       else if (kindwatch == StandardWatchEventKinds.ENTRY_MODIFY) {

                           Thread.sleep(500);


                           Path v = Paths.get(path+"\\Server\\"+fileName);
                           Path u = Paths.get(path+"\\Client\\"+fileName);

                           Files.copy(u, v,StandardCopyOption.REPLACE_EXISTING);
                           System.out.println("A File has been copied to server");
                       }
                       else if (kindwatch == StandardWatchEventKinds.ENTRY_DELETE) {


                           Path u = Paths.get(path+"\\Server\\"+fileName);
                           Files.deleteIfExists(u);
                           System.out.println("A File has been deleted from server");
                       }
                   }


                   boolean validate = keywatch.reset();
                   if (!validate) {
                       break;
                   }
               }catch(Exception e){
               }
           }


       }
       catch(Exception e) {
           e.printStackTrace();
        }
       }
}
