package com.example.kotlin_mvvm.utils

import com.example.kotlin_mvvm.QuotesViewModelFactory
import com.example.kotlin_mvvm.data.FakeDatabase
import com.example.kotlin_mvvm.data.QuoteRepository

object InjectorUtils {

    fun provideQuotesViewModelFactory() : QuotesViewModelFactory{
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}