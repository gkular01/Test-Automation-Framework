package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

//job of jsonutility is to read the json file
public class JSONUtility {

	public static Environment readJSON(Env env) {

		Gson gson = new Gson();// we are using GSON because we want to read json file in java.
		// in java there is no in built functionality so we are using third party
		// library GSON.

		File jsonFile = new File(System.getProperty("user.dir") + "\\config\\config.json");//
		//

		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Config config = gson.fromJson(fileReader, Config.class);
		Environment environment = config.getEnvironments().get("QA");
		return environment;
	}

}
