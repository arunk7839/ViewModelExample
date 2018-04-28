package com.example.lenovo.viewmodelexample;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnIncreaseCoffee, btnDecreaseCoffee, btnIncreaseTea, btnIncreaseColddrink, btnDecreaseTea, btnDecreaseColddrink;
    Button btnOrder;
    TextView noOfCoffee, noOfTea, noOfColddrink;
    OrderViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIncreaseCoffee = (Button) findViewById(R.id.btn_increase_coffee);
        btnDecreaseCoffee = (Button) findViewById(R.id.btn_decrease_coffee);

        btnIncreaseTea = (Button) findViewById(R.id.btn_increase_tea);
        btnDecreaseTea = (Button) findViewById(R.id.btn_decrease_tea);

        btnIncreaseColddrink = (Button) findViewById(R.id.btn_increase_colddrink);
        btnDecreaseColddrink = (Button) findViewById(R.id.btn_decrease_colddrink);

        btnOrder = (Button) findViewById(R.id.btn_order);

        noOfCoffee = (TextView) findViewById(R.id.tv_no_ofcoffee);
        noOfTea = (TextView) findViewById(R.id.tv_no_oftea);
        noOfColddrink = (TextView) findViewById(R.id.tv_no_ofcolddrink);

        //adding listener
        btnIncreaseCoffee.setOnClickListener(this);
        btnDecreaseCoffee.setOnClickListener(this);
        btnIncreaseTea.setOnClickListener(this);
        btnDecreaseTea.setOnClickListener(this);
        btnIncreaseColddrink.setOnClickListener(this);
        btnDecreaseColddrink.setOnClickListener(this);
        btnOrder.setOnClickListener(this);


        mViewModel = ViewModelProviders.of(this).get(OrderViewModel.class);
        displayNoOfCoffee(mViewModel.orderedCoffee);
        displayNoOfTea(mViewModel.orderedTea);
        displayNoOfColddrink(mViewModel.orderedColddrink);

    }

    public void displayNoOfCoffee(int coffee) {

        noOfCoffee.setText(coffee + "");
    }

    public void displayNoOfTea(int tea) {
        noOfTea.setText(tea + "");
    }

    public void displayNoOfColddrink(int colddrink) {
        noOfColddrink.setText(colddrink + "");
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_increase_coffee: {
                mViewModel.orderedCoffee = mViewModel.orderedCoffee + 1;
                displayNoOfCoffee(mViewModel.orderedCoffee);
                break;
            }
            case R.id.btn_decrease_coffee: {
                if (mViewModel.orderedCoffee > 0) {
                    mViewModel.orderedCoffee = mViewModel.orderedCoffee - 1;
                    displayNoOfCoffee(mViewModel.orderedCoffee);
                }
                break;
            }
            case R.id.btn_increase_tea: {
                mViewModel.orderedTea = mViewModel.orderedTea + 1;
                displayNoOfTea(mViewModel.orderedTea);
                break;
            }
            case R.id.btn_decrease_tea: {
                if (mViewModel.orderedTea > 0) {
                    mViewModel.orderedTea = mViewModel.orderedTea - 1;
                    displayNoOfTea(mViewModel.orderedTea);
                }
                break;
            }
            case R.id.btn_increase_colddrink: {
                mViewModel.orderedColddrink = mViewModel.orderedColddrink + 1;
                displayNoOfColddrink(mViewModel.orderedColddrink);
                break;
            }
            case R.id.btn_decrease_colddrink: {
                if (mViewModel.orderedColddrink > 0) {
                    mViewModel.orderedColddrink = mViewModel.orderedColddrink - 1;
                    displayNoOfColddrink(mViewModel.orderedColddrink);
                }
                break;
            }
            case R.id.btn_order: {
                Toast.makeText(this, "\n" + mViewModel.orderedCoffee + " " + "Coffee" + "\n" + mViewModel.orderedTea + " " + "Tea" + "\n" +
                        mViewModel.orderedColddrink + " " + "Colddrink" + "\n", Toast.LENGTH_LONG).show();
                break;
            }

        }

    }
}
