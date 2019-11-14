package com.karumi.maxibonkata

import io.kotlintest.data.forall
import io.kotlintest.properties.forAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec
import io.kotlintest.tables.row

class DeveloperTest : ShouldSpec() {
    init {

        "Strings"{

            should("any value plus the empty string is equal to any value") {
                forAll { value: String ->
                    println(value)
                    value + "" == value

                }
            }

            should("reversed twice gets the original value") {
                forAll { value: String ->
                    println(value)
                    value.reversed().reversed() == value


                }
            }

            should("two consecutive strings can have the same size") {
                forAll { value: String, value2: String ->
                    println(value)
                    (value + value2).length == (value2 + value).length


                }
            }
        }

        "Developer"{
            should("a developer can consum 0 or a possitive number") {
                forAll { value: Int ->
                    val developer = Developer("Martin", value)
                    println(value)
                    println(developer)
                    developer.maxibonsToGrab >= 0
                }
            }
        }

    }
}