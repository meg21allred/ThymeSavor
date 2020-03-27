package org.byui.meg21allred.thymesavor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {

    private final LayoutInflater inflater;
    private List<Recipe> recipes; // Cached copy of recipes

    private static ClickListener clickListener;

    RecipeListAdapter(Context context) {inflater = LayoutInflater.from(context);}

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new RecipeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        if (recipes != null) {
            Recipe current = recipes.get(position);
            holder.recipeItemView.setText(current.getTitle());
            //you would need to setText for the rate variable her as well
            //holder.recipeRateIV.setText(String.valueOf(currentRecipe.getRating()));
        } else {
            holder.recipeItemView.setText("No Title");
            //holder.recipeRateIV.setText(String.valueOf("0"));

        }

    }

    void setRecipes(List<Recipe> pRecipes) {
        recipes = pRecipes;
        notifyDataSetChanged();
    }

    public Recipe getRecipeAt(int postion) {
        return recipes.get(postion);
    }

    @Override
    public int getItemCount() {
        if (recipes != null) {
            return recipes.size();
        } else {
            return 0;
        }
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder {
        public final TextView recipeItemView;

        //if you want to add a rateing to the title you would do it here
        //remember to add a text view in the recycler view layout file

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            recipeItemView = itemView.findViewById(R.id.textView);
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        RecipeListAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(View v, int position);
    }
}
