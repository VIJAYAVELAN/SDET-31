package crm.MavenDemo;

import org.testng.annotations.Test;

public class CommandTest {

	@Test

	public void getData() {
		System.out.println(System.getProperty("browser"));
		System.out.println(System.getProperty("url"));
		System.out.println(System.getProperty("username"));
		System.out.println(System.getProperty("password"));
	}

}
