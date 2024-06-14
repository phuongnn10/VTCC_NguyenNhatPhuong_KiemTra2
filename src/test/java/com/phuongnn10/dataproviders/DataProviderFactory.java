package com.phuongnn10.dataproviders;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {

    @DataProvider(name = "data_provider_login", parallel = false)
    public Object[][] dataLoginMulti() {
        return new Object[][]{
                {"admin@example.com", "123456"},
        };
    }
}
