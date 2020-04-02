package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class DisplaySteps extends AppCompatActivity {

    Button nextStepBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_display_steps);

        nextStepBtn = (Button) findViewById(R.id.nextStepBtn);
    }

    public void nextStep(View view) {goFinishRecipeActivity();}

    public void goFinishRecipeActivity() {
        Intent intent = new Intent (this, FinishRecipe.class);
        startActivity(intent);
    }


}
