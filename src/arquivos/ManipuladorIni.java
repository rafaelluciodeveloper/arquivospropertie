package arquivos;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;

public class ManipuladorIni {
  
	public static void main(String[] args) throws InvalidFileFormatException, IOException, URISyntaxException {
		String url = ManipuladorIni.class.getResourceAsStream(null);
		
		Wini ini = new Wini(new File(url).getCanonicalFile());
		System.out.println(ini.toString());
        ini.put("sleepy", "age", 55);
        ini.put("sleepy2", "weight", 45.6);
        ini.store();
		
	 }
	
}
