package com.automation.framework.utils;

import com.automation.framework.annotations.LazyComponent;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.logging.Level;

@LazyComponent
public class BrowserUtil {
    public ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences loggingPrefs = new LoggingPreferences();
        loggingPrefs.enable(LogType.BROWSER, Level.ALL);
        loggingPrefs.enable(LogType.DRIVER, Level.ALL);
        options.addArguments("headless");
        options.setCapability("goog:loggingPrefs", loggingPrefs);
        return options;
    }

    public FirefoxOptions getFireFoxOptions() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("devtools.console.stdout.content", true);
        FirefoxOptions options = new FirefoxOptions();
        Proxy proxy = new Proxy();
        proxy.setAutodetect(false);
        proxy.setNoProxy("no_proxy-var");
        options.setCapability("proxy", proxy);
        LoggingPreferences loggingPrefs = new LoggingPreferences();
        loggingPrefs.enable(LogType.BROWSER, Level.ALL);
        loggingPrefs.enable(LogType.DRIVER, Level.ALL);
        options.setProfile(profile).setCapability("moz:loggingPrefs", loggingPrefs);
        return options;
    }
}
