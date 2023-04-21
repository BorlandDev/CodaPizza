package com.bignerdranch.android.codapizza.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.bignerdranch.android.codapizza.R
import com.bignerdranch.android.codapizza.model.Topping
import com.bignerdranch.android.codapizza.model.ToppingPlacement

@Composable
fun ToppingPlacementDialog(
    topping: Topping,
    onSetToppingPlacement: ((placement: ToppingPlacement?) -> Unit),
    onDismissRequest: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        Card {
            Column {
                val toppingName = stringResource(id = topping.toppingName)

                Text(
                    stringResource(id = R.string.placement_prompt, toppingName),
                    style = MaterialTheme.typography.subtitle1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(24.dp)
                )

                ToppingPlacement.values().forEach { placement ->
                    ToppingPlacementOptions(
                        placementName = placement.label,
                        onClick = {
                            onSetToppingPlacement(placement)
                            onDismissRequest() }
                    )
                }

                ToppingPlacementOptions(
                    placementName =
                    R.string.placement_none, onClick = {
                        onSetToppingPlacement(null)
                        onDismissRequest() }
                )
            }
        }
    }
}

@Composable
private fun ToppingPlacementOptions(
    @StringRes placementName: Int,
    onClick: () -> Unit
) {
    TextButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(placementName),
            modifier = Modifier.padding(8.dp)
        )
    }
}