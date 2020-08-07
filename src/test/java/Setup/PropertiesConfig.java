package Setup;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfig {
	public static Properties getCredentialsProperties() {
		try {
			FileReader reader = new FileReader("credentials.properties");
			Properties prop=new Properties();
			prop.load(reader);
			return prop;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
