package com.ivan.horniichuk.bookrepotestroom.new_book;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.ivan.horniichuk.bookrepotestroom.R;
import com.ivan.horniichuk.bookrepotestroom.data.BookDatabase;
import com.ivan.horniichuk.bookrepotestroom.databinding.ActivityMainBinding;
import com.ivan.horniichuk.bookrepotestroom.databinding.ActivityNewBookBinding;
import com.ivan.horniichuk.bookrepotestroom.main_activity.MainActivityViewModel;

public class NewBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NewBookViewModel viewModel = new ViewModelProvider(this).get(NewBookViewModel.class);
        viewModel.setBookRepository(BookDatabase.getInstance(getApplicationContext()));
        ActivityNewBookBinding binding = ActivityNewBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        viewModel.getState().observe(this,state -> {
            if(state.needFinish)
                NewBookActivity.this.finish();
        });
    }
}