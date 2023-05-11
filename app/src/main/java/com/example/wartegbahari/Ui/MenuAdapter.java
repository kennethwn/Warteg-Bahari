package com.example.wartegbahari.Ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wartegbahari.Data.ArrayMenuModel;
import com.example.wartegbahari.Data.MenuModel;
import com.example.wartegbahari.R;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
  private ArrayMenuModel arrayMenuModel;
  private Context context;
  private final RecyclerViewInterface recyclerViewInterface;

  public MenuAdapter(ArrayMenuModel arrayMenuModel, Context context, RecyclerViewInterface recyclerViewInterface) {
    this.arrayMenuModel = arrayMenuModel;
    this.context = context;
    this.recyclerViewInterface = recyclerViewInterface;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_list, parent, false);
    return new ViewHolder(view, recyclerViewInterface);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    MenuModel menu = ArrayMenuModel.getInstance().get(position);
    holder.foodSrc.setImageResource(menu.getImage());
    holder.foodTitleTxt.setText(menu.getTitle());
    holder.foodDescTxt.setText(menu.getDesc());
    holder.foodPriceTxt.setText("Rp" + String.valueOf(menu.getPrice()));
  }

  @Override
  public int getItemCount() {
    return ArrayMenuModel.getInstance().size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView foodSrc;
    public TextView foodTitleTxt;
    public TextView foodDescTxt;
    public TextView foodPriceTxt;

    public ViewHolder(View itemView, RecyclerViewInterface recyclerViewInterface) {
      super(itemView);
      foodSrc = itemView.findViewById(R.id.foodImage);
      foodTitleTxt = itemView.findViewById(R.id.foodTitle);
      foodDescTxt = itemView.findViewById(R.id.foodNotes);
      foodPriceTxt = itemView.findViewById(R.id.foodPrice);

      itemView.setOnClickListener(v -> {
        if(recyclerViewInterface != null) {
          int pos = getAdapterPosition();
          if (pos != RecyclerView.NO_POSITION) {
            recyclerViewInterface.onItemClick(pos);
          }
        }
      });
    }
  }
}
