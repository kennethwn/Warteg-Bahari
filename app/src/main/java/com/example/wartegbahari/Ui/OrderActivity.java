package com.example.wartegbahari.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;

import com.example.wartegbahari.R;

public class OrderActivity extends AppCompatActivity {
  private AddOrderFragment addOrderFragment = new AddOrderFragment();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_order);

    // Setup AddOrderFragment
    getSupportFragmentManager().beginTransaction().replace(R.id.containerLayout,addOrderFragment).commit();
  }
}