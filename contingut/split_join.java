package contingut;

import java.io.*;
import java.nio.file.*;


public class split_join {
	public static void main(String[] args) throws IOException {
		 split("/home/users/inf/wiam2/iam23921514/carpeta/big-hero-6.jpg", 4);
		//split("/home/users/inf/wiam2/iam23921514/carpeta/a.txt", 4);

		// join("/home/users/inf/wiam2/iam23921514/carpeta/big-hero-6.jpg");
		//join("/home/users/inf/wiam2/iam23921514/carpeta/a.txt");
	}
	
	public static void split(String path, int num) throws IOException {
		Path paths= Paths.get(path);								// ruta
		int count = 1;
		Path rutaNueva=Paths.get(paths.toString()+".part."+count);
		
		
		InputStream lectura = Files.newInputStream(paths);			// esto lee
		int tamanio= (int) Math.ceil((float)lectura.available()/num);						// tamanio que queremos
		OutputStream escribir = Files.newOutputStream(rutaNueva);	// esto escribe
		
		
		long bys=0;
		for (int a; (a=lectura.read())!=-1 ; ) {
			if(bys==tamanio) {                                   	// mira si ha llegado al tamanio que buscamos
				count++;
				rutaNueva=Paths.get(paths+".part."+count);
				bys=0;
				escribir = Files.newOutputStream(rutaNueva);		// esto escribe
			}
			bys++;
			escribir.write(a);
		}
		
	}
	
	public static void join(String path) throws IOException {		
		Path file = Paths.get(path);								// ruta
		OutputStream escribir = Files.newOutputStream(file);
		
		for (int i=1;; i++) {
			Path infile = Paths.get(path + ".part." + i);
			
			if (  infile.toFile().isFile()  ) {
				InputStream iStream = Files.newInputStream(infile);	
				for(int a; (a=iStream.read())!=-1 ;) {
					escribir.write(a);
				}
				
			} else {
				break;
			}
		}
		
		
	}
}