package path;

import java.io.IOException;
import java.nio.file.*;
import java.security.*;
import java.util.*;
import java.util.stream.Collectors;

public class treediff_solana_oihane {
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		Path dirA = Paths.get("/home/users/inf/wiam2/iam23921514/Desktop/dirA");
		Path dirB = Paths.get("/home/users/inf/wiam2/iam23921514/Desktop/dirB");
		List<Path> pathsA =  Files.walk(dirA).filter(Files::isRegularFile).collect(Collectors.toList());
		List<Path> pathsB =  Files.walk(dirB).filter(Files::isRegularFile).collect(Collectors.toList());
		boolean is = false;
		
		System.out.println("1: Els fitxers del DirA que no estan al DirB");

		for(Path file:pathsA) {
			byte[] hash1 = MessageDigest.getInstance("MD5").digest(Files.readAllBytes(file));
			is=false;
			for(Path file2:pathsB) {
				byte[] hash2 = MessageDigest.getInstance("MD5").digest(Files.readAllBytes(file2));
				if (Arrays.equals(hash1, hash2)) {is = true;}
			}
			if (is==false) {System.out.println("\tNO se ha encontrado: " + file.getFileName());}
		}
		
		// -----------------------------------------------------------------------------------
		
		System.out.println("\n\n2: Els fitxers del DirA que estan al DirB però en una altra ruta");
		
		for(Path file:pathsA) {
			byte[] hash1 = MessageDigest.getInstance("MD5").digest(Files.readAllBytes(file));
			is=false;
			for(Path file2:pathsB) {
				byte[] hash2 = MessageDigest.getInstance("MD5").digest(Files.readAllBytes(file2));
				if (Arrays.equals(hash1, hash2)) {
					if (!dirA.relativize(file).equals(dirB.relativize(file2))) {is = true;}
				}
			}
			if (is==true) {System.out.println("\tSI se ha encontrado: " + file.getFileName());}
		}
		
		// -------------------------------------------------------------------------------------------
		
		System.out.println("\n\n3: Els fitxers del DirB que no estan al DirA ");
		
		
		for(Path file:pathsB) {
			byte[] hash1 = MessageDigest.getInstance("MD5").digest(Files.readAllBytes(file));
			is=false;
			for(Path file2:pathsA) {
				byte[] hash2 = MessageDigest.getInstance("MD5").digest(Files.readAllBytes(file2));
				if (Arrays.equals(hash1, hash2)) {is = true;}
			}
			if (is==false) {System.out.println("\tNO se ha encontrado: " + file.getFileName());}
		}
		
		// -------------------------------------------------------------------------------------------
		
		System.out.println("\n\n4: Els fitxers del DirB que estan al DirA peo en una altra ruta");
		
		
		for(Path file:pathsB) {
			byte[] hash1 = MessageDigest.getInstance("MD5").digest(Files.readAllBytes(file));
			is=false;
			for(Path file2:pathsA) {
				byte[] hash2 = MessageDigest.getInstance("MD5").digest(Files.readAllBytes(file2));
				if (Arrays.equals(hash1, hash2)) {
					if (!dirB.relativize(file).equals(dirA.relativize(file2))) {is = true;}
				}
			}
			if (is==true) {System.out.println("\tSI se ha encontrado: " + file.getFileName());}
		}
		
		// --------------------------------------------------------------------------------------------
		
		System.out.println("\n\n5. Els fitxers que estan a la mateixa ruta al DirectoriA i al DirectoriB");
		
		for(Path file:pathsA) {
			byte[] hash1 = MessageDigest.getInstance("MD5").digest(Files.readAllBytes(file));
			is=false;
			for(Path file2:pathsB) {
				byte[] hash2 = MessageDigest.getInstance("MD5").digest(Files.readAllBytes(file2));
				if (Arrays.equals(hash1, hash2)) {
					if (file.getFileName().equals(file2.getFileName())) {is = true;}
				}
			}
			if (is==true) {System.out.println("\tSI se ha encontrado: " + file.getFileName());}
		}



	}
}
