package yandex.samokat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import yandex.BaseTest;
import yandex.pageObject.*;

@RunWith(Parameterized.class)
public class OrderScooterTest extends BaseTest {

    private WebDriver driver;
    private final boolean isTopPageOrderButton;

    private final String name = "Имя";
    private final String surname = "Фамилиевич";
    private final String address = "Мой адрес не дом и не улица";
    private final String metroStation = "Сокольники";
    private final String phone = "89994445566";
    private final String date = "01.01.2024";
    private final String comment = "Коментарий";

    public OrderScooterTest(boolean isTopPageOrderButton) {
        this.isTopPageOrderButton = isTopPageOrderButton;
    }

    @Parameterized.Parameters
    public static Object[][] getTopPageOrderButton() {
        return new Object[][]{
                {true},
                {false},
        };
    }

    @Before
    public void setUp() {
        driver = createDriver("chrome");
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void orderScooterByTopPageOrderButton() {
        clickPageOrderButton(isTopPageOrderButton);

        UserInfoDeliveryPage userInfoDeliveryPage = new UserInfoDeliveryPage(driver);
        userInfoDeliveryPage.clickAgreeCookiesWindow();
        userInfoDeliveryPage.setUserInfoPage(name, surname, address, metroStation, phone);
        userInfoDeliveryPage.clickNextButton();

        RentDeliveryPage rentDeliveryPage = new RentDeliveryPage(driver);
        rentDeliveryPage.setRentDeliveryPage(date, comment);
        rentDeliveryPage.clickOrderButton();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        orderConfirmationPage.clickConfirmationButton();

        OrderPlacedPage orderPlacedPage = new OrderPlacedPage(driver);
        orderPlacedPage.checkOrderPlacedWindow();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void clickPageOrderButton (boolean isTopPageOrderButton) {
        HomePageSamokat homePageSamokat = new HomePageSamokat(driver);
        if (isTopPageOrderButton) {
            homePageSamokat.clickTopPageOrderButton();
        } else {
            homePageSamokat.scrollMiddlePageOrderButton();
            homePageSamokat.clickMiddlePageOrderButton();
        }
    }
}
