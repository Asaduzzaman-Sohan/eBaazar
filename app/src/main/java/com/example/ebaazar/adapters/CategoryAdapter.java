package com.example.ebaazar.adapters;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ebaazar.R;
import com.example.ebaazar.databinding.ItemCatagoriesBinding;
import com.example.ebaazar.model.Category;

import java.util.ArrayList;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{
     Context context;
     ArrayList<Category> categories;

     public CategoryAdapter(Context context, ArrayList<Category> categories){
         this.context = context;
         this.categories = categories;
     }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.item_catagories, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
         Category category = categories.get(position);
         holder.binding.label.setText(Html.fromHtml(category.getName()));
         Glide.with(context).load(category.getIcon()).into(holder.binding.image);

         holder.binding.image.setBackgroundColor(Color.parseColor(category.getColor()));

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class  CategoryViewHolder extends RecyclerView.ViewHolder{
        ItemCatagoriesBinding binding;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemCatagoriesBinding.bind(itemView);

        }
    }

}
