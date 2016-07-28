package com.miind;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;


public class PaypalActivity extends AppCompatActivity implements View.OnClickListener {
    private Button pay;
    private TextView balance;
    private EditText money;
    private static final String CONFIG = PayPalConfiguration.ENVIRONMENT_NO_NETWORK;
    private static final String CLIENT_ID = "Ac9zm7Q8SGzXyxL92UjkptCvz6s9ITGSrI3jTmrg-8MdTmYH73-8rRW6rq0esh8D9OU5cPuiQdxdePQV";
    private static final int REQUEST_PAYMENT = 1;
    private static PayPalConfiguration config = new PayPalConfiguration()

            .environment(CONFIG)
            .clientId(CLIENT_ID)
            .merchantName("Make in india");

    private String WALLET_BALANCE = "wallet_balance";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paypal);

        pay = (Button) findViewById(R.id.button1);
        balance = (TextView) findViewById(R.id.wallet_balance);
        money = (EditText) findViewById(R.id.money);

        pay.setOnClickListener(this);

        Intent intent = new Intent(this, PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        startService(intent);

        int walletBalance = SharedPrefUtils.getInt(WALLET_BALANCE, 0);
        balance.setText(walletBalance + " INR");

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        switch (v.getId()) {


            case R.id.button1:
                int amount = Integer.parseInt(money.getText().toString().equals("") ? "0" : money.getText().toString());
                if (amount > 0) {
                    callPaypalActivity(amount);
                    money.setText("");
                } else {
                    Toast.makeText(MiindApp.getAppContext(), "Please enter the amount", Toast.LENGTH_LONG).show();
                }
                break;


        }

    }


    /* (non-Javadoc)
     * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub

        if (requestCode == REQUEST_PAYMENT) {

           /* Toast.makeText(getApplicationContext(), "on sucrss", Toast.LENGTH_LONG).show();*/
            if (resultCode == Activity.RESULT_OK) {

                int currentBalance = SharedPrefUtils.getInt(WALLET_BALANCE, 0);
                balance.setText(currentBalance + " INR");
                Toast.makeText(MiindApp.getAppContext(), "Added successfully", Toast.LENGTH_LONG).show();
                PaymentConfirmation confirm = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);

                if (confirm == null) {

                    try {

                        System.out.println("Responses" + confirm);

                        Log.i("PayPal Example Payments", confirm.toJSONObject().toString());

                        JSONObject obj = new JSONObject(confirm.toJSONObject().toString());


                        String paymentID = obj.getJSONObject("response").getString("id");
                        System.out.println("payment id:-==" + paymentID);

                       /* Toast.makeText(getApplicationContext(), paymentID, Toast.LENGTH_LONG).show();*/


                    } catch (JSONException e) {

                        Log.e("Payment demo", "failure occured:", e);
                    }
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                }

            } else if (requestCode == Activity.RESULT_CANCELED) {


                Log.i("Paymentdemo", "The user cancelled");
               /* Toast.makeText(getApplicationContext(), "Cancelled", Toast.LENGTH_LONG).show();*/


            } else if (requestCode == PaymentActivity.RESULT_EXTRAS_INVALID) {

                Log.i("paymentdemo", "Invalid payment Submitted");
              /*  Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_LONG).show();*/

            }


        }

    }

    public void callPaypalActivity(int addMoney) {
        PayPalPayment item = new PayPalPayment(new BigDecimal(addMoney), "USD", "Make In India", PayPalPayment.PAYMENT_INTENT_SALE);
        Intent in = new Intent(PaypalActivity.this, PaymentActivity.class);
        in.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        in.putExtra(PaymentActivity.EXTRA_PAYMENT, item);
        startActivityForResult(in, REQUEST_PAYMENT);

        int oldBalance = SharedPrefUtils.getInt(WALLET_BALANCE, 0);
        SharedPrefUtils.updateSharedPref(WALLET_BALANCE, oldBalance + addMoney);

    }

    @Override
    public void onDestroy() {
        stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
    }

}

