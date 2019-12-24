package com.example.kotlin_mvvm.data

class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao){

    fun addQuote(quote: Quote){
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes()
    companion object{
        @Volatile private var instance: QuoteRepository?= null

        fun getInstance(quoteDao: FakeQuoteDao) =
            instance ?: synchronized(this){
            //check instance will not be instantiated
            instance ?: QuoteRepository(quoteDao).also { instance = it }
        }
        //?: means if instance is null then result will be other value

    }
}