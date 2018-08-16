package com.ricardogwill.ratingbarbasics;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listenerForRatingBar();
        onSubmitButtonClickListener();
        onCloseButtonAlertDialogClickListener();
    }

    private RatingBar ratingBar;
    private TextView textView;
    private Button submitButton;
    private Button closeButton;


    public void listenerForRatingBar() {
        ratingBar = (RatingBar) findViewById(R.id.rating_bar);
        textView = (TextView) findViewById(R.id.text_view);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                textView.setText(String.valueOf(rating));
            }
        });
    }

    public void onSubmitButtonClickListener() {
        ratingBar = (RatingBar) findViewById(R.id.rating_bar);
        submitButton = (Button) findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, String.valueOf(ratingBar.getRating()), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onCloseButtonAlertDialogClickListener() {
        closeButton = (Button) findViewById(R.id.close_button);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                alertBuilder.setMessage("Do you want to close this app?").setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                });

                AlertDialog alert = alertBuilder.create();
                alert.setTitle("Alert!");
                alert.show();

            }
        });
    }

}
