package www.digitalelectronics.multilanguagesupport;

import android.app.Application;
import android.content.Context;

import www.digitalelectronics.multilanguagesupport.Helper.LocaleHelper;


public class MainApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base,"en"));
    }
}
