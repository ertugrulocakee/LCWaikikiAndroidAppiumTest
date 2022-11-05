package PageObjectModels;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public class JeansPageObjectModel extends BaseObjectModel{

    private final By jeanItem = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup");

    public JeansPageObjectModel(AppiumDriver driver) {
        super(driver);
    }

    private List<MobileElement> getAllJeans(){

        return findElements(jeanItem);

    }


    public void selectJean() {


        Random r = new Random();
        int number = r.nextInt(getAllJeans().size());

        getAllJeans().get(number).click();

    }


}


