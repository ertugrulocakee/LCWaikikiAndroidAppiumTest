package PageObjectModels;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;
import java.util.Random;

public class JeanDetailPageObjectModel extends  BaseObjectModel{

    private final By priceTextView = By.id("com.lcwaikiki.android:id/itemBasketPrice");

    private final By addToBasketButton = By.id("com.lcwaikiki.android:id/basket");

    private final By sizeOptionButton = By.xpath("(//android.widget.FrameLayout[@content-desc=\"Stokta\"])");

    private final By confirmJeanButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]");

    private  final  By combineTextView = By.id("com.lcwaikiki.android:id/combineProductsTitle");

    private final  By confirmJeanWithHeightButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]");

    private  final By combineItem = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[3]/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.ImageView");

    private  final By heightOptionButton = By.id("com.lcwaikiki.android:id/sizeHeightConstraintLayout");

    private  final  By heightTextLabel = By.id("com.lcwaikiki.android:id/sizeHeightText");

    public  static  String price = "";



    public JeanDetailPageObjectModel(AppiumDriver driver) {
        super(driver);
    }


    private List<MobileElement> getAllSizes(){

       return  findElements(sizeOptionButton);

    }


    private void selectSize() {


        Random r = new Random();
        int number = r.nextInt(getAllSizes().size());

        getAllSizes().get(number).click();

    }

    private List<MobileElement> getAllHeights(){

         return findElements(heightOptionButton);

    }


    private void selectHeight() {


        Random r = new Random();
        int number = r.nextInt(getAllHeights().size());

        getAllHeights().get(number).click();

    }

    private  void getPrice(){

         price = findElement(priceTextView).getText();

         System.out.println(price);

    }


    public void selectJeanThenGoToBasket() {


        try{


            if(isElementVisible(combineTextView)) {

               clickElement(combineItem);

            }

        }catch (NoSuchElementException exception){

            System.out.println("You aren't on Combine Page.");

        }

        clickElement(addToBasketButton);
        selectSize();



        try{

            if(isElementVisible(heightTextLabel)){

                selectHeight();
                clickElement(addToBasketButton);
                getPrice();
                findElement(confirmJeanWithHeightButton).click();


            }else{

                clickElement(addToBasketButton);

                getPrice();

                findElement(confirmJeanButton).click();

            }

        }catch (NoSuchElementException exception){

            System.out.println("You needn't to select a height!");

        }


    }

}
