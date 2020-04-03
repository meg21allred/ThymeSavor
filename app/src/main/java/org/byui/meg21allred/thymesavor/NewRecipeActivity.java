package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class NewRecipeActivity extends AppCompatActivity {

    Recipe recipe;
    SoundPool soundPool;
    int wooHooSound;


    public static final String EXTRA_ID = "org.byui.meg21allred.thymesavor.EXTRA_ID";
    public static final String EXTRA_TITLE = "org.byui.meg21allred.thymesavor.EXTRA_TITLE";
    public static final String EXTRA_INGREDIENT = "org.byui.meg21allred.thymesavor.EXTRA_IGREDIENT";
    public static final String EXTRA_AMOUNT = "org.byui.meg21allred.thymesavor.EXTRA_AMOUNT";
    public static final String EXTRA_TYPE = "org.byui.meg21allred.thymesavor.EXTRA_TYPE";
    public static final String EXTRA_STEP = "org.byui.meg21allred.thymesavor.EXTRA_STEP";
    public static final String EXTRA_RATING = "org.byui.meg21allred.thymesavor.EXTRA_RATING";


    private EditText titleET;
    private EditText enterIngredientET;
    private EditText amountET;
    private EditText typeET;
    private EditText stepET;
    private Button addIngredientBtn;
    private TextView ingredientsTV;


    Button addStepsActitivyBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_new_recipe);

        recipe = new Recipe();

        titleET = (EditText) findViewById(R.id.titleET);
        enterIngredientET = (EditText) findViewById(R.id.enterIngredientET);
        amountET = (EditText) findViewById(R.id.amountET);
        typeET = (EditText) findViewById(R.id.typeET);
        stepET = (EditText) findViewById(R.id.stepET);
        addIngredientBtn = (Button) findViewById(R.id.addIngredientBtn);
        ingredientsTV = (TextView) findViewById(R.id.ingredientsTV);
        addStepsActitivyBtn = (Button) findViewById(R.id.addStepsActivityBtn);

        soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
        wooHooSound = soundPool.load(this, R.raw.woohoo_sound, 1);

        Intent intent = getIntent();

        if(intent.hasExtra(EXTRA_ID)) {
            titleET.setText(intent.getStringExtra(EXTRA_TITLE));
            recipe.setIngredient(intent.getStringArrayListExtra(EXTRA_INGREDIENT));
            recipe.setAmount(intent.getStringArrayListExtra(EXTRA_AMOUNT));
            recipe.setType(intent.getStringArrayListExtra(EXTRA_TYPE));
            recipe.setStep(intent.getStringArrayListExtra(EXTRA_STEP));
            recipe.setRating(intent.getStringExtra(EXTRA_RATING));

        }

        final Button saveBtn = findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                soundPool.play(wooHooSound, 5,5,0,0,1);
                if (TextUtils.isEmpty(titleET.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String title = titleET.getText().toString();
                    ArrayList<String> ingredient = recipe.getIngredient();
                    ArrayList<String> amount = recipe.getAmount();
                    ArrayList<String> type = recipe.getType();
                    ArrayList<String> step = recipe.getStep();
                    String rating = "0";

                    replyIntent.putExtra(EXTRA_TITLE, title);
                    replyIntent.putStringArrayListExtra(EXTRA_INGREDIENT, ingredient);
                    replyIntent.putStringArrayListExtra(EXTRA_AMOUNT, amount);
                    replyIntent.putStringArrayListExtra(EXTRA_TYPE, type);
                    replyIntent.putStringArrayListExtra(EXTRA_STEP, step);
                    replyIntent.putExtra(EXTRA_RATING, rating);
                    //same format for the rest of the edit texts

                    int id = getIntent().getIntExtra(EXTRA_ID, -1);
                    if (id != -1) {
                        replyIntent.putExtra(EXTRA_ID, id);
                    }
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });


        }


    public void displayRecipe(View v) {
        openDisplayRecipeActivity();
    }

    public void openDisplayRecipeActivity() {

        Intent replyIntent = new Intent(this, DisplayRecipeActivity.class);
        if (TextUtils.isEmpty(titleET.getText())) {
            setResult(RESULT_CANCELED, replyIntent);
        } else {
            String title = titleET.getText().toString();
            ArrayList<String> ingredient = recipe.getIngredient();
            ArrayList<String> amount = recipe.getAmount();
            ArrayList<String> type = recipe.getType();
            ArrayList<String> step = recipe.getStep();
            String rating = "0";

            replyIntent.putExtra(EXTRA_TITLE, title);
            replyIntent.putStringArrayListExtra(EXTRA_INGREDIENT, ingredient);
            replyIntent.putStringArrayListExtra(EXTRA_AMOUNT, amount);
            replyIntent.putStringArrayListExtra(EXTRA_TYPE, type);
            replyIntent.putStringArrayListExtra(EXTRA_STEP, step);
            replyIntent.putExtra(EXTRA_RATING, rating);

            int id = getIntent().getIntExtra(EXTRA_ID, -1);
            if (id != -1) {
                replyIntent.putExtra(EXTRA_ID, id);
            }
            setResult(RESULT_OK, replyIntent);
        }
        finish();
        startActivity(replyIntent);

    }

    public void addIngredient(View view) {
        addIngredientToRecipe();

    }
    public void addIngredientToRecipe() {

        //add ingredient to recipe
        String addIngredient = enterIngredientET.getText().toString();
        String addAmount = amountET.getText().toString();
        String addType = typeET.getText().toString();

        recipe.getIngredient().add(addIngredient);
        recipe.getAmount().add(addAmount);
        recipe.getType().add(addType);
        enterIngredientET.setText("");
        amountET.setText("");
        typeET.setText("");

    }

    public void addStep(View view) {
        addStepToRecipe();

    }
    public void addStepToRecipe() {

        //add step to recipe
        String addStep = stepET.getText().toString();

        recipe.getStep().add(addStep);
        stepET.setText("");


    }

    public Recipe getRecipe(){
        return recipe;
    }
}
