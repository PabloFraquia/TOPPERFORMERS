package Setup;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ValidationPropConfig {
	public static Properties getValidationProperties() {
		try {
			FileReader reader = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\validationRuleData.properties");
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
