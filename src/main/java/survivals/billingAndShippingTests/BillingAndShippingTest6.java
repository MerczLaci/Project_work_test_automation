package survivals.billingAndShippingTests;

import common.DriverFactory;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import survivals.pages.*;

/*
Comment about products:
Product1-P�ros �lm�nyek-Kapar�s Aj�nd�k P�roknak
Product2-Kapar�s Kincskeres� T�rk�p Gyerekeknek
Product3-Kapar�s Adventi Napt�r Gyerekeknek
 */

public class BillingAndShippingTest6 extends DriverFactory {
    @Test(priority = 1)
    @Description("KH-T39 After filling in the mandatory fields of billing data, we choose another delivery address where we fill the mandatory fields")
    public void fillBillingDataMandatoryFieldsAndAnotherDeliveryAddressMandatoryFields() throws InterruptedException {
        //Loading home page
        driver.get("https://www.kaparoskalandok.hu/");
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickAcceptAllButton();
        //Steps
        //1.Step: Navigate from home page to products page.
        homePage.clickProducts();
        //2.Step: Select product and navigate to the product page.
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickProduct3Name();
        //3.Step: Put the product into the cart.
        Product3Page product3Page = new Product3Page(driver, wait);
        product3Page.clickPutInTheCartButton();
        //4.Step: Navigate to the cart from the popup window.
        product3Page.clickCartButton();
        //5.Step: Navigate from cart page to the checkout page.
        CartPage cartPage = new CartPage(driver, wait);
        cartPage.clickGoToCheckoutButton();
        //6.Step: Fill last name input field.
        CheckoutPage checkoutPage = new CheckoutPage(driver, wait);
        checkoutPage.fillLastNameInputField("Mekk");
        //7.Step: Fill first name input field.
        checkoutPage.fillFirstNameInputField("Elek");
        //8.Step: Fill postal code input field and wait for the application to fill city input field automatically.
        checkoutPage.fillPostalCodeInputField("1034");
        //9.Step: Fill street input field.
        checkoutPage.fillStreetAndHouseNumberInputField("Kecske utca, 1.");
        //10.Step: Fill phone number input field.
        checkoutPage.fillPhoneNumberInputField("06203334455");
        //11.Step: Fill email address input field.
        checkoutPage.fillEmailAddressInputField("mekkelek@gmail.com");
        Thread.sleep(5000);
        checkoutPage.closePopupWindow();
        //12.Step: Choose home delivery with F?MA courier service.
        checkoutPage.clickHomeDeliveryFAMACourierServiceRadioButton();
        //13.Step: Choose 'Barion-card payment' option.
        checkoutPage.clickBarionCardPaymentRadioButton();
        //14.Step: On the 'Checkout' page choose check box: 'Ship to another address?' option.
        checkoutPage.clickShipToAnotherAddressField();
        //15.Step: Fill last name input field under the delivery to another address option.
        checkoutPage.fillLastNameInputFieldAtAnotherDeliveryAddress("Mekk");
        //16.Step: Fill first name input field under the delivery to another address option.
        checkoutPage.fillFirstNameInputFieldAtAnotherDeliveryAddress("Mariska");
        //17.Step: Fill postal code input field under the delivery to another address option.
        checkoutPage.fillPostalCodeInputFieldAtAnotherDeliveryAddress("2081");
        //18.Step: Fill street input field under the delivery to another address option.
        checkoutPage.fillStreetAndHouseNumberInputFieldAtAnotherDeliveryAddress("Kecskegida utca 1.");
        //Checking
        //19.Step: Check whether all the entered data is still filled with the previously recorded data.
        Assert.assertEquals(checkoutPage.getLastName(), "Mekk");
        Assert.assertEquals(checkoutPage.getFirstName(), "Elek");
        Assert.assertEquals(checkoutPage.getPostalCode(), "1034");
        Assert.assertEquals(checkoutPage.getStreetAndHouseNumber(), "Kecske utca, 1.");
        Assert.assertEquals(checkoutPage.getPhoneNumber(), "06203334455");
        Assert.assertEquals(checkoutPage.getEmailAddress(), "mekkelek@gmail.com");
        Assert.assertEquals(checkoutPage.getLastNameAtAnotherDeliveryAddress(), "Mekk");
        Assert.assertEquals(checkoutPage.getFirstNameAtAnotherDeliveryAddress(), "Mariska");
        Assert.assertEquals(checkoutPage.getPostalCodeAtAnotherDeliveryAddress(), "2081");
        Assert.assertEquals(checkoutPage.getStreetAndHouseNumberAtAnotherDeliveryAddress(), "Kecskegida utca 1.");
    }
}