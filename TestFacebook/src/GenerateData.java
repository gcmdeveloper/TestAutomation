import org.apache.commons.lang3.RandomStringUtils;

public class GenerateData {
	
	public String generateRandomString(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}
	
	public String generateRandomNumber(int length) {
		return RandomStringUtils.randomNumeric(length);
	}
	
	public String generateRandomAlphaNumeric(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}
	
	public String generateRandomAlphabet(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}
	
	public String generateRandomData(int length, boolean letters, boolean numbers) {
		return RandomStringUtils.random(length, letters, numbers);
	}

}
