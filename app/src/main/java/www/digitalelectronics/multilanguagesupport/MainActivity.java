package www.digitalelectronics.multilanguagesupport;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import io.paperdb.Paper;
import www.digitalelectronics.multilanguagesupport.Helper.LocaleHelper;

public class MainActivity extends AppCompatActivity {
private TextView textView;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Paper.init(this);
        String language = Paper.book().read("language");
        if(language==null){
            Paper.book().write("language","en");
        }
        updateView((String)Paper.book().read("language"));
    }

    private void updateView(String language) {

        Context context=LocaleHelper.setLocale(this,language);
        Resources resources = context.getResources();

        textView.setText(resources.getString(R.string.greeting_message));
    }

    public void init(){
        textView = findViewById(R.id.textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.language_en){
            Paper.book().write("language","en");
            updateView((String)Paper.book().read("language"));

        }
        else  if (item.getItemId()==R.id.language_hi){
            Paper.book().write("language","his ");
            updateView((String)Paper.book().read("language"));

        }
        return super.onOptionsItemSelected(item);
    }
}
