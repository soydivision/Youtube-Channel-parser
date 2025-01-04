package com.mycompany.app;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class AppTest {
    @Test
    public void parseYoutubeChannel() {
        String channelUrl = "https://www.youtube.com/@HobbesSakuga/videos";
        open(channelUrl);
        int scrollCount = 15;
        for (int i = 0; i < scrollCount; i++) {
            actions().sendKeys(Keys.PAGE_DOWN).perform();
            sleep(300);
        }
        ElementsCollection videoLinks = $$("a#video-title-link");
        for (var video : videoLinks) {
            String title = video.getAttribute("title");
            String link = video.getAttribute("href");
            System.out.println("Title: " + title);
            System.out.println(link);
        }
        closeWebDriver();
    }
}

