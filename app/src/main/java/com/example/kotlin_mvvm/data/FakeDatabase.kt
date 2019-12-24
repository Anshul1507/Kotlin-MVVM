package com.example.kotlin_mvvm.data

class FakeDatabase private constructor(){
    //Creating Singleton
    var quoteDao = FakeQuoteDao()
        private set

    companion object{
        @Volatile private var instance: FakeDatabase?= null

        fun getInstance() = instance ?: synchronized(this){
            //check instance will not be instantiated
            instance ?: FakeDatabase().also { instance = it }
        }
        //?: means if instance is null then result will be other value

    }
}