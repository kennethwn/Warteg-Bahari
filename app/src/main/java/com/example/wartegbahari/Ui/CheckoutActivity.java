package com.example.wartegbahari.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;

import com.example.wartegbahari.R;

public class CheckoutActivity extends AppCompatActivity {
  private AppCompatButton buttonHome;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_checkout);

    buttonHome = (AppCompatButton) findViewById(R.id.btnHome);
    buttonHome.setOnClickListener(v -> {
      Intent intent = new Intent(CheckoutActivity.this, BookingTableActivity.class);
      finish();
      startActivity(intent);
    });
  }
}