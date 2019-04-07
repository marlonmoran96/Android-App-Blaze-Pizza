package android.wku.edu.blazepizza;

/**
 * By Marlon Moran
 * Project 3
 */

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //sends user to about page
    public void about (View view) {
        Intent browserIntent =
                new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.blazepizza.com/about-us/"));
        startActivity(browserIntent);

    }

    //sends user to the menu
    public void ViewMenu (View view) {
        Intent ViewM = new Intent(this, android.wku.edu.blazepizza.Menu.class);
        startActivity(ViewM);

    }

    //sends user to order page
    public void Order (View view) {
        Intent ViewM = new Intent(this, Order.class);
        startActivity(ViewM);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflates the menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    // options for menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            // takes user to main page
            case R.id.home:
                startActivity(new Intent(this, MainActivity.class));
                return true;
                // takes user to the menu
            case R.id.viewM:
                startActivity(new Intent(this, android.wku.edu.blazepizza.Menu.class));
                return true;
                // takes user to the about page
            case R.id.about:
                startActivity(new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.blazepizza.com/about-us/")));

                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
