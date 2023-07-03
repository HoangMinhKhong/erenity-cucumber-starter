package vmo.hooks;

import io.cucumber.java.Before;
import net.thucydides.core.annotations.Steps;
import vmo.openurl.NavigateTo;

public class hookSearch {
    private static boolean beforeGroup = false;
    private static boolean beforeFeature = false;

    @Steps
    NavigateTo navigateTo;

    @Before(order = 0, value = "@search")
    public void user_login_on_home_page() {
        if (!beforeFeature) {
            navigateTo.open_home_page();
            beforeFeature = true;
        }
    }
}
