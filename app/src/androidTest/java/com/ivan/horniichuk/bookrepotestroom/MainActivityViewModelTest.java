package com.ivan.horniichuk.bookrepotestroom;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

import android.view.View;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;

import com.ivan.horniichuk.bookrepotestroom.data.Book;
import com.ivan.horniichuk.bookrepotestroom.data.BookDatabase;
import com.ivan.horniichuk.bookrepotestroom.main_activity.MainActivityViewModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityViewModelTest {

    private MainActivityViewModel viewModel = null;

    private BookDatabase database = null;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() throws Exception {
        database = Mockito.mock(BookDatabase.class);
        viewModel = new MainActivityViewModel(database);
    }

    @After
    public void tearDown() throws Exception {
        viewModel = null;
    }

    @Test
    public void successInit() {
        assertNotNull(viewModel);
    }

    @Test
    public void getListMutableLiveData() {
        MutableLiveData<List<Book>> mutableLiveData = viewModel.getListMutableLiveData();
        assertNotNull(mutableLiveData);
        assertNotNull(mutableLiveData.getValue());
    }

    @Test
    public void getState() {
        MutableLiveData<MainActivityViewModel.State> state = viewModel.getState();
        assertNotNull(state);
        assertNotNull(state.getValue());
    }

    @Test
    public void getRecyclerViewAdapter() {
        assertNotNull(viewModel.getRecyclerViewAdapter());
    }

    @Test
    public void onNewBookClicked() {
        viewModel.getState().observeForever(state -> {
            assertNotNull(state);
        });
        viewModel.onNewBookClicked(Mockito.mock(View.class));
        assertTrue(viewModel.getState().getValue().openNewBookActivity);
    }

    @Test
    public void reInitList() {
        viewModel.getListMutableLiveData().observeForever(books -> {
            assertNotNull(books);
        });
        viewModel.reInitList();

    }
}