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

import java.util.List;

public class NewRecipeActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "org.byui.meg21allred.thymesavor.REPLY";

    private EditText titleET;
    private EditText enterIngredientET;
    private Button addIngredientBtn;
    private TextView ingredientsTV;

    Button addStepsActitivyBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_new_recipe);

        titleET = (EditText) findViewById(R.id.titleET);
        enterIngredientET = (EditText) findViewById(R.id.enterIngredientET);
        addIngredientBtn = (Button) findViewById(R.id.addIngredientBtn);
        ingredientsTV = (TextView) findViewById(R.id.ingredientsTV);
        addStepsActitivyBtn = (Button) findViewById(R.id.addStepsActivityBtn);

        final Button button = findViewById(R.id.finishBtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(titleET.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = titleET.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, word);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });


        }


    /*public void finishRecipe(View v) {
        openAddStepsActivity();
    }

    public void openAddStepsActivity() {
        Intent intent = new Intent(this, DisplayRecipeActivity.class);
        startActivity(intent);

    }*/
}
