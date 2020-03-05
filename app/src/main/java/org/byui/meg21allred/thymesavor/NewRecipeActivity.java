package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewRecipeActivity extends AppCompatActivity {

    Button addStepsActitivyBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);

        addStepsActitivyBtn = (Button) findViewById(R.id.addStepsActivityBtn);
    }

    public void addSteps(View v) {
        openAddStepsActivity();
    }

    public void openAddStepsActivity() {
        Intent intent = new Intent(this, AddStepsActivity.class);
        startActivity(intent);

    }
}
