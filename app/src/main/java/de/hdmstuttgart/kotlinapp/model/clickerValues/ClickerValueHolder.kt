package de.hdmstuttgart.kotlinapp.model.clickerValues

import de.hdmstuttgart.kotlinapp.model.AutoClickers
import java.math.BigDecimal

class ClickerValueHolder {
    companion object {
        private val simple = SimpleClickerValues()
        private val improved = ImprovedClickerValues()
        private val advanced = AdvancedClickerValues()
        private val pro = ProClickerValues()
        private val elite = EliteClickerValues()
        private val legendary = LegendaryClickerValues()
        private val exotic = ExoticClickerValues()
        private val mythic = MythicClickerValues()

        fun priceOf(type : AutoClickers) : BigDecimal {
            return when (type) {
                AutoClickers.Simple -> simple.price
                AutoClickers.Improved -> improved.price
                AutoClickers.Advanced -> advanced.price
                AutoClickers.Pro -> pro.price
                AutoClickers.Elite -> elite.price
                AutoClickers.Legendary -> legendary.price
                AutoClickers.Exotic -> exotic.price
                AutoClickers.Mythic -> mythic.price
            }
        }

        fun clicksPerSecOf(type : AutoClickers) : BigDecimal {
            return when (type) {
                AutoClickers.Simple -> simple.clicksPerSec
                AutoClickers.Improved -> improved.clicksPerSec
                AutoClickers.Advanced -> advanced.clicksPerSec
                AutoClickers.Pro -> pro.clicksPerSec
                AutoClickers.Elite -> elite.clicksPerSec
                AutoClickers.Legendary -> legendary.clicksPerSec
                AutoClickers.Exotic -> exotic.clicksPerSec
                AutoClickers.Mythic -> mythic.clicksPerSec
            }
        }
    }

    private class MythicClickerValues : IClickerValues {
        override val price = BigDecimal(1_000_000)
        override val clicksPerSec = BigDecimal(50_000)
    }

    private class ExoticClickerValues : IClickerValues {
        override val price = BigDecimal(100_000)
        override val clicksPerSec = BigDecimal(3000)
    }

    private class LegendaryClickerValues : IClickerValues {
        override val price = BigDecimal(40_000)
        override val clicksPerSec = BigDecimal(1000)
    }

    private class EliteClickerValues : IClickerValues {
        override val price = BigDecimal(10_000)
        override val clicksPerSec = BigDecimal(200)
    }

    private class ProClickerValues : IClickerValues {
        override val price = BigDecimal(3000)
        override val clicksPerSec = BigDecimal(50)
    }

    private class AdvancedClickerValues : IClickerValues{
        override val price = BigDecimal(1000)
        override val clicksPerSec: BigDecimal = BigDecimal(10)
    }

    private class ImprovedClickerValues : IClickerValues {
        override val price = BigDecimal(250)
        override val clicksPerSec = BigDecimal(2)
    }

    private class SimpleClickerValues : IClickerValues {
        override val price = BigDecimal(25)
        override val clicksPerSec = BigDecimal(0.1)
    }

    private interface IClickerValues {
        val price : BigDecimal
        val clicksPerSec : BigDecimal
    }
}