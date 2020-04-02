package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
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
    //private ArrayList<String> ingredient = recipe.getIngredient();


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
    private EditText ratingDisplayEt;


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

        ratingDisplayEt = (EditText) findViewById(R.id.ratingDisplayET);
        ratingDisplayEt.setText(recipe.getRating());

        Intent intent = getIntent();

        if(intent.hasExtra(EXTRA_ID)) {
            titleET.setText(intent.getStringExtra(EXTRA_TITLE));
            //enterIngredientET.setText(intent.getStringExtra(EXTRA_INGREDIENT));
            recipe.setIngredient(intent.getStringArrayListExtra(EXTRA_INGREDIENT));
            amountET.setText(intent.getStringExtra(EXTRA_AMOUNT));
            typeET.setText(intent.getStringExtra(EXTRA_TYPE));
            stepET.setText(intent.getStringExtra(EXTRA_STEP));

        }

        final Button saveBtn = findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(titleET.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String title = titleET.getText().toString();
                    //String ingredient = enterIngredientET.getText().toString();
                    ArrayList<String> ingredient = recipe.getIngredient();
                    String amount = amountET.getText().toString();
                    String type = typeET.getText().toString();
                    String step = stepET.getText().toString();
                    replyIntent.putExtra(EXTRA_TITLE, title);
                    replyIntent.putStringArrayListExtra(EXTRA_INGREDIENT, ingredient);
                    //replyIntent.putExtra(EXTRA_INGREDIENT, ingredient);
                    replyIntent.putExtra(EXTRA_AMOUNT, amount);
                    replyIntent.putExtra(EXTRA_TYPE, type);
                    replyIntent.putExtra(EXTRA_STEP, step);
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
        openAddStepsActivity();
    }

    public void openAddStepsActivity() {

        //Intent intent = new Intent(this, DisplayRecipeActivity.class);
        Intent replyIntent = new Intent(this, DisplayRecipeActivity.class);
        if (TextUtils.isEmpty(titleET.getText())) {
            setResult(RESULT_CANCELED, replyIntent);
        } else {
            String title = titleET.getText().toString();
            //String ingredient = enterIngredientET.getText().toString();
            ArrayList<String> ingredient = recipe.getIngredient();
            String amount = amountET.getText().toString();
            String type = typeET.getText().toString();
            String step = stepET.getText().toString();
            replyIntent.putExtra(EXTRA_TITLE, title);
            replyIntent.putStringArrayListExtra(EXTRA_INGREDIENT, ingredient);
            //replyIntent.putExtra(EXTRA_INGREDIENT, ingredient)
            replyIntent.putExtra(EXTRA_AMOUNT, amount);
            replyIntent.putExtra(EXTRA_TYPE, type);
            replyIntent.putExtra(EXTRA_STEP, step);

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

        String addIngredient = enterIngredientET.getText().toString();
        recipe.getIngredient().add(addIngredient);   // would this work to add the ingredient if I changed String ingredient
                                                // to ArrayList<String> ingredient?

    }


}
