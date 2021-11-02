package path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class flatten_solana_oihane {

	public static void main(String[] args) throws IOException {
		Path dir = Paths.get("/home/users/inf/wiam2/iam23921514/niats");
		
		// pasar los archivos a niats
		Files.walk(dir)
			.filter(Files::isRegularFile)  // le indicas que utilizaras archivos
			.forEach(file -> {
				try {
					Files.move(file, dir.resolve(file.getFileName()) );
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		
		
		// borrar directorios niats
		Files.walk(dir)
		.sorted(Comparator.reverseOrder())  // lo ordenas al reves para poder borrar las carpetas vacias primero, sino da error
		.filter(Files::isDirectory)         // le indicas que utilizaras directorios
		.forEach(carpeta -> {
			if (!carpeta.getFileName().equals(dir.getFileName())) {
				try {
				Files.delete(carpeta);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
