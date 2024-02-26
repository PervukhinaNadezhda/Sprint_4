package yandex.pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HomePageSamokat {

    private final WebDriver driver;
    private final By questionAnswerList = By.className("accordion"); //Блок всех вопросов и ответов
    private final By actualQuestion = By.className("accordion__heading"); //Вопрос
    private final By actualAnswer = By.className("accordion__panel"); //Ответ
    private final By topPageOrderButton = By.className("Button_Button__ra12g"); //Кнопка "Заказать" в верхней части страницы
    private final By middlePageOrderButton = By.xpath(".//div[@class = 'Home_FinishButton__1_cWm']/button"); //Кнопка "Заказать" в середине страницы

    public HomePageSamokat(WebDriver driver) {
        this.driver = driver;
    }

    // метод для скролла до блока вопросов
    public void scrollQuestionAnswerListElement() {
        WebElement questionAnswerListElement = driver.findElement(questionAnswerList);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", questionAnswerListElement);
    }

    // метод для скролла до средней кнопки "Заказать"
    public void scrollMiddlePageOrderButton() {
        WebElement questionAnswerListElement = driver.findElement(middlePageOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", questionAnswerListElement);
    }

    // метод для нажатия на вопрос из списка
    public void clickActualQuestion(int id) {
        List<WebElement> actualQuestionsList = driver.findElements(actualQuestion);
        actualQuestionsList.get(id).click();
    }

    // метод для получения текста вопроса из списка на странице
    public String getActualQuestionTextFromList(int id) {
        List<WebElement> actualQuestionsList = driver.findElements(actualQuestion);
        return actualQuestionsList.get(id).getText();
    }

    // метод для получения текста ответа из списка на странице
    public String getActualAnswerText(int id) {
        List<WebElement> actualAnswersList = driver.findElements(actualAnswer);
        return actualAnswersList.get(id).getText();
    }

    // метод проверяет текст вопроса
    public void checkQuestionText(String expectedQuestionText, String actualQuestionText) {
        assertEquals("Не верный текст вопроса", expectedQuestionText, actualQuestionText);
    }

    // метод проверяет текст ответа
    public void checkAnswerText(String expectedAnswerText, String actualAnswerText) {
        assertEquals("Не верный текст ответа", expectedAnswerText, actualAnswerText);
    }

    // метод проверяет видимость ответа
    public void isEnabledAnswer(int id) {
        List<WebElement> actualAnswersList = driver.findElements(actualAnswer);
        Assert.assertTrue("Не отображается ответ", actualAnswersList.get(id).isEnabled());
    }

    // метод для нажатия на кнопку "Заказать" вверху экрана
    public void clickTopPageOrderButton() {
        driver.findElement(topPageOrderButton).click();
    }

    // метод для нажатия на кнопку "Заказать" в середине экрана
    public void clickMiddlePageOrderButton() {
        driver.findElement(middlePageOrderButton).click();
    }
}
