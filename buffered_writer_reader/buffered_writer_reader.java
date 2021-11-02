package buffered_writer_reader;

import java.io.*;
import java.nio.file.*;

public class buffered_writer_reader {
	public static Path paths= Paths.get("a.txt");
	
	public static void main(String[] args) throws IOException {
		crear();
	}
	
	// ------------------------------------------------------------
	
	/*
	 * crear archivo con ** TOP 5 SCORE **
	 * 		+ 6 lineas -> borrar ultima line (deberia ser menos puntuacion)
	 * añadir una linea
	 * comparar puntuacion
	 * ordenar por puntuacion
	 */
	
	public static void crear() throws IOException {
		// crear archivo
		Files.createFile(paths, null);
		// crear titulo
	}
	
	public static void comprobar() {
		
	}
	
	public static void imprimir() {
		System.out.println("** TOP 5 SCORE **");
		
	}
	
	public static void top5() {
		
	}

}
