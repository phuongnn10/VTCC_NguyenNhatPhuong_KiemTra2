package com.phuongnn10.KiemTra2.pages;

import com.phuongnn10.drivers.DriverManager;
import com.phuongnn10.keywords.WebUI;
import com.phuongnn10.utils.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.util.Set;

public class ProductPage extends CommonPage {

    public ProductPage() {
    }

    private String productName = "TestingProduct";

    private By productTab = By.xpath("//span[normalize-space()='Products']");
    private By addNewProductTab = By.xpath("//span[normalize-space()='Add New Product']");

    private By addNewProductTitle = By.xpath("//h5[normalize-space()='Add New Product']");
    private By productNameInput = By.xpath("//input[@placeholder='Product Name']");
    private By categoryDropdown = By.xpath("//button[@title='Sport shoes']");
    private By categorySearchInput = By.xpath("(//input[@aria-label='Search'])[1]");
    private By brandDropdown = By.xpath(("//button[@title='Select Brand']"));
    private By brandSearch = By.cssSelector("div[class='dropdown-menu show'] input[aria-label='Search']");
    private By unitInput = By.xpath("//input[@placeholder='Unit (e.g. KG, Pc etc)']");
    private By minQtyInput = By.xpath("//input[@name='min_qty']");
    private By tagInput = By.xpath("//tags[@role='tagslist']");
    private By unitPriceInput = By.xpath("//input[@placeholder='Unit price']");
    private By discountInput = By.xpath("//input[@placeholder='Discount']");
    private By quantityInput = By.xpath("//input[@placeholder='Quantity']");
    private By savePublishButton = By.xpath("//button[normalize-space()='Save & Publish']");
    private By addSuccessAlert = By.cssSelector("div[role='alert']");
    private By allProductsTab = By.xpath("//span[normalize-space()='All products']");
    private By titleAllProducts = By.xpath("//h1[normalize-space()='All products']");
    private By searchProductInput = By.xpath("//input[@id='search']");

    private By viewDetailButton = By.xpath("//tbody/tr[1]/td[9] //a[@title='View']");
    private By closeCookiePopupButton = By.xpath("//button[normalize-space()='Ok. I Understood']");
    private By productNameInDetail = By.xpath("//h1[normalize-space()='" + productName + "']");
    private By buttonCloseAdsPopup = By.cssSelector(".website-popup .modal-dialog-centered .absolute-top-right .la-close");
    public void verifyRedirectToDashboardPage() {
        WebUI.waitForPageLoaded();
        boolean checkMenuDashboard = WebUI.isDisplayed(menuDashboard);
        WebUI.logConsole("Check Menu Dashboard: " + checkMenuDashboard);
        Assert.assertTrue(checkMenuDashboard, "The menu Dashboard page not display.");
    }

    public void redirectToAddNewProductTab() {
        WebUI.clickElement(productTab);
        WebUI.clickElement(addNewProductTab);
    }

    public void verifyRedirectToAddNewProductTabSuccess() {
        boolean checkAddNewProductScreen = WebUI.isDisplayed(addNewProductTitle);
        WebUI.logConsole("Check Add New Product Title is visible " + checkAddNewProductScreen);
        Assert.assertTrue(checkAddNewProductScreen, "Redirect to Add new product tab sucess");
    }

    public void redirectToAllProductsTab() {
        WebUI.clickElement(productTab);
        WebUI.clickElement(allProductsTab);
    }

    public void assertRedirectAllProductsTabSuccess() {
        boolean checkAddNewProductScreen = WebUI.isDisplayed(titleAllProducts);
        WebUI.logConsole("Check All Products Title is visible " + checkAddNewProductScreen);
        Assert.assertTrue(checkAddNewProductScreen, "Redirect to All products tab sucess");
    }

    public void inputProductName() {
        WebUI.setText(productNameInput, productName);
    }

    public void chooseCategory() {
        WebUI.clickElement(categoryDropdown);
        WebUI.setText(categorySearchInput, "aka");
        WebUI.pressENTER();
    }

    public void inputUnit() {
        WebUI.setText(unitInput, "g");
    }

    public void inputMinQty() {
        WebUI.setText(minQtyInput, "1");
    }

    public void inputTag() {
        WebUI.setText(tagInput, "milk");
        WebUI.pressENTER();
    }

    public void inputUnitPrice() {
        WebUI.setText(unitPriceInput, "50000");
    }

    public void inputDiscount() {
        WebUI.setText(discountInput, "10000");
    }

    public void inputQuantity() {
        WebUI.setText(quantityInput, "1");
    }

    public void clickSavePublishButton() {
        WebUI.clickElement(savePublishButton);
    }

    public void verifyAddNewProductSuccess() {
        LogUtils.info("Wait for create proccess: " );
        WebUI.sleep(2);
        Boolean checkAddNew = WebUI.isDisplayed(addSuccessAlert);
        WebUI.logConsole("Check add new product success:" + checkAddNew);
        Assert.assertTrue(checkAddNew, "Add new product success");
    }

    public void inputSearch() {
        WebUI.setTextAndKey(searchProductInput, productName, Keys.ENTER);
    }

    public void clickViewProductDetail() {
        WebUI.waitForElementVisible(viewDetailButton);
        WebUI.clickElement(viewDetailButton);
        Set<String> windows = DriverManager.getDriver().getWindowHandles();

        String secondWindow = (String) ((Set<?>) windows).toArray()[1];
        WebUI.logConsole("Get second window: " + secondWindow);
        DriverManager.getDriver().switchTo().window(secondWindow);
        WebUI.logConsole("Switch to detail window success");
    }

    public void clickCloseCookiePopup() {
        WebUI.clickElement(closeCookiePopupButton);
        WebUI.clickElement(buttonCloseAdsPopup);
    }

    public void verifyProductDetail() {
        WebUI.waitForElementVisible(productNameInDetail);
        WebUI.logConsole("Product name in detail:" + WebUI.getElementText(productNameInDetail));
        boolean verifyProductName = WebUI.verifyContains(String.valueOf(productNameInDetail), productName);
        WebUI.logConsole("Check product name in detail: " + verifyProductName);
        Assert.assertTrue(verifyProductName, "Product name in detail is true");
    }
}
