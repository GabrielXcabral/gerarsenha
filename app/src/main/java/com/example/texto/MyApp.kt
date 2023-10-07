package com.example.texto
import android.app.Application


class MyApp : Application() {
    lateinit var repository: Repository

    override fun onCreate() {
        super.onCreate()
        repository = Repository()
    }
}