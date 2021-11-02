package path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

public class dateTree_solana_oihane {

	public static void main(String[] args) throws IOException {

    	Path dir = Paths.get("/home/users/inf/wiam2/iam23921514/Desktop/directori");
    	Files.walk(dir).filter(Files::isRegularFile).forEach(
            	File -> {
                	try {
                    	LocalDateTime date = LocalDateTime.parse(Files.getLastModifiedTime(File).toString(), DateTimeFormatter.ISO_DATE_TIME);

                    	String newDir = "/home/users/inf/wiam2/iam23921514/Desktop/directori" + "/" +date.getYear() + "/" + date.getMonthValue()+"/" + date.getDayOfMonth();
                    	Path newPath = Paths.get(newDir);

                    	Files.createDirectories(newPath);
                    	Files.move(File, newPath.resolve(File.getFileName()));

                	} catch (Exception e) {
                    	e.printStackTrace();
                	}
            	}

    	);
    	Files.walk(dir).filter(Files::isDirectory).sorted(Collections.reverseOrder()).forEach(
            	File -> {
                	try {
                    	if (!Files.list(File).findAny().isPresent()){
                        	Files.delete(File);
                    	}

                	} catch (IOException e) {
                    	e.printStackTrace();
                	}
            	}
    	);

	}
}
