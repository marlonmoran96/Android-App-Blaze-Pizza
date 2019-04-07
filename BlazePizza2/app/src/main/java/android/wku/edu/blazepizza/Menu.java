package android.wku.edu.blazepizza;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

/**
 * by Marlon Moran on
 * Project 3
 */

public class Menu  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
    }
    // loads simple pie layout, so user can view info
    public void Spie (View view) {
        setContentView(R.layout.simple_pizza);

    }

    // loads meat eater layout, so user can view info
    public void Meat (View view) {
        setContentView(R.layout.meat_lovers);

    }
    // loads Art Lover layout, so user can view info
    public void Alove (View view) {
        setContentView(R.layout.art_lover);

    }
    // loads Link In layout, so user can view info
    public void Link (View view) {
        setContentView(R.layout.link_in);

    }
    // takes user to the overall menu
    public void back_Menu (View view) {
        setContentView(R.layout.menu_layout);

    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            // takes user to main page
            case R.id.home:
                startActivity(new Intent(this, MainActivity.class));
                return true;
                // directs user to the menu
            case R.id.viewM:
                startActivity(new Intent(this, android.wku.edu.blazepizza.Menu.class));
                return true;
                // directs user to the about page
            case R.id.about:
                startActivity(new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.blazepizza.com/about-us/")));

                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
