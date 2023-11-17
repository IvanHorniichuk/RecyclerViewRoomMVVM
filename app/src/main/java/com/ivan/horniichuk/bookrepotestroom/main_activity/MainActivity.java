package com.ivan.horniichuk.bookrepotestroom.main_activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.ivan.horniichuk.bookrepotestroom.data.Book;
import com.ivan.horniichuk.bookrepotestroom.data.BookDatabase;
import com.ivan.horniichuk.bookrepotestroom.data.BookRepository;
import com.ivan.horniichuk.bookrepotestroom.databinding.ActivityMainBinding;
import com.ivan.horniichuk.bookrepotestroom.new_book.NewBookActivity;


public class MainActivity extends AppCompatActivity {


    private MainActivityViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.setBookRepository(BookDatabase.getInstance(getApplicationContext()));
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        viewModel.getState().observe(this,state -> {
            if (state.openNewBookActivity){
                Intent intent=new Intent(MainActivity.this, NewBookActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.reInitList();
    }
}