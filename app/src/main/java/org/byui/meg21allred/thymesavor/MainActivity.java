package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button enterNewRecipeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterNewRecipeBtn = (Button) findViewById(R.id.enterNewRecipeBtn);
    }

    public void newRecipe(View v) {
        openNewRecipeActivity();
    }

    public void openNewRecipeActivity() {
        Intent intent = new Intent(this, NewRecipeActivity.class);
        startActivity(intent);

    }
}
