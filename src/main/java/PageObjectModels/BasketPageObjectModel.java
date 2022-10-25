package PageObjectModels;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import static PageObjectModels.JeanDetailPageObjectModel.price;

public class BasketPageObjectModel extends  BaseObjectModel{

    private final By basketPriceTextView = By.id("com.lcwaikiki.android:id/itemBasketPrice");

    private final By plusImageView = By.id("com.lcwaikiki.android:id/plusImageView");

    private final By itemCountTextView = By.id("com.lcwaikiki.android:id/itemBasketCountText");

    private final By removeButton = By.id("com.lcwaikiki.android:id/buttonNegative");

    private final By emptyBasketImage = By.id("com.lcwaikiki.android:id/emptyBasketImage");

    private  final  By minus = By.id("com.lcwaikiki.android:id/minusLayout");

    private  final By minusImage = By.id("com.lcwaikiki.android:id/minusImageView");


    public BasketPageObjectModel(AppiumDriver driver) {
        super(driver);
    }

    public void areSamePrices(){

        String basketPrice = getText(basketPriceTextView);
        System.out.println(basketPrice);

        if(basketPrice.equals(price)){

            System.out.println("The prices are same!");

        }else {

            System.out.println("The prices are not same !");

        }

    }


    public void increaseJean(){

        clickElement(plusImageView);

    }

    public boolean areThereTwoJeans(){

        int value =  Integer.valueOf(getText(itemCountTextView));
        System.out.println(value);

        if(value == 2){

            return  true;

        }

        return  false;

    }

    public  void removeJeans(){


        clickElement(minus);

        clickElement(minusImage);

        clickElement(removeButton);


    }

    public boolean isBasketEmpty(){

        return isElementVisible(emptyBasketImage);

    }



}
