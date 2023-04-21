package com.bignerdranch.android.codapizza.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pizza(
    val toppings: Map<Topping, ToppingPlacement> = emptyMap()
) : Parcelable {
    fun withTopping(
        topping: Topping,
        placement: ToppingPlacement?
    ): Pizza {
        return copy(
            toppings = if (placement == null) toppings - topping
            else toppings + (topping to placement)
        )
    }
}
