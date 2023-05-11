package com.example.wartegbahari.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.wartegbahari.Data.ArrayOrderModel;
import com.example.wartegbahari.R;
import com.google.android.material.textfield.TextInputEditText;

public class BookingTableActivity extends AppCompatActivity {
  private String name;
  private Integer table;
  private TextInputEditText nameInput;
  private AutoCompleteTextView tableChooser;
  private AppCompatButton buttonSubmit;
  private String[] tableOptions = {"1","2","3","4","5","6","7","8","9","10"};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_booking_table);
    ArrayOrderModel.getInstance().clear();

    // Setup name edit text
    nameInput = (TextInputEditText) findViewById(R.id.name_edit_text);

    // Setup dropdown
    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tableOptions);
    tableChooser = (AutoCompleteTextView) findViewById(R.id.tableChooser);
    tableChooser.setAdapter(adapter);

    // Setup button
    buttonSubmit = (AppCompatButton) findViewById(R.id.btnSubmit);
    buttonSubmit.setOnClickListener(v -> {
      if(!inputIsFilled()) {
        Toast.makeText(this, "All fields must be filled", Toast.LENGTH_SHORT).show();
        return;
      }
      else if (checkLengthName() == 2) {
        Toast.makeText(this, "Name is too short", Toast.LENGTH_SHORT).show();
        return;
      }
      else if (checkLengthName() == 3) {
        Toast.makeText(this, "Name is too long", Toast.LENGTH_SHORT).show();
        return;
      }
      setName(nameInput.getText().toString());
      setTable(Integer.parseInt(tableChooser.getText().toString()));
      Intent intent = new Intent(BookingTableActivity.this, OrderActivity.class);
      ArrayOrderModel.setName(this.getName());
      ArrayOrderModel.setTable(this.getTable());
      finish();
      startActivity(intent);
    });
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getTable() {
    return table;
  }

  public void setTable(Integer table) {
    this.table = table;
  }

  public boolean inputIsFilled() {
    if (
      nameInput.getText().toString().isEmpty() ||
      tableChooser.getText().toString().isEmpty()
    ) return false;
    return true;
  }

  public int checkLengthName() {
    if (nameInput.getText().toString().length() < 2) {
      return 2;
    }
    else if (nameInput.getText().toString().length() > 8) {
      return 3;
    }
    return 1;
  }
}