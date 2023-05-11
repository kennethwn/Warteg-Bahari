package com.example.wartegbahari.Ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.wartegbahari.Data.ArrayMenuModel;
import com.example.wartegbahari.Data.ArrayOrderModel;
import com.example.wartegbahari.Data.MenuModel;
import com.example.wartegbahari.R;

import java.util.ArrayList;

public class AddOrderFragment extends Fragment implements RecyclerViewInterface {
  private RecyclerView recyclerView;
  private RecyclerView.Adapter adapter;
  private AppCompatButton buttonCancel;
  private AppCompatButton buttonCart;
  private ArrayMenuModel arrayMenuModel;
  private boolean isDataAdded = false;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_add_order, container, false);

    // init list of menu
    recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewTemplate);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    if (isDataAdded == false) {
      ArrayMenuModel.getInstance().clear();
      ArrayMenuModel.getInstance();
      ArrayMenuModel.addMenu(new MenuModel(R.drawable.nasi_ayam_bumbu_kacang,"Nasi Pecel Ayam", "Nasi + ayam panggang + pecel", 40000.00));
      ArrayMenuModel.addMenu(new MenuModel(R.drawable.nasi_merah_ayam_suwir, "Nasi Ayam Suwir", "Nasi + ayam suwir + sambal + sayur", 50000.00));
      ArrayMenuModel.addMenu(new MenuModel(R.drawable.nasi_merah_ayam_serundeng, "Nasi Ayam Serundeng", "Nasi + ayam serundeng + cah kangkung", 45000.00));
      ArrayMenuModel.addMenu(new MenuModel(R.drawable.nasi_merah_salmon, "Nasi Salmon Panggang", "", 55000.00));
      ArrayMenuModel.addMenu(new MenuModel(R.drawable.mix_vegetable_platter, "Mix Vegetable Platter", "Beraneka ragam sayuran", 40000.00));
      ArrayMenuModel.addMenu(new MenuModel(R.drawable.mix_vegetable_salad, "Mix Vegetable Salad", "Salad sayur menggunakan mayonaise", 30000.00));
      ArrayMenuModel.addMenu(new MenuModel(R.drawable.healthy_sandwich, "Healthy Sandwich", "Sandwich gandum isi telur & sayur", 35000.00));
      ArrayMenuModel.addMenu(new MenuModel(R.drawable.egg_avocado, "Egg Avocado", "Alpukat panggang dengan telur", 30000.00));
      ArrayMenuModel.addMenu(new MenuModel(R.drawable.salad_buah_family_pack, "Salad Buah (Family)", "Ukuran family package", 50000.00));
      ArrayMenuModel.addMenu(new MenuModel(R.drawable.salad_buah_personal, "Salad Buah (Personal)", "Ukuran personal package", 35000.00));
      isDataAdded = true;
    }

    adapter = new MenuAdapter(arrayMenuModel, getContext(), this);
    recyclerView.setAdapter(adapter);

    // init button cancel
    buttonCancel = view.findViewById(R.id.btnCancel);
    buttonCancel.setOnClickListener(v -> {
      Intent intent = new Intent(getActivity(), BookingTableActivity.class);
      intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
      startActivity(intent);
      getParentFragmentManager().beginTransaction().remove(AddOrderFragment.this).commit();
    });

    // init button add
    buttonCart = view.findViewById(R.id.btnCart);
    buttonCart.setText(String.valueOf(ArrayOrderModel.getInstance().size()));
    buttonCart.setOnClickListener(v -> {
      if (ArrayOrderModel.getInstance().isEmpty()) {
        Toast.makeText(getContext(), "Cart is empty", Toast.LENGTH_SHORT).show();
        return;
      }
      Intent intent = new Intent(getActivity(), CheckoutActivity.class);
      startActivity(intent);
    });

    return view;
  }

  @Override
  public void onItemClick(int position) {
    Bundle bundle = new Bundle();
    bundle.putInt("FOOD_IMG", ArrayMenuModel.getInstance().get(position).getImage());
    bundle.putString("FOOD_TITLE", ArrayMenuModel.getInstance().get(position).getTitle());
    bundle.putString("FOOD_DESC", ArrayMenuModel.getInstance().get(position).getDesc());
    bundle.putString("FOOD_PRICE", String.valueOf(ArrayMenuModel.getInstance().get(position).getPrice()));
    bundle.putBoolean("STATUS_ADDED_MENU", isDataAdded);
    CustomiMenuFragment customiMenuFragment = new CustomiMenuFragment();
    customiMenuFragment.setArguments(bundle);
    FragmentManager fragmentManager = getParentFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentManager.popBackStackImmediate();
    fragmentTransaction.replace(R.id.containerLayout, customiMenuFragment);
    fragmentTransaction.addToBackStack(null);
    fragmentTransaction.commit();
  }
}