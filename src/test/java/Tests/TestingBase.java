package Tests;

import java.util.Properties;

import Setup.PropertiesConfig;

public class TestingBase {
	protected String url;
	protected String adminUser;
	protected String password;
	
	public TestingBase() {
		Properties credentialsProperties=PropertiesConfig.getCredentialsProperties();
		this.url=credentialsProperties.getProperty("url");
		this.adminUser=credentialsProperties.getProperty("emailAdmin");
		this.password=credentialsProperties.getProperty("password");
	}
	
}
