package com.karumi.maxibonkata

import io.kotlintest.properties.Gen
import io.kotlintest.properties.forAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec
import java.util.*

class KarumiHQTest : ShouldSpec() {


    init {
        "KarumiHQs"{

            should("amount of maxibon should be equal or more than two") {
                forAll(Generators.AnyDeveloperGenerator()) { dev: Developer ->
                    val hq = KarumiHQs()

                    hq.openFridge(dev)
                    hq.maxibonsLeft >= 2


                }
            }

            should("amount of maxibon should be equal or more than two when a group takes some") {
                forAll(Gen.list(Generators.AnyDeveloperGenerator())) { dev: List<Developer> ->
                    val hq = KarumiHQs()

                    hq.openFridge(dev)
                    hq.maxibonsLeft >= 2


                }
            }

            should("message to refill maxibon") {

                var messageSent = false
                forAll(Generators.HungryDeveloperGenerator()) { dev: Developer ->


                    val hq = KarumiHQs(object : Chat {
                        override fun sendMessage(message: String) {
                            messageSent = true
                        }
                    })

                    hq.openFridge(dev)

                    messageSent == true


                }


            }
        }
    }
}