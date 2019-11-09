package de.hdmstuttgart.kotlinapp.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import de.hdmstuttgart.kotlinapp.model.AutoClickers
import de.hdmstuttgart.kotlinapp.model.SimpleAutoClicker
import de.hdmstuttgart.kotlinapp.util.AutoClickerFactory

class ClickerViewModel : BaseObservable() {

    @Bindable
    var clicks = 0

    private val clickers = mutableListOf<SimpleAutoClicker>()

    init {
        startCollectingClicks()
    }

    fun addClick()
    {
        clicks++
        notifyPropertyChanged(BR.clicks)
    }

    fun addClicks(amount : Int)
    {
        clicks += amount
        notifyPropertyChanged(BR.clicks)
    }

    fun removeClicks(amount : Int)
    {
        addClicks(-amount)
    }

    fun addAutoClicker(clickerType : AutoClickers)
    {
        val clicker = AutoClickerFactory.getAutoClicker(clickerType)

        if (clicker != null && clicks >= clicker.price)
        {
            removeClicks(clicker.price)
            clickers.add(clicker as SimpleAutoClicker)
            Thread(clicker).start()
        }
    }

    private fun startCollectingClicks()
    {
        Thread(Runnable {
            while (true)
            {
                Thread.sleep(50)
                clickers.forEach { x -> addClicks(x.collectClicks()) }
            }
        }).start()
    }

}
