package Tests;

import PageObjectModels.BasketPageObjectModel;
import PageObjectModels.HomePageObjectModel;
import PageObjectModels.JeanDetailPageObjectModel;
import PageObjectModels.JeansPageObjectModel;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class LCWAIKIKITest extends  BaseTest{


    HomePageObjectModel homePage;
    JeansPageObjectModel jeansPage;

    JeanDetailPageObjectModel jeanDetailPage;

    BasketPageObjectModel basketPage;

    @Test
    @Order(1)
    public  void login(){

        homePage = new HomePageObjectModel(driver);

        homePage.login();
        homePage.search();

    }

    @Test
    @Order(2)
    public void select(){

        jeansPage = new JeansPageObjectModel(driver);

        jeansPage.selectJean();

    }

    @Test
    @Order(3)
    public void addJeanToBasket(){

        jeanDetailPage = new JeanDetailPageObjectModel(driver);

        jeanDetailPage.selectJeanThenGoToBasket();


    }

     @Test
     @Order(4)
     public  void basketOperations(){

        basketPage = new BasketPageObjectModel(driver);

        basketPage.areSamePrices();
        basketPage.increaseJean();
        basketPage.areThereTwoJeans();
        basketPage.removeJeans();
        basketPage.isBasketEmpty();


     }


}
