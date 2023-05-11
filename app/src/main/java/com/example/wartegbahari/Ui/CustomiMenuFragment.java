package com.example.wartegbahari.Ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wartegbahari.Data.ArrayOrderModel;
import com.example.wartegbahari.Data.OrderModel;
import com.example.wartegbahari.R;

public class CustomiMenuFragment extends Fragment {
  private ImageView foodImgSrc;
  private TextView foodTitle;
  private TextView foodDesc;
  private TextView foodPrice;
  private AppCompatButton buttonAddToCart;
  private AutoCompleteTextView spicyLevelChooser;
  private String[] spicyOptions = {"0", "1", "2", "3", "4", "5"};
  private boolean isDataAdded;
  private RadioGroup radioGroup;
  private RadioButton radioButton;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view =  inflater.inflate(R.layout.fragment_customi_menu, container, false);

    // init image & text view
    foodImgSrc = (ImageView) view.findViewById(R.id.foodImgSrc);
    foodTitle = (TextView) view.findViewById(R.id.foodTitleDetail);
    foodDesc = (TextView) view.findViewById(R.id.foodNotesDetail);
    foodPrice = (TextView) view.findViewById(R.id.foodPriceDetail);

    // init spicy level
    ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_dropdown_item, spicyOptions);
    spicyLevelChooser = (AutoCompleteTextView) view.findViewById(R.id.spicyChooser);
    spicyLevelChooser.setAdapter(adapter);

    // init radio button
    radioGroup = (RadioGroup) view.findViewById(R.id.orderType);

    // get bundle
    Bundle bundle = getArguments();

    if (bundle != null) {
      // display on fragment
      isDataAdded = bundle.getBoolean("STATUS_ADDED_MENU", false);
      foodImgSrc.setImageResource(bundle.getInt("FOOD_IMG"));
      foodTitle.setText(bundle.getString("FOOD_TITLE"));
      foodDesc.setText(bundle.getString("FOOD_DESC"));
      foodPrice.setText("Rp" + bundle.getString("FOOD_PRICE"));

      // init button
      buttonAddToCart = (AppCompatButton) view.findViewById(R.id.btnAddToCart);
      buttonAddToCart.setOnClickListener(v -> {
        if (inputIsEmpty()) {
          return;
        }
        int orderTypes = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) view.findViewById(orderTypes);
        ArrayOrderModel.addOrder(new OrderModel(bundle.getString("FOOD_TITLE"), spicyLevelChooser.getText().toString(), radioButton.getText().toString(), Double.parseDouble(bundle.getString("FOOD_PRICE"))));
        AddOrderFragment addOrderFragment = new AddOrderFragment();
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentManager.popBackStackImmediate();
        fragmentTransaction.replace(R.id.containerLayout, addOrderFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
      });
    }
    return view;
  }

  public boolean inputIsEmpty() {
    if (
      spicyLevelChooser.getText().toString().isEmpty() ||
      radioGroup.getCheckedRadioButtonId() == -1
    ) {
      Toast.makeText(getContext(), "All field should be filled!", Toast.LENGTH_SHORT).show();
      return true;
    }
    else return false;
  }
}