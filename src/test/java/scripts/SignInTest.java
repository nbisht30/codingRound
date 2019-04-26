package scripts;

import org.testng.annotations.Test;

import superhelper.Base;

public class SignInTest extends Base {
	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
		loadURL("https://www.cleartrip.com/");

	}
}
