package com.ivy.math

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.row
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class EvaluateExpressionTest : FreeSpec({
    "evaluates an expression" - {
        withData(
            nameFn = { (expression, value) ->
                "\"$expression\" to $value"
            },
            // Expression (evaluate as) Value
            row("1,024+0.99-", 1_024.99),
            row("3+", 3.0),
            row("2+2", 4.0),
//            row("-9-", -9.0), TODO: Broken test disabled
            row("7*", 7.0),
            row("4/", 4.0),
            row("(12.0", 12.0),
            row("8/()", 8.0),
            row("45+(", 45.0),
        ) { (expression, value) ->
            val res = evaluate(expression)

            res shouldBe value
        }
    }
})