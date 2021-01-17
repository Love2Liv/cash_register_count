package liveandtouch.com.cashregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {
    public static final String NICKELS = "nickels";
    public static final String DIMES = "dimes";
    public static final String QUARTERS = "quarters";
    public static final String ONE_DOLLAR = "one_dollar";
    public static final String TWO_DOLLARS = "two_dollars";
    public static final String FIVE_DOLLARS = "five_dollars";
    public static final String TEN_DOLLARS = "ten_dollars";
    public static final String TWENTY_DOLLARS = "twenty_dollars";
    public static final String FIFTY_DOLLARS = "fifty_dollars";
    public static final String ONE_HUNDRED_DOLLARS = "one_hundred_dollars";
    public static final String NICKELS_ROLL = "nickels_roll";
    public static final String DIMES_ROLL = "dimes_roll";
    public static final String QUARTERS_ROLL = "quarters_roll";
    public static final String ONE_DOLLAR_ROLL = "one_dollar_roll";
    public static final String TWO_DOLLARS_ROLL = "two_dollars_roll";

    public static final double NICKELS_COEFFICIENT = 0.05;
    public static final double DIMES_COEFFICIENT = 0.1;
    public static final double QUARTERS_COEFFICIENT = 0.25;
    public static final int TWO_DOLLARS_COEFFICIENT = 2;
    public static final int FIVE_DOLLARS_COEFFICIENT = 5;
    public static final int TEN_DOLLARS_COEFFICIENT = 10;
    public static final int TWENTY_DOLLARS_COEFFICIENT = 20;
    public static final int FIFTY_DOLLARS_COEFFICIENT = 50;
    public static final int ONE_HUNDRED_DOLLARS_COEFFICIENT = 100;
    public static final double NICKELS_ROLL_COEFFICIENT = 2;
    public static final double DIMES_ROLL_COEFFICIENT = 5;
    public static final double QUARTERS_ROLL_COEFFICIENT = 10;
    public static final int ONE_DOLLAR_ROLL_COEFFICIENT = 25;
    public static final int TWO_DOLLARS_ROLL_COEFFICIENT = 50;
    public static final int BASE_REGISTER_AMOUNT = 600;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        try{
            int nickels = 0;
            int dimes = 0;
            int quarters = 0;
            int one_dollar = 0;
            int two_dollars = 0;
            int five_dollars = 0;
            int ten_dollars = 0;
            int twenty_dollars = 0;
            int fifty_dollars = 0;
            int one_hundred_dollars = 0;
            int nickels_roll = 0;
            int dimes_roll = 0;
            int quarters_roll = 0;
            int one_dollar_roll = 0;
            int two_dollars_roll = 0;

            String nickels_str = extras.getString(NICKELS);
            if(!nickels_str.equals("")){
                nickels = Integer.parseInt(nickels_str);
            }
            String dimes_str = extras.getString(DIMES);
            if(!dimes_str.equals("")){
                dimes = Integer.parseInt(dimes_str);
            }
            String quarters_str = extras.getString(QUARTERS);
            if(!quarters_str.equals("")){
                quarters = Integer.parseInt(quarters_str);
            }
            String one_dollar_str = extras.getString(ONE_DOLLAR);
            if(!one_dollar_str.equals("")){
                one_dollar = Integer.parseInt(one_dollar_str);
            }
            String two_dollars_str = extras.getString(TWO_DOLLARS);
            if(!two_dollars_str.equals("")){
                two_dollars = Integer.parseInt(two_dollars_str);
            }
            String five_dollars_str = extras.getString(FIVE_DOLLARS);
            if(!five_dollars_str.equals("")){
                five_dollars = Integer.parseInt(five_dollars_str);
            }
            String ten_dollars_str = extras.getString(TEN_DOLLARS);
            if(!ten_dollars_str.equals("")){
                ten_dollars = Integer.parseInt(ten_dollars_str);
            }
            String twenty_dollars_str = extras.getString(TWENTY_DOLLARS);
            if(!twenty_dollars_str.equals("")){
                twenty_dollars = Integer.parseInt(twenty_dollars_str);
            }
            String fifty_dollars_str = extras.getString(FIFTY_DOLLARS);
            if(!fifty_dollars_str.equals("")){
                fifty_dollars = Integer.parseInt(fifty_dollars_str);
            }
            String one_hundred_dollars_str = extras.getString(ONE_HUNDRED_DOLLARS);
            if(!one_hundred_dollars_str.equals("")){
                one_hundred_dollars = Integer.parseInt(one_hundred_dollars_str);
            }
            String nickels_roll_str = extras.getString(NICKELS_ROLL);
            if(!nickels_roll_str.equals("")){
                nickels_roll = Integer.parseInt(nickels_roll_str);
            }
            String dimes_roll_str = extras.getString(DIMES_ROLL);
            if(!dimes_roll_str.equals("")){
                dimes_roll = Integer.parseInt(dimes_roll_str);
            }
            String quarters_roll_str = extras.getString(QUARTERS_ROLL);
            if(!quarters_roll_str.equals("")){
                quarters_roll = Integer.parseInt(quarters_roll_str);
            }
            String one_dollar_roll_str = extras.getString(ONE_DOLLAR_ROLL);
            if(!one_dollar_roll_str.equals("")){
                one_dollar_roll = Integer.parseInt(one_dollar_roll_str);
            }
            String two_dollars_roll_str = extras.getString(TWO_DOLLARS_ROLL);
            if(!two_dollars_roll_str.equals("")){
                two_dollars_roll = Integer.parseInt(two_dollars_roll_str);
            }
            //Count each coin total
            DecimalFormat number_format = new DecimalFormat("#.00");
            double nickels_value_dbl = nickels * NICKELS_COEFFICIENT;
            TextView nickels_value_tv = (TextView) findViewById(R.id.nickelsValueTextView);
            String nickels_amount = number_format.format(nickels_value_dbl);
            String nickels_value_str = nickels + " * $" + NICKELS_COEFFICIENT + " = $" + nickels_amount;
            nickels_value_tv.setText(nickels_value_str);
            //
            double dimes_value_dbl = dimes * DIMES_COEFFICIENT;
            TextView dimes_value_tv = (TextView) findViewById(R.id.dimesValueTextView);
            String dimes_amount = number_format.format(dimes_value_dbl);
            String dimes_value_str = dimes + " * $" + DIMES_COEFFICIENT + " = $" + dimes_amount;
            dimes_value_tv.setText(dimes_value_str);
            //
            double quarters_value_dbl = quarters * QUARTERS_COEFFICIENT;
            TextView quarters_value_tv = (TextView) findViewById(R.id.quartersValueTextView);
            String quarters_amount = number_format.format(quarters_value_dbl);
            String quarters_value_str = quarters + " * $" + QUARTERS_COEFFICIENT + " = $" + quarters_amount;
            quarters_value_tv.setText(quarters_value_str);
            //
            TextView one_dollar_value_tv = (TextView) findViewById(R.id.oneDollarValueTextView);
            String one_dollar_value_str = one_dollar + " * $1 = $" + one_dollar;
            one_dollar_value_tv.setText(one_dollar_value_str);
            //
            int two_dollars_value_int = two_dollars * TWO_DOLLARS_COEFFICIENT;
            TextView two_dollars_value_tv = (TextView) findViewById(R.id.twoDollarsValueTextView);
            String two_dollars_value_str = two_dollars + " * $" + TWO_DOLLARS_COEFFICIENT + " = $" + two_dollars_value_int;
            two_dollars_value_tv.setText(two_dollars_value_str);
            //
            int five_dollars_value_int = five_dollars * FIVE_DOLLARS_COEFFICIENT;
            TextView five_dollars_value_tv = (TextView) findViewById(R.id.fiveDollarsValueTextView);
            String five_dollars_value_str = five_dollars + " * $" + FIVE_DOLLARS_COEFFICIENT + " = $" + five_dollars_value_int;
            five_dollars_value_tv.setText(five_dollars_value_str);
            //
            int ten_dollars_value_int = ten_dollars * TEN_DOLLARS_COEFFICIENT;
            TextView ten_dollars_value_tv = (TextView) findViewById(R.id.tenDollarsValueTextView);
            String ten_dollars_value_str = ten_dollars + " * $" + TEN_DOLLARS_COEFFICIENT + " = $" + ten_dollars_value_int;
            ten_dollars_value_tv.setText(ten_dollars_value_str);
            //
            int twenty_dollars_value_int = twenty_dollars * TWENTY_DOLLARS_COEFFICIENT;
            TextView twenty_dollars_value_tv = (TextView) findViewById(R.id.twentyDollarsValueTextView);
            String twenty_dollars_value_str = twenty_dollars + " * $" + TWENTY_DOLLARS_COEFFICIENT + " = $" + twenty_dollars_value_int;
            twenty_dollars_value_tv.setText(twenty_dollars_value_str);
            //
            int fifty_dollars_value_int = fifty_dollars * FIFTY_DOLLARS_COEFFICIENT;
            TextView fifty_dollars_value_tv = (TextView) findViewById(R.id.fiftyDollarsValueTextView);
            String fifty_dollars_value_str = fifty_dollars + " * $" + FIFTY_DOLLARS_COEFFICIENT + " = $" + fifty_dollars_value_int;
            fifty_dollars_value_tv.setText(fifty_dollars_value_str);
            //
            int one_hundred_dollars_value_int = one_hundred_dollars * ONE_HUNDRED_DOLLARS_COEFFICIENT;
            TextView one_hundred_dollars_value_tv = (TextView) findViewById(R.id.oneHundredDollarsValueTextView);
            String one_hundred_dollars_value_str = one_hundred_dollars + " * $" + ONE_HUNDRED_DOLLARS_COEFFICIENT + " = $"
                    + one_hundred_dollars_value_int;
            one_hundred_dollars_value_tv.setText(one_hundred_dollars_value_str);
            //
            double nickels_roll_value_dbl = nickels_roll * NICKELS_ROLL_COEFFICIENT;
            TextView nickels_roll_value_tv = (TextView) findViewById(R.id.nickelRollValueTextView);
            String nickels_roll_value_str = nickels_roll + " * $" + NICKELS_ROLL_COEFFICIENT + " = $" + nickels_roll_value_dbl;
            nickels_roll_value_tv.setText(nickels_roll_value_str);
            //
            double dimes_roll_value_dbl = dimes_roll * DIMES_ROLL_COEFFICIENT;
            TextView dimes_roll_value_tv = (TextView) findViewById(R.id.dimesRollValueTextView);
            String dimes_roll_value_str = dimes_roll + " * $" + DIMES_ROLL_COEFFICIENT + " = $" + dimes_roll_value_dbl;
            dimes_roll_value_tv.setText(dimes_roll_value_str);
            //
            double quarters_roll_value_dbl = quarters_roll * QUARTERS_ROLL_COEFFICIENT;
            TextView quarters_roll_value_tv = (TextView) findViewById(R.id.quartersRollValueTextView);
            String quarters_roll_value_str = quarters_roll + " * $" + QUARTERS_ROLL_COEFFICIENT + " = $" + quarters_roll_value_dbl;
            quarters_roll_value_tv.setText(quarters_roll_value_str);
            //
            double one_dollar_roll_value_dbl = one_dollar_roll * ONE_DOLLAR_ROLL_COEFFICIENT;
            TextView one_dollar_roll_value_tv = (TextView) findViewById(R.id.oneDollarRollValueTextView);
            String one_dollar_roll_value_str = one_dollar_roll + " * $" + ONE_DOLLAR_ROLL_COEFFICIENT + " = $" + one_dollar_roll_value_dbl;
            one_dollar_roll_value_tv.setText(one_dollar_roll_value_str);
            //
            double two_dollars_roll_value_dbl = two_dollars_roll * TWO_DOLLARS_ROLL_COEFFICIENT;
            TextView two_dollars_roll_value_tv = (TextView) findViewById(R.id.twoDollarsRollValueTextView);
            String two_dollars_roll_value_str = two_dollars_roll + " * $" + TWO_DOLLARS_ROLL_COEFFICIENT + " = $" + two_dollars_roll_value_dbl;
            two_dollars_roll_value_tv.setText(two_dollars_roll_value_str);

            double total;
            total = nickels * NICKELS_COEFFICIENT + dimes * DIMES_COEFFICIENT + quarters * QUARTERS_COEFFICIENT + one_dollar + two_dollars * TWO_DOLLARS_COEFFICIENT
                    + five_dollars * FIVE_DOLLARS_COEFFICIENT + ten_dollars * TEN_DOLLARS_COEFFICIENT + twenty_dollars * TWENTY_DOLLARS_COEFFICIENT
                    + fifty_dollars * FIFTY_DOLLARS_COEFFICIENT + one_hundred_dollars * ONE_HUNDRED_DOLLARS_COEFFICIENT + nickels_roll * NICKELS_ROLL_COEFFICIENT
                    + dimes_roll * DIMES_ROLL_COEFFICIENT + quarters_roll * QUARTERS_ROLL_COEFFICIENT + one_dollar_roll * ONE_DOLLAR_ROLL_COEFFICIENT
                    + two_dollars_roll * TWO_DOLLARS_ROLL_COEFFICIENT;

            String operation_str = "("+ nickels + " * " + NICKELS_COEFFICIENT + ") + (" + dimes + " * " + DIMES_COEFFICIENT + ") + ("
                    + quarters + " * " + QUARTERS_COEFFICIENT + ") + " + one_dollar + " + (" + two_dollars + " * " + TWO_DOLLARS_COEFFICIENT
                    + ") + (" + five_dollars + " * " + FIVE_DOLLARS_COEFFICIENT + ") + (" + ten_dollars + " * " + TEN_DOLLARS_COEFFICIENT
                    + ") + (" + twenty_dollars + " * " + TWENTY_DOLLARS_COEFFICIENT + ") + (" + fifty_dollars + " * "
                    + FIFTY_DOLLARS_COEFFICIENT + ") + (" + one_hundred_dollars + " * " + ONE_HUNDRED_DOLLARS_COEFFICIENT + ") + ("
                    + nickels_roll + " * " + NICKELS_ROLL_COEFFICIENT + ") + (" + dimes_roll + " * " + DIMES_ROLL_COEFFICIENT
                    + ") + (" + quarters_roll + " * " + QUARTERS_ROLL_COEFFICIENT + ") + (" + one_dollar_roll + " * "
                    + ONE_DOLLAR_ROLL_COEFFICIENT + ") + (" + two_dollars_roll + " * " + TWO_DOLLARS_ROLL_COEFFICIENT +")";

            TextView total_amount_tv = (TextView) findViewById(R.id.totalAmountValueTextView);
            total_amount_tv.setText("$" +total);
            TextView to_remove_tv = (TextView) findViewById(R.id.amountToRemoveValueTextView);
            double amnt_to_remove = total - BASE_REGISTER_AMOUNT;
            String sign = "";
            if(amnt_to_remove < 0)
                sign = "-";
            String amount_to_remove = number_format.format(Math.abs(amnt_to_remove));
            to_remove_tv.setText(sign + "$" + amount_to_remove);
        }catch (Exception e){
            this.toastMessage(e.toString());
        }
    }
    public void goBack(View view){
        finish();
    }
    private void toastMessage(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}
