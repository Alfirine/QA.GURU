package pages;

import api.LoginApi;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import models.User;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SignInPage extends BasePage {

    private static final SelenideElement
            emailForm = $("[name='email']"),
            passwordForm = $("[name='password']"),
            signInBtn = $("button[type='submit']");

    @Step("Открываем страницу")
    public static void openPage() {
        open("/courses/signin");
    }

    @Step("Авторизуемся через страницу SignIn. email: {email}, pass: {pass}")
    public static void login(User user) {
        openPage();
        localStorage().setItem("newsfeed-onboarding-cached-page-id", "post-news");
        localStorage().setItem("journal-onboarding-cached-page-id", "media-tracking");
        localStorage().setItem("disable_all_auto_popups", "true");
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        clickSignInBtn();
    }

    @Step("Задать почтовый адрес пользователя")
    public static void setEmail(String email) {
        emailForm.shouldBe(visible).setValue(email);
        emailForm.shouldHave(value(email));
    }

    @Step("Задать пароль пользователя")
    public static void setPassword(String password) {
        passwordForm.shouldBe(visible).setValue(password);
        passwordForm.shouldHave(value(password));
    }

    @Step("Нажатие кнопки Вход")
    public static void clickSignInBtn() {
        signInBtn.shouldBe(visible).click();
        signInBtn.shouldNotBe(visible);
    }

}