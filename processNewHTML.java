
import java.io.*;
import java.util.*;

public class processNewHTML {

	public static void main(String[] args) {
		
		
		
		Scanner scanner = new Scanner(System.in);
		Scanner fileIn; 
		
		PrintWriter fileOut; 
		
		String filenameIn; 
		String filenameOut; 
		
		int dotIndex; 
		
		String line = null;
		
		
		
		System.out.println("Enter file name or path");
		filenameIn = scanner.nextLine();
		
		
		
		try {
			
			
			fileIn = new Scanner(new FileReader(filenameIn));
			dotIndex = filenameIn.lastIndexOf(".");
			
			if( dotIndex == -1 ) {
				filenameOut = filenameIn + ".html";				
			}
			
			else {
				filenameOut = filenameIn.substring(0, dotIndex) + ".html";
			}
			
			fileOut = new PrintWriter(filenameOut);
			
			
			
			try {
				line = fileIn.nextLine();
			}
			
			catch(NoSuchElementException e) {
				System.out.println("Error: " + e.getMessage());
			}
			
			if(line == null) {
				System.out.println("This file is empty :(");
			}
			else {
				
				fileOut.println("<html>");
				fileOut.println("<head>");
				fileOut.println("</head>");
				fileOut.println("<body>");
				fileOut.println(line);
				
				while(fileIn.hasNextLine()) {
					
					fileOut.println("<br>");
					line = fileIn.nextLine();
					
					if(line.isEmpty()) {
						fileOut.println("<br>");
					}
					else {
						fileOut.println(line);
					}
					
				}
				fileOut.println("</body>");
				fileOut.println("</html>");
				
				System.out.println("HTML file is processed :)");
			}
			fileIn.close();
			fileOut.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		
	}
}
