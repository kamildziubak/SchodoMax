package LanguageModule;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Language extends HashMap{
	
	public Language(String language)
	{
		new HashMap<String, String>();
		File langFile = new File("lang/" +language+".lang");
		try {
			Scanner reader = new Scanner(langFile);
			while (reader.hasNextLine()){
				String line = reader.nextLine();
				int index = line.indexOf(":");
				put(line.substring(0, index), line.substring(index+2));
			}
			 reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}