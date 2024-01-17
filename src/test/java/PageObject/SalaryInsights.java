package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SalaryInsights {
    public final SelenideElement
            roleInput = $x("//input[@name='role']"),
            countryInput = $x("//input[@name='country']"),
            submitBtn = $x("//button[@type='submit']"),
            headerField = $x("//div[@data-qa='salary-table']");

    public void clickSubmitBtn(String role, String country) {
        roleInput.shouldBe(visible, enabled);
        roleInput.sendKeys(role);
        roleInput.sendKeys(Keys.DOWN);
        roleInput.sendKeys(Keys.DOWN);
        roleInput.sendKeys(Keys.RETURN);
        countryInput.shouldBe(visible, enabled).setValue(country);
        countryInput.sendKeys(Keys.DOWN,Keys.RETURN);
        submitBtn.shouldBe(visible,enabled).click();
    }

}
