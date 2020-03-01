package source;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class CodingExamB {
	public static void main(String[] args) {
		/*
		 * Write a java program that asks the user to enter a file name.
		 * If the file can be opened, print the contents of the file in reverse. (last line first, first line last)
		 * If the file cannot be opened, let the user know and allow them to enter a new file.
		 * 
		 */
		
		String fileName = JOptionPane.showInputDialog("Enter a file name");
		String [] lines = new String[fileName.length()];
		int counter =0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = br.readLine();
			lines[0] = line;
			counter++;
			while(line != null) {
				line = br.readLine();
				lines[counter] = line;
				counter++;
			}
			br.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "The file can't be opened");
			fileName = JOptionPane.showInputDialog("Enter a file name");
		}
		for (int i = lines.length-2; i > -1; i--) {
			System.out.println(lines[i]);
		}
	}
}
