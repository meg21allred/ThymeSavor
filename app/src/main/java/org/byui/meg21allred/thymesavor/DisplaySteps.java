package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplaySteps extends AppCompatActivity {

    Button nextStepBtn;
    TextView ingredientsTV;
    TextView stepTV;
    ArrayList <String> stepList = new ArrayList<>();
    int stepNumber = 0;
    NewRecipeActivity newRecipe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_display_steps);

        nextStepBtn = (Button) findViewById(R.id.nextStepBtn);
        ingredientsTV = (TextView) findViewById(R.id.ingredientsTV);
        stepTV = (TextView) findViewById(R.id.stepTV);

        Intent intent = getIntent();

        String ingredientList = intgredientList(intent);
        String stepOne = stepList(intent);
        ingredientsTV.setText(ingredientList);
        stepTV.setText(stepOne);


    }

    public String intgredientList(Intent intent) {

        ArrayList<String> amount = intent.getStringArrayListExtra(newRecipe.EXTRA_AMOUNT);
        ArrayList<String> ingredient = intent.getStringArrayListExtra(newRecipe.EXTRA_INGREDIENT);
        ArrayList<String> type = intent.getStringArrayListExtra(newRecipe.EXTRA_TYPE);

        String ingredientList = "";
        for (int i = 0; i < ingredient.size(); i++) {
            ingredientList += amount.get(i) + " " + type.get(i) + " " + ingredient.get(i) + "\n";
        }

       return ingredientList;
    }

    public String stepList(Intent intent) {
        stepList = intent.getStringArrayListExtra(newRecipe.EXTRA_STEP);
        /*stepList.add("boil water");
        stepList.add("add pasta");
        stepList.add("boil pasta for 8 min");
        stepList.add("drain pasta, add cheese and milk and stir until cheese disolves");
        stepList.add("Enjoy!");*/

        return stepList.get(0);
    }

    public void nextStep(View view) {goFinishRecipeActivity();}

    public void goFinishRecipeActivity() {

        if(stepNumber < stepList.size() - 1) {
            stepNumber++;
            stepTV.setText(stepList.get(stepNumber));

        } else {
            nextStepBtn.setText("Finish");
            stepNumber = 0;
            nextStepBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DisplaySteps.this, FinishRecipe.class);
                    startActivity(intent);
                }
            });
        }

    }
}
