package com.bignerdranch.android.codapizza.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bignerdranch.android.codapizza.R
import com.bignerdranch.android.codapizza.model.Pizza
import com.bignerdranch.android.codapizza.model.Topping
import com.bignerdranch.android.codapizza.model.ToppingPlacement.ALl
import com.bignerdranch.android.codapizza.model.ToppingPlacement.Left
import com.bignerdranch.android.codapizza.model.ToppingPlacement.Right

@Preview(showBackground = true)
@Composable
private fun PizzaHeroImagePreview() {
    PizzaHeroImage(
        pizza = Pizza(
            toppings = mapOf(
                Topping.PineApple to ALl,
                Topping.Pepperoni to Left,
                Topping.Basil to Right
            )
        )
    )
}

@Composable
fun PizzaHeroImage(
    pizza: Pizza,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
    ) {
        Image(
            painter = painterResource(R.drawable.pizza_crust),
            contentDescription = stringResource(R.string.pizza_preview),
            modifier.fillMaxSize()
        )

        pizza.toppings.forEach { (topping, placement) ->
            Image(
                painter = painterResource(topping.pizzaOverlayImage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alignment = when (placement) {
                    Right -> Alignment.TopEnd
                    Left -> Alignment.TopStart
                    else -> Alignment.Center
                },
                modifier = Modifier
                    .focusable(false)
                    .aspectRatio(
                        when (placement) {
                            Right, Left -> 0.5f
                            else -> 1f
                        }
                    )
                    .align(
                        when (placement) {
                            Left -> Alignment.CenterStart
                            Right -> Alignment.CenterEnd
                            ALl -> Alignment.Center
                        }
                    )
            )
        }
    }
}