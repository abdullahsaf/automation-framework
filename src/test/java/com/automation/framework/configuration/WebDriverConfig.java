package com.automation.framework.configuration;

import com.automation.framework.annotations.LazyAutowired;
import com.automation.framework.annotations.LazyConfiguration;
import com.automation.framework.annotations.WebdriverScopeBean;
import com.automation.framework.utils.BrowserUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("!grid")
@LazyConfiguration
public class WebDriverConfig {
    @LazyAutowired
    private BrowserUtil browserUtil;

    @WebdriverScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    @Primary
    public WebDriver firefoxDriver() {
        return new FirefoxDriver();
    }

    @WebdriverScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    @Primary
    public WebDriver edgeDriver() {
        return new EdgeDriver();
    }

    @WebdriverScopeBean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    @Primary
    public WebDriver chromeDriver() {
        return new ChromeDriver(browserUtil.getChromeOptions());
    }
}
