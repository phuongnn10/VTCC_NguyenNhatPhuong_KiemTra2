package com.phuongnn10.KiemTra2.testcases;

import com.phuongnn10.KiemTra2.pages.LoginPage;
import com.phuongnn10.KiemTra2.pages.ProductPage;
import com.phuongnn10.common.BaseTest;
import com.phuongnn10.dataproviders.DataProviderFactory;
import com.phuongnn10.helpers.CaptureHelper;
import org.testng.annotations.Test;

public class ProductDetailTest extends BaseTest {

    LoginPage loginPage;
    ProductPage productPage;

    @Test(dataProvider = "data_provider_login", dataProviderClass = DataProviderFactory.class)
    public void searchProduct(String email, String password) {
        loginPage = new LoginPage();
        loginPage.login(email, password);
        loginPage.verifyLoginSuccess();

        productPage = new ProductPage();
        productPage.redirectToAllProductsTab();
        productPage.assertRedirectAllProductsTabSuccess();

        productPage.inputSearch();
        productPage.clickViewProductDetail();
        productPage.clickCloseCookiePopup();
        productPage.verifyProductDetail();
        CaptureHelper.captureScreenshot("Product Detail screen");
    }
}
