package org.byui.meg21allred.thymesavor;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RatingActivity extends AppCompatActivity {

    private EditText enterRateEt;
    int rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        //setContentView(R.layout.activity_rating);

        //enterRateEt = (EditText) findViewById(R.id.enterRateET);
        rating = 0;

    }

    public void setRating() {
        rating = Integer.valueOf(enterRateEt.getText().toString());
    }


    public void clearMessage(View view) {
        enterRateEt.setText("");
    }
}
