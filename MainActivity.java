package liveandtouch.com.cashregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private RegisterCountDBHelper register_helper;
    private final int RESULT_ACTIVITY_VALUE = 1;
    private final int HISTORY_ACTIVITY_VALUE = 2;
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
        setContentView(R.layout.activity_main);

        //Add listeners
        EditText nickels_et = (EditText) findViewById(R.id.nickelsEditText);
        addListenerToEditText(nickels_et);
        EditText dimes_et = (EditText) findViewById(R.id.dimesEditText);
        addListenerToEditText(dimes_et);
        EditText quarters_et = (EditText) findViewById(R.id.quartersEditText);
        addListenerToEditText(quarters_et);
        EditText one_dollar_et = (EditText) findViewById(R.id.oneDollarEditText);
        addListenerToEditText(one_dollar_et);
        EditText two_dollars_et = (EditText) findViewById(R.id.twoDollarsEditText);
        addListenerToEditText(two_dollars_et);
        EditText five_dollars_et = (EditText) findViewById(R.id.fiveDollarsEditText);
        addListenerToEditText(five_dollars_et);
        EditText ten_dollars_et = (EditText) findViewById(R.id.tenDollarsEditText);
        addListenerToEditText(ten_dollars_et);
        EditText twenty_dollars_et = (EditText) findViewById(R.id.twentyDollarsEditText);
        addListenerToEditText(twenty_dollars_et);
        EditText fifty_dollars_et = (EditText) findViewById(R.id.fiftyDollarsEditText);
        addListenerToEditText(fifty_dollars_et);
        EditText one_hundred_dollars_et = (EditText) findViewById(R.id.oneHundredDollarsEditText);
        addListenerToEditText(one_hundred_dollars_et);
        EditText nickels_roll_et = (EditText) findViewById(R.id.nickelsRollEditText);
        addListenerToEditText(nickels_roll_et);
        EditText dimes_roll_et = (EditText) findViewById(R.id.dimesRollEditText);
        addListenerToEditText(dimes_roll_et);
        EditText quarters_roll_et = (EditText) findViewById(R.id.quartersRollEditText);
        addListenerToEditText(quarters_roll_et);
        EditText one_dollar_roll_et = (EditText) findViewById(R.id.oneDollarRollEditText);
        addListenerToEditText(one_dollar_roll_et);
        EditText two_dollars_roll_et = (EditText) findViewById(R.id.twoDollarsRollEditText);
        addListenerToEditText(two_dollars_roll_et);

        register_helper = new RegisterCountDBHelper(MainActivity.this);
        register_helper.loadTables();
    }

    public void addListenerToEditText(EditText et){
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                computeTotalAmount();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void computeTotal(View view){
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        Bundle extras = new Bundle();

        EditText nickels_et = (EditText) findViewById(R.id.nickelsEditText);
        String nickels = nickels_et.getText().toString().trim();
        EditText dimes_et = (EditText) findViewById(R.id.dimesEditText);
        String dimes = dimes_et.getText().toString().trim();
        EditText quarters_et = (EditText) findViewById(R.id.quartersEditText);
        String quarters = quarters_et.getText().toString().trim();
        EditText one_dollar_et = (EditText) findViewById(R.id.oneDollarEditText);
        String one_dollar = one_dollar_et.getText().toString().trim();
        EditText two_dollars_et = (EditText) findViewById(R.id.twoDollarsEditText);
        String two_dollars = two_dollars_et.getText().toString().trim();
        EditText five_dollars_et = (EditText) findViewById(R.id.fiveDollarsEditText);
        String five_dollars = five_dollars_et.getText().toString().trim();
        EditText ten_dollars_et = (EditText) findViewById(R.id.tenDollarsEditText);
        String ten_dollars = ten_dollars_et.getText().toString().trim();
        EditText twenty_dollars_et = (EditText) findViewById(R.id.twentyDollarsEditText);
        String twenty_dollars = twenty_dollars_et.getText().toString().trim();
        EditText fifty_dollars_et = (EditText) findViewById(R.id.fiftyDollarsEditText);
        String fifty_dollars = fifty_dollars_et.getText().toString().trim();
        EditText one_hundred_dollars_et = (EditText) findViewById(R.id.oneHundredDollarsEditText);
        String one_hundred_dollars = one_hundred_dollars_et.getText().toString().trim();
        EditText nickels_roll_et = (EditText) findViewById(R.id.nickelsRollEditText);
        String nickels_roll = nickels_roll_et.getText().toString().trim();
        EditText dimes_roll_et = (EditText) findViewById(R.id.dimesRollEditText);
        String dimes_roll = dimes_roll_et.getText().toString().trim();
        EditText quarters_roll_et = (EditText) findViewById(R.id.quartersRollEditText);
        String quarters_roll = quarters_roll_et.getText().toString().trim();
        EditText one_dollar_roll_et = (EditText) findViewById(R.id.oneDollarRollEditText);
        String one_dollar_roll = one_dollar_roll_et.getText().toString().trim();
        EditText two_dollars_roll_et = (EditText) findViewById(R.id.twoDollarsRollEditText);
        String two_dollars_roll = two_dollars_roll_et.getText().toString().trim();

        extras.putString(NICKELS, nickels);
        extras.putString(DIMES, dimes);
        extras.putString(QUARTERS, quarters);
        extras.putString(ONE_DOLLAR, one_dollar);
        extras.putString(TWO_DOLLARS, two_dollars);
        extras.putString(FIVE_DOLLARS, five_dollars);
        extras.putString(TEN_DOLLARS, ten_dollars);
        extras.putString(TWENTY_DOLLARS, twenty_dollars);
        extras.putString(FIFTY_DOLLARS, fifty_dollars);
        extras.putString(ONE_HUNDRED_DOLLARS, one_hundred_dollars);
        extras.putString(NICKELS_ROLL, nickels_roll);
        extras.putString(DIMES_ROLL, dimes_roll);
        extras.putString(QUARTERS_ROLL, quarters_roll);
        extras.putString(ONE_DOLLAR_ROLL, one_dollar_roll);
        extras.putString(TWO_DOLLARS_ROLL, two_dollars_roll);

        //Save data to database
        saveToDatabase(nickels, dimes, quarters, one_dollar, two_dollars,
                nickels_roll, dimes_roll, quarters_roll, one_dollar_roll,
                two_dollars_roll, five_dollars, ten_dollars, twenty_dollars,
                fifty_dollars, one_hundred_dollars);

        //Load Result page
        intent.putExtras(extras);
        startActivityForResult(intent, RESULT_ACTIVITY_VALUE);
    }
    public void saveToDatabase(String nickels_str, String dimes_str, String quarters_str, String one_dollar_str, String two_dollars_str,
                               String nickels_roll_str, String dimes_roll_str, String quarters_roll_str, String one_dollar_roll_str,
                               String two_dollars_roll_str, String five_dollars_str, String ten_dollars_str, String twenty_dollars_str,
                               String fifty_dollars_str, String one_hundred_dollars_str){
        //get int and double equivalent of values
        double nickels = 0.00;
        double dimes = 0.00;
        double quarters = 0.00;
        int one_dollar = 0;
        int two_dollars = 0;
        int five_dollars = 0;
        int ten_dollars = 0;
        int twenty_dollars = 0;
        int fifty_dollars = 0;
        int one_hundred_dollars = 0;
        double nickels_roll = 0.00;
        double dimes_roll = 0.00;
        double quarters_roll = 0.00;
        int one_dollar_roll = 0;
        int two_dollars_roll = 0;
        if(!nickels_str.equals("")){
            nickels = Double.parseDouble(nickels_str);
        }
        if(!dimes_str.equals("")){
            dimes = Double.parseDouble(dimes_str);
        }
        if(!quarters_str.equals("")){
            quarters = Double.parseDouble(quarters_str);
        }
        if(!one_dollar_str.equals("")){
            one_dollar = Integer.parseInt(one_dollar_str);
        }
        if(!two_dollars_str.equals("")){
            two_dollars = Integer.parseInt(two_dollars_str);
        }
        if(!five_dollars_str.equals("")){
            five_dollars = Integer.parseInt(five_dollars_str);
        }
        if(!ten_dollars_str.equals("")){
            ten_dollars = Integer.parseInt(ten_dollars_str);
        }
        if(!twenty_dollars_str.equals("")){
            twenty_dollars = Integer.parseInt(twenty_dollars_str);
        }
        if(!fifty_dollars_str.equals("")){
            fifty_dollars = Integer.parseInt(fifty_dollars_str);
        }
        if(!one_hundred_dollars_str.equals("")){
            one_hundred_dollars = Integer.parseInt(one_hundred_dollars_str);
        }
        if(!nickels_roll_str.equals("")){
            nickels_roll = Double.parseDouble(nickels_roll_str);
        }
        if(!dimes_roll_str.equals("")){
            dimes_roll = Double.parseDouble(dimes_roll_str);
        }
        if(!quarters_roll_str.equals("")){
            quarters_roll = Double.parseDouble(quarters_roll_str);
        }
        if(!one_dollar_roll_str.equals("")){
            one_dollar_roll = Integer.parseInt(one_dollar_roll_str);
        }
        if(!two_dollars_roll_str.equals("")){
            two_dollars_roll = Integer.parseInt(two_dollars_roll_str);
        }

        Date current_time = Calendar.getInstance().getTime();
        String date = current_time.toString();
        register_helper.saveComputation(nickels, dimes, quarters, one_dollar, two_dollars,
                nickels_roll, dimes_roll, quarters_roll, one_dollar_roll,
                two_dollars_roll, five_dollars, ten_dollars, twenty_dollars,
                fifty_dollars, one_hundred_dollars, date);
    }
    public void dropTable(View view){
        register_helper.dropComputationsTable();
    }
    public void clearEntries(View view){
        EditText nickels_et = (EditText) findViewById(R.id.nickelsEditText);
        nickels_et.setText("");
        EditText dimes_et = (EditText) findViewById(R.id.dimesEditText);
        dimes_et.setText("");
        EditText quarters_et = (EditText) findViewById(R.id.quartersEditText);
        quarters_et.setText("");
        EditText one_dollar_et = (EditText) findViewById(R.id.oneDollarEditText);
        one_dollar_et.setText("");
        EditText two_dollars_et = (EditText) findViewById(R.id.twoDollarsEditText);
        two_dollars_et.setText("");
        EditText five_dollars_et = (EditText) findViewById(R.id.fiveDollarsEditText);
        five_dollars_et.setText("");
        EditText ten_dollars_et = (EditText) findViewById(R.id.tenDollarsEditText);
        ten_dollars_et.setText("");
        EditText twenty_dollars_et = (EditText) findViewById(R.id.twentyDollarsEditText);
        twenty_dollars_et.setText("");
        EditText fifty_dollars_et = (EditText) findViewById(R.id.fiftyDollarsEditText);
        fifty_dollars_et.setText("");
        EditText one_hundred_dollars_et = (EditText) findViewById(R.id.oneHundredDollarsEditText);
        one_hundred_dollars_et.setText("");
        EditText nickels_roll_et = (EditText) findViewById(R.id.nickelsRollEditText);
        nickels_roll_et.setText("");
        EditText dimes_roll_et = (EditText) findViewById(R.id.dimesRollEditText);
        dimes_roll_et.setText("");
        EditText quarters_roll_et = (EditText) findViewById(R.id.quartersRollEditText);
        quarters_roll_et.setText("");
        EditText one_dollar_roll_et = (EditText) findViewById(R.id.oneDollarRollEditText);
        one_dollar_roll_et.setText("");
        EditText two_dollars_roll_et = (EditText) findViewById(R.id.twoDollarsRollEditText);
        two_dollars_roll_et.setText("");
        resetDisplayTotals();
    }
    public void resetDisplayTotals(){
        TextView total_amount_tv = (TextView) findViewById(R.id.totalAmountButton);
        total_amount_tv.setText("$0.00");
        TextView to_remove_tv = (TextView) findViewById(R.id.amountToRemove1TextView);
        to_remove_tv.setText("");
    }
    public void computeTotalAmount(){
        try{
            //Get values from editText
            EditText nickels_et = (EditText) findViewById(R.id.nickelsEditText);
            String nickels_str = nickels_et.getText().toString().trim();
            EditText dimes_et = (EditText) findViewById(R.id.dimesEditText);
            String dimes_str = dimes_et.getText().toString().trim();
            EditText quarters_et = (EditText) findViewById(R.id.quartersEditText);
            String quarters_str = quarters_et.getText().toString().trim();
            EditText one_dollar_et = (EditText) findViewById(R.id.oneDollarEditText);
            String one_dollar_str = one_dollar_et.getText().toString().trim();
            EditText two_dollars_et = (EditText) findViewById(R.id.twoDollarsEditText);
            String two_dollars_str = two_dollars_et.getText().toString().trim();
            EditText five_dollars_et = (EditText) findViewById(R.id.fiveDollarsEditText);
            String five_dollars_str = five_dollars_et.getText().toString().trim();
            EditText ten_dollars_et = (EditText) findViewById(R.id.tenDollarsEditText);
            String ten_dollars_str = ten_dollars_et.getText().toString().trim();
            EditText twenty_dollars_et = (EditText) findViewById(R.id.twentyDollarsEditText);
            String twenty_dollars_str = twenty_dollars_et.getText().toString().trim();
            EditText fifty_dollars_et = (EditText) findViewById(R.id.fiftyDollarsEditText);
            String fifty_dollars_str = fifty_dollars_et.getText().toString().trim();
            EditText one_hundred_dollars_et = (EditText) findViewById(R.id.oneHundredDollarsEditText);
            String one_hundred_dollars_str = one_hundred_dollars_et.getText().toString().trim();
            EditText nickels_roll_et = (EditText) findViewById(R.id.nickelsRollEditText);
            String nickels_roll_str = nickels_roll_et.getText().toString().trim();
            EditText dimes_roll_et = (EditText) findViewById(R.id.dimesRollEditText);
            String dimes_roll_str = dimes_roll_et.getText().toString().trim();
            EditText quarters_roll_et = (EditText) findViewById(R.id.quartersRollEditText);
            String quarters_roll_str = quarters_roll_et.getText().toString().trim();
            EditText one_dollar_roll_et = (EditText) findViewById(R.id.oneDollarRollEditText);
            String one_dollar_roll_str = one_dollar_roll_et.getText().toString().trim();
            EditText two_dollars_roll_et = (EditText) findViewById(R.id.twoDollarsRollEditText);
            String two_dollars_roll_str = two_dollars_roll_et.getText().toString().trim();

            //get int and double equivalent of values
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

            if(!nickels_str.equals("")){
                nickels = Integer.parseInt(nickels_str);
            }
            if(!dimes_str.equals("")){
                dimes = Integer.parseInt(dimes_str);
            }
            if(!quarters_str.equals("")){
                quarters = Integer.parseInt(quarters_str);
            }
            if(!one_dollar_str.equals("")){
                one_dollar = Integer.parseInt(one_dollar_str);
            }
            if(!two_dollars_str.equals("")){
                two_dollars = Integer.parseInt(two_dollars_str);
            }
            if(!five_dollars_str.equals("")){
                five_dollars = Integer.parseInt(five_dollars_str);
            }
            if(!ten_dollars_str.equals("")){
                ten_dollars = Integer.parseInt(ten_dollars_str);
            }
            if(!twenty_dollars_str.equals("")){
                twenty_dollars = Integer.parseInt(twenty_dollars_str);
            }
            if(!fifty_dollars_str.equals("")){
                fifty_dollars = Integer.parseInt(fifty_dollars_str);
            }
            if(!one_hundred_dollars_str.equals("")){
                one_hundred_dollars = Integer.parseInt(one_hundred_dollars_str);
            }
            if(!nickels_roll_str.equals("")){
                nickels_roll = Integer.parseInt(nickels_roll_str);
            }
            if(!dimes_roll_str.equals("")){
                dimes_roll = Integer.parseInt(dimes_roll_str);
            }
            if(!quarters_roll_str.equals("")){
                quarters_roll = Integer.parseInt(quarters_roll_str);
            }
            if(!one_dollar_roll_str.equals("")){
                one_dollar_roll = Integer.parseInt(one_dollar_roll_str);
            }
            if(!two_dollars_roll_str.equals("")){
                two_dollars_roll = Integer.parseInt(two_dollars_roll_str);
            }

            DecimalFormat number_format = new DecimalFormat("#.00");
            double total;
            total = nickels * NICKELS_COEFFICIENT + dimes * DIMES_COEFFICIENT + quarters * QUARTERS_COEFFICIENT + one_dollar + two_dollars * TWO_DOLLARS_COEFFICIENT
                    + five_dollars * FIVE_DOLLARS_COEFFICIENT + ten_dollars * TEN_DOLLARS_COEFFICIENT + twenty_dollars * TWENTY_DOLLARS_COEFFICIENT
                    + fifty_dollars * FIFTY_DOLLARS_COEFFICIENT + one_hundred_dollars * ONE_HUNDRED_DOLLARS_COEFFICIENT + nickels_roll * NICKELS_ROLL_COEFFICIENT
                    + dimes_roll * DIMES_ROLL_COEFFICIENT + quarters_roll * QUARTERS_ROLL_COEFFICIENT + one_dollar_roll * ONE_DOLLAR_ROLL_COEFFICIENT
                    + two_dollars_roll * TWO_DOLLARS_ROLL_COEFFICIENT;
            String total_amount_str = number_format.format(total);

            TextView operation_tv = (TextView) findViewById(R.id.operationMainTextView);
            String operation_str = "("+ nickels + " * " + NICKELS_COEFFICIENT + ") + (" + dimes + " * " + DIMES_COEFFICIENT + ") + ("
                    + quarters + " * " + QUARTERS_COEFFICIENT + ") + " + one_dollar + " + (" + two_dollars + " * " + TWO_DOLLARS_COEFFICIENT
                    + ") + (" + five_dollars + " * " + FIVE_DOLLARS_COEFFICIENT + ") + (" + ten_dollars + " * " + TEN_DOLLARS_COEFFICIENT
                    + ") + (" + twenty_dollars + " * " + TWENTY_DOLLARS_COEFFICIENT + ") + (" + fifty_dollars + " * "
                    + FIFTY_DOLLARS_COEFFICIENT + ") + (" + one_hundred_dollars + " * " + ONE_HUNDRED_DOLLARS_COEFFICIENT + ") + ("
                    + nickels_roll + " * " + NICKELS_ROLL_COEFFICIENT + ") + (" + dimes_roll + " * " + DIMES_ROLL_COEFFICIENT
                    + ") + (" + quarters_roll + " * " + QUARTERS_ROLL_COEFFICIENT + ") + (" + one_dollar_roll + " * "
                    + ONE_DOLLAR_ROLL_COEFFICIENT + ") + (" + two_dollars_roll + " * " + TWO_DOLLARS_ROLL_COEFFICIENT +") = $"+ total_amount_str;
            operation_tv.setText(operation_str);

            TextView total_amount_tv = (TextView) findViewById(R.id.totalAmountButton);
            total_amount_tv.setText("$" +total_amount_str);
            TextView to_remove_tv = (TextView) findViewById(R.id.amountToRemove1TextView);
            double amnt_to_remove = total - BASE_REGISTER_AMOUNT;
            String sign= "";
            if(amnt_to_remove < 0)
                sign = "-";
            String amount_to_remove = number_format.format(Math.abs(amnt_to_remove));
            to_remove_tv.setText(sign + "$" + amount_to_remove);
        }catch (Exception e){
            //this.toastMessage(e.toString());
        }
    }
    public void openHistory(View view){
        Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
        startActivityForResult(intent, HISTORY_ACTIVITY_VALUE);
    }
    private void toastMessage(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}
