package com.ipresence.framework.utilities;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static com.codeborne.selenide.Screenshots.takeScreenShotAsFile;

public class Utils {
	private static final Logger logger = LogManager.getLogger(Utils.class.getName());

	private Utils() {
		throw new IllegalStateException("Utility class");
	}

	public static String createRandomString(int length) {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int randomLimitedInt = leftLimit + (int)
					(random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		return buffer.toString();
	}

	public static void reportError(Scenario scenario) {
		FileInputStream fis = null;
		try {
			File screenshot = takeScreenShotAsFile();
			byte[] bytesArray = new byte[(int) screenshot.length()];
			fis = new FileInputStream(screenshot);
			fis.read(bytesArray); //read file into bytes[]
			scenario.embed(bytesArray, "image/png");
		} catch (Exception e) {
			logger.catching(e);
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				logger.catching(e);
			}
		}
	}
	public static String getCurrentTimeStamp() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}
}