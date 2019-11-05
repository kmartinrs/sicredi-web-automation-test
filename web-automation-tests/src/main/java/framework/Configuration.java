package framework;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import models.TestConfiguration;

public final class Configuration {

	public static TestConfiguration getTestConfiguration() {
		JSONParser parser = new JSONParser();
		TestConfiguration testConfiguration = new TestConfiguration();

		try {
			Object obj = parser.parse(new FileReader("./testConfiguration.json"));

			JSONObject jsonObject = (JSONObject) obj;

			testConfiguration.setAppURL((String) jsonObject.get("AppUrl"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return testConfiguration;
	}

}