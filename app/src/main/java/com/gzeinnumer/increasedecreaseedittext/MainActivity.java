package com.gzeinnumer.increasedecreaseedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.gzeinnumer.increasedecreaseedittext.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    int minteger = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.increase.setOnClickListener(view -> {
            increaseInteger();
        });
        binding.decrease.setOnClickListener(view -> {
            decreaseInteger();
        });
    }

    public void increaseInteger() {
        minteger = minteger + 1;
        display(minteger);
    }

    public void decreaseInteger() {
        if (minteger>0){
            minteger = minteger - 1;
            display(minteger);
        }
    }

    private void display(int number) {
        binding.integerNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int harga = Integer.parseInt(binding.tvHarga.getText().toString());
                binding.tvTotal.setText("RP. "+harga*Integer.parseInt(editable.toString()));
            }
        });
        binding.integerNumber.setText("" + number);
    }
}