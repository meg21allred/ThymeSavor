package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayRecipeActivity extends AppCompatActivity {

    Button startCookingBtn;
    TextView recipeTV;
    NewRecipeActivity newRecipe;


    Button addImageBtn;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_display_recipe);

        startCookingBtn = (Button) findViewById(R.id.startCookingBtn);
        recipeTV = (TextView) findViewById(R.id.recipeTV);

        Intent intent = getIntent();

        if(intent.hasExtra(newRecipe.EXTRA_ID)) {

            String fullRecipe = fullRecipe(intent);
            recipeTV.setText(fullRecipe);
            fullRecipe(intent);

        }

        addImageBtn = (Button) findViewById(R.id.addImageBtn);
        imageView = (ImageView) findViewById(R.id.recipeImageIV);

        addImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);
    }


    public void displaySteps(View view) { startDisplayStepsActivity();}

    public void startDisplayStepsActivity() {
        Intent intent = new Intent(this, DisplaySteps.class);
        startActivity(intent);
    }

    public String fullRecipe(Intent intent) {
        String title = intent.getStringExtra(newRecipe.EXTRA_TITLE);
        //String amount = intent.getStringExtra(newRecipe.EXTRA_AMOUNT);
        ArrayList<String> amount = intent.getStringArrayListExtra(newRecipe.EXTRA_AMOUNT);
        ArrayList<String> ingredient = intent.getStringArrayListExtra(newRecipe.EXTRA_INGREDIENT);
        ArrayList<String> type = intent.getStringArrayListExtra(newRecipe.EXTRA_TYPE);
        ArrayList<String> step = intent.getStringArrayListExtra(newRecipe.EXTRA_STEP);
        //ArrayList<String> ingredient = new ArrayList<>();
        //String ingredient = intent.getStringExtra(newRecipe.EXTRA_INGREDIENT);
        //String type = intent.getStringExtra(newRecipe.EXTRA_TYPE);
        //String step = intent.getStringExtra(newRecipe.EXTRA_STEP);

        //fullRecipe = title + "\n\n" + amount + " " + type + " " + ingredient + "\n\n" + step;
        //fullRecipe = "Mac and Cheese";

        String fullRecipe = title + "\n\n\n";
        for (int i = 0; i < ingredient.size(); i++) {
            fullRecipe += amount.get(i) + " " + type.get(i) + " " + ingredient.get(i) + "\n";
        }

        fullRecipe += "\n";

        for (int i = 0; i < step.size(); i++) {
            fullRecipe += (i+1) + ". " + step.get(i) + "\n\n";
        }

        return fullRecipe;
    }
}
