package android.wku.edu.blazepizza;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.lang.String;
import android.widget.Toast;
/**
 * by Marlon Moran on
 * Project 3
 */

public class Order extends AppCompatActivity {
    int guest=0;
        // used to iterate through multiple guest
    int x=2;
        // used to solo orders
    int  o1_quantity;
    int  o2_quantity;
    int  o3_quantity;
    int  o4_quantity;

    // used to displays quantity for multiple guest order
    int  o1DisQ=0;
    int  o2DisQ=0;
    int  o3DisQ=0;
    int  o4DisQ=0;

    //  used to store orders fot guest
    String [] h1;
    String [] h2;
    String [] h3;
    String [] h4;
    // used to calculate total
    Double mult_total_tab=0.00;
    // used to get and add tip
    Double tip_amt;
    // used to calculate total
    Double solo_total_tab=0.00;

    // used when getting options
    String o1;
    String o2;
    String o3;
    String o4;
    // used to iterate through h1, h2, h3, h4
    int q=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_layout);
    }

    //pressed, if the customer does not have any guest
    public void OrderSolo (View view) {
        guest=1;
        setContentView(R.layout.order_layout);
        ((TextView) findViewById(R.id.Gnum)).setText(("1"));


    }
    // called is user, enters more than one guest
    public void mult_orders (View view) {

        EditText party_size = (EditText) findViewById(R.id.sizeOfParty);
        String party_holder= party_size.getText().toString();

        // for  number of guest entered
        guest = Integer.parseInt(party_holder);

        // used to store quantity for each guest
        h1= new String[guest];
        h2= new String[guest];
        h3= new String[guest];
        h4= new String[guest];
        // calls order lay out
        setContentView(R.layout.order_layout);
        // lets user know, that they are guest one
        String one="1";
        ((TextView) findViewById(R.id.Gnum)).setText(one);



    }


    //called when the user clicks order
    public void place_order (View view) {
        // if the user is alone, then we calculate the total for a single geust
        if(guest==1){

            // gets input from user
            EditText sp= (EditText) findViewById(R.id.sp_order);
            o1= sp.getText().toString();


            EditText me= (EditText) findViewById(R.id.me_order);
            o2= me.getText().toString();

            EditText al= (EditText) findViewById(R.id.al_order);
            o3= al.getText().toString();

            EditText li= (EditText) findViewById(R.id.li_order);
             o4= li.getText().toString();
            // makes the edit text to integers, so we can calculate the total
            o1_quantity= Integer.parseInt(o1);
            o2_quantity= Integer.parseInt(o2);
            o3_quantity= Integer.parseInt(o3);
            o4_quantity= Integer.parseInt(o4);
            // calls tip layout, so user cna enter their desired tip
            setContentView(R.layout.tip_layout);
            // gets total and adds it to the global variable
            total();
                // rounds total, so it only shows tow decimal places
            Math.round(solo_total_tab);
            // converts to string, for text view
            String total_Holder= Double.toString(solo_total_tab);


            ((TextView) findViewById(R.id.totalSbill)).setText("Total: $"+total_Holder);


            // if there is more than guest guest, we do the same process for guest 1
        }else if (guest>1){
            // get edit text, to calculate order
            EditText sp= (EditText) findViewById(R.id.sp_order);
            String o1= sp.getText().toString();

            EditText me= (EditText) findViewById(R.id.me_order);
            String o2= me.getText().toString();

            EditText al= (EditText) findViewById(R.id.al_order);
            String o3= al.getText().toString();

            EditText li= (EditText) findViewById(R.id.li_order);
            String o4= li.getText().toString();

            // this time, we store these, for the increased number of guest
            h1[0]= o1;
            h2[0]= o2;
            h3[0]= o3;
            h4[0]= o4;

            // converts to integer, for the total.
            int o1_q= Integer.parseInt(o1);
            // adds to variable to the total quantity for the party.
            o1DisQ+=o1_q;
            int o2_q= Integer.parseInt(o2);
            // adds to variable to the total quantity for the party.
            o2DisQ+=o2_q;
            int o3_q= Integer.parseInt(o3);
            // adds to variable to the total quantity for the party.
            o3DisQ+=o3_q;
            int o4_q= Integer.parseInt(o4);
            // adds to variable to the total quantity for the party.
            o4DisQ+=o4_q;

            // gets cost
            double cost1 = (5.00 * o1_q);
            double cost2 = (7.95 * o2_q);
            double cost3 = (7.95 * o3_q);
            double cost4 = (7.95 * o4_q);
            // adds cost, to total bill
            mult_total_tab += cost1;
            mult_total_tab += cost2;
            mult_total_tab += cost3;
            mult_total_tab += cost4;

            // sets different layout, for the rest of the guest
            setContentView(R.layout.order_layout2);



        }
    }

    // click for order layout two, or the layout for multiple guest
    public void place_order2 (View view) {

            // x is used to iterate  through, for the correct number of guest
         if(x!=guest) {
            // ets numbers, for order
            EditText sp2 = (EditText) findViewById(R.id.sp_order);
            String o1 = sp2.getText().toString();

            EditText me2 = (EditText) findViewById(R.id.me_order);
            String o2 = me2.getText().toString();

            EditText al2 = (EditText) findViewById(R.id.al_order);
            String o3 = al2.getText().toString();

            EditText li2 = (EditText) findViewById(R.id.li_order);
            String o4 = li2.getText().toString();
            // converts them to integers
            int o1_q= Integer.parseInt(o1);
            int o2_q= Integer.parseInt(o2);
            int  o3_q= Integer.parseInt(o3);
            int o4_q= Integer.parseInt(o4);
             // adds them to the total quantity, for the whole party
             o1DisQ+=o1_q;
             o2DisQ+=o2_q;
             o3DisQ+=o3_q;
             o4DisQ+=o4_q;
             // adds them to a different list, used to keep track of each guest's orders
             h1[q]= o1;
             h2[q]= o2;
             h3[q]= o3;
             h4[q]= o4;


            // calculates total for each option
            double cost1 = (5.00 * o1_q);
            double cost2 = (7.95 * o2_q);
            double cost3 = (7.95 * o3_q);
            double cost4 = (7.95 * o4_q);


            // adds cost of each item, to the total
            mult_total_tab += cost1;
            mult_total_tab += cost2;
            mult_total_tab += cost3;
            mult_total_tab += cost4;



            // q is sued to enter the quantity for each guest into one of the 4 arrays
             // x is sued, to iterate through, until it reaches, the total number of guest

            x++;
            q++;


                // sets lprder layout 2 again, for the other guest
            setContentView(R.layout.order_layout2);
            // used to show user, which guest is up to order
            ((TextView) findViewById(R.id.Gnum)).setText(Integer.toString(x));
        }else if (x == guest) {
            // gets total
            get_total();
            // loads tip layout
            setContentView(R.layout.tip_layout);
                // converts total to a two place decimal number, for accuracy
             double m_cost= mult_total_tab;
             DecimalFormat twoForm = new DecimalFormat("#.##");


             String totalM = twoForm.format(m_cost);

            // sets total on tip layout
            ((TextView) findViewById(R.id.totalSbill)).setText("Total: $"+ totalM);


        }
        }


    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // Inflates the menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            // sends user to main page
            case R.id.home:
                startActivity(new Intent(this, MainActivity.class));
                return true;
                // sends user to the menu
            case R.id.viewM:
                startActivity(new Intent(this, android.wku.edu.blazepizza.Menu.class));
                return true;
                // sends user to the about page
            case R.id.about:
                startActivity(new Intent (Intent.ACTION_VIEW, Uri.parse("https://www.blazepizza.com/about-us/")));

                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    // calculates bill, based on quantity of each item
    public void total() {

        Double total_bill=0.00;

        double x1= (5.00 * o1_quantity);
        total_bill+= x1;


        double x2= (7.95 * o2_quantity);
        total_bill+= x2;


        double x3= (7.95 * o3_quantity);
        total_bill+= x3;

        double x4= (7.95 * o4_quantity);
        total_bill+= x4;


        solo_total_tab+=total_bill;
    }
    // calculates bill, for layout 2
    public void get_total() {
        EditText sp2 = (EditText) findViewById(R.id.sp_order);
        String o1 = sp2.getText().toString();

        EditText me2 = (EditText) findViewById(R.id.me_order);
        String o2 = me2.getText().toString();

        EditText al2 = (EditText) findViewById(R.id.al_order);
        String o3 = al2.getText().toString();

        EditText li2 = (EditText) findViewById(R.id.li_order);
        String o4 = li2.getText().toString();

        int o1_q= Integer.parseInt(o1);
        int o2_q= Integer.parseInt(o2);
        int  o3_q= Integer.parseInt(o3);
        int o4_q= Integer.parseInt(o4);
        // adds to the total quantity
        o1DisQ+=o1_q;
        o2DisQ+=o2_q;
        o3DisQ+=o3_q;
        o4DisQ+=o4_q;
        // adds to list, for the last guest
        h1[q]= o1;
        h2[q]= o2;
        h3[q]= o3;
        h4[q]= o4;




        // calculates total for each option
        double cost1 = (5.00 * o1_q);
        double cost2 = (7.95 * o2_q);
        double cost3 = (7.95 * o3_q);
        double cost4 = (7.95 * o4_q);


        // adds cost of each item, to the total
        mult_total_tab += cost1;
        mult_total_tab += cost2;
        mult_total_tab += cost3;
        mult_total_tab += cost4;

    }

    public void calc_tip (View view) {
        // gets tip entered
        EditText tip = (EditText) findViewById(R.id.tip);
        int tipAMT = Integer.parseInt(tip.getText().toString());
       // message if no tip is entered
        if(tipAMT==0){
            // pop-up message no tip
            Context context = getApplicationContext();
            CharSequence text = "Don't be cheap next time!";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            setContentView(R.layout.tip_layout);
        }
        // converts tip, into a percentage
        tip_amt=(tipAMT*.01);

        // used to format decimal to only 2 places
        DecimalFormat twoForm = new DecimalFormat("#.##");
        if(guest==1) {
            setContentView(R.layout.single_bill);
            // calculates tip
            double tip_holder = (tip_amt * solo_total_tab);
            // adds tip to the total
            solo_total_tab += tip_holder;


            // formats, total, to only two decimal places
            String total = twoForm.format(solo_total_tab);

            // displays quantity , if the user ordered at least one of the item
            if (o1_quantity > 1 || o1_quantity == 1) {


                ((TextView) findViewById(R.id.siQuant1)).setText("Simple Pizza ($5.00): " + o1_quantity);
            }
            if (o2_quantity > 1 || o2_quantity == 1) {
                ((TextView) findViewById(R.id.meQuant1)).setText("Meat Eater ($7.95): " + o2_quantity);
            }
            if (o3_quantity > 1 || o3_quantity == 1) {
                ((TextView) findViewById(R.id.alQuant1)).setText("Art Lover ($7.95): " + o3_quantity);
            }
            if (o4_quantity > 1 || o4_quantity == 1) {
                ((TextView) findViewById(R.id.liQuant1)).setText("Link in($7.95): " + o4_quantity);
            }

                // displays total
            ((TextView) findViewById(R.id.fsBill)).setText("Total: $" + total);
            // scenario for multiple guest
        }else if(guest>1) {
            // loads layout for multiple orders
            setContentView(R.layout.multi_bill);
            // calculates tip
            double tip_holder = (tip_amt * mult_total_tab);
            // adds tip, to the total
            mult_total_tab += tip_holder;
            // gets cost for each guest
            double guest_cost= mult_total_tab/guest;
             //formats cost for text view
            String totalperG= twoForm.format(guest_cost);
            // formats, total, to only two decimal places
            String total2 = twoForm.format(mult_total_tab);


                // displays results
            ((TextView) findViewById(R.id.fmBill)).setText("Total: $" + total2);
            ((TextView) findViewById(R.id.G_cost)).setText("Total for each guest: $" + totalperG);
           ((TextView) findViewById(R.id.siQuant)).setText("Simple Pizza Total ($5.00): "+ o1DisQ);
            ((TextView) findViewById(R.id.meQuant)).setText("Meat Eater Total ($7.95) :"+ o2DisQ);
            ((TextView) findViewById(R.id.alQuant)).setText("Art Lover Total ($7.95): "+ o3DisQ);
            ((TextView) findViewById(R.id.liQuant)).setText("Link In Total ($7.95): "+ o4DisQ);



            // used to iterate through guest
            int g=1;
             // string builder, used to show what every guest ordered.
            StringBuilder editText = new StringBuilder();
            // iterates through, for the total number of guest
            for (int z=0; z<guest;z++) {
                // g is used to show, which guest's results are being displayed.
                editText.append("Guest "+ g +": Simple Pizza ");
                editText.append((h1[z]));
                editText.append(" , ");

                editText.append(("Meat Eater " +h2[z]));
                editText.append(" , ");

                editText.append("Art Lover " + (h3[z]));
                editText.append(" , ");


                editText.append("Link In " + h4[z]);
                editText.append("\n");
                editText.append("\n");
                g++;
            }

            ((TextView) findViewById(R.id.guestQuant)).setText(editText);

        }

        }
        // takes user back to main page
    public void home (View view) {
        Intent home = new Intent(this, android.wku.edu.blazepizza.MainActivity.class);
        startActivity(home);


    }

}


