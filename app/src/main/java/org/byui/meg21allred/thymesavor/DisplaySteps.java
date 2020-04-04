package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
//This class is used to display the steps of the ingredients one at a time
public class DisplaySteps extends AppCompatActivity {

    Button nextStepBtn;
    TextView ingredientsTV;
    TextView stepTV;
    ArrayList <String> stepList = new ArrayList<>();
    int stepNumber = 0;
    NewRecipeActivity newRecipe;
    Recipe recipe;
    SoundPool soundPool;
    int yaySound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_display_steps);

        nextStepBtn = (Button) findViewById(R.id.nextStepBtn);
        ingredientsTV = (TextView) findViewById(R.id.ingredientsTV);
        stepTV = (TextView) findViewById(R.id.stepTV);

        soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
        yaySound = soundPool.load(this, R.raw.yay_sound, 1);

        //retreive data from last activity
        Intent intent = getIntent();

        String ingredientList = intgredientList(intent);
        String stepOne = stepList(intent);
        ingredientsTV.setText(ingredientList);
        stepTV.setText(stepOne);


    }

    //This function displays the ingredients a the top of the screen
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

    //this function assigns the step arrayList to steplist arrayList so the steps can be accessed
    public String stepList(Intent intent) {
        stepList = intent.getStringArrayListExtra(newRecipe.EXTRA_STEP);

        return stepList.get(0);
    }

    public void nextStep(View view) {goFinishRecipeActivity();}

    //this function using a button to go through the steps of the recipe and then changes the button
    //to a finish function when there are no steps left, the finish button starts the next activity
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
                    //include a "yay" sound onClick
                    soundPool.play(yaySound, 4,4,0,0,1);
                    String rating = "0";

                    intent.putExtra(newRecipe.EXTRA_RATING,rating);
                    startActivity(intent);
                }
            });
        }

    }


}
