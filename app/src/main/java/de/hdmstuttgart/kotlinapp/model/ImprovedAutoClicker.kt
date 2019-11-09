package de.hdmstuttgart.kotlinapp.model

class ImprovedAutoClicker : IAutoClicker {
    override val price = 250
    override var clicksPerSecond = 2.0
    private var collectedClicks = 0

    override fun run() {
        while (true)
        {
            Thread.sleep((1000 / clicksPerSecond).toLong())
            collectedClicks++
        }
    }

    override fun collectClicks() : Int {
        val clicksToReturn = collectedClicks
        collectedClicks = 0
        return clicksToReturn
    }
}