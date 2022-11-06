package PageObjectModels;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;


public class HomePageObjectModel extends BaseObjectModel{

    private final By searchBox = By.id("com.lcwaikiki.android:id/search");
    private final By  toolbarSearch = By.id("com.lcwaikiki.android:id/toolbar_search");

    public HomePageObjectModel(AppiumDriver driver) {
        super(driver);
    }

    public  void search(){

        clickElement(searchBox);
        clickElement(toolbarSearch);
        sendKeys(toolbarSearch,"pantolon");
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search")); // Android Search Button works...

    }

}
