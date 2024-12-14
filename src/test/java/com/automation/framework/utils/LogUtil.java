package com.automation.framework.utils;

import com.automation.framework.annotations.LazyComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;

@LazyComponent
public class LogUtil {
    public static LogEntries getLogs(WebDriver driver) {
        return driver.manage().logs().get(LogType.BROWSER);
    }
}
