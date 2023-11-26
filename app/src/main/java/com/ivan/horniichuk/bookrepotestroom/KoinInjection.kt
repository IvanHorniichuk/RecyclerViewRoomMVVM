package com.ivan.horniichuk.bookrepotestroom

import com.ivan.horniichuk.bookrepotestroom.data.BookDatabase
import com.ivan.horniichuk.bookrepotestroom.data.BookRepository
import com.ivan.horniichuk.bookrepotestroom.main_activity.MainActivityViewModel
import com.ivan.horniichuk.bookrepotestroom.new_book.NewBookViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


@JvmField
val koinModule = module {
    single<BookRepository> { BookDatabase(get()) }

    viewModel { MainActivityViewModel(get()) }
    viewModel { NewBookViewModel(get()) }

}
