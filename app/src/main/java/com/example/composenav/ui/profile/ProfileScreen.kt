package com.example.composenav.ui.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composenav.R


@Composable
fun ProfileScreen(
    nestedNavController: NavHostController,
    onHomeBackClick: () -> Unit = {},
    onLogOutClick: () -> Unit = {}
) {
    var showDialog by remember { mutableStateOf(false) }
    if (showDialog)
        AlertDialog(
            onDismissRequest = { showDialog = false },
            text = { Text(stringResource(id = R.string.logout_dialog_text)) },
            confirmButton = {
                TextButton(onClick = {
                    onLogOutClick()
                    showDialog = false
                }) {
                    Text(stringResource(id = R.string.logout))
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text(stringResource(id = R.string.cancel))
                }
            },
        )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Button(
            modifier = Modifier.padding(16.dp),
            onClick = { nestedNavController.navigate(ProfileScreen.ProfileDetails.route) }
        ) {
            Text(stringResource(id = R.string.navigate_to_details))
        }
        Button(
            modifier = Modifier.padding(16.dp),
            onClick = { onHomeBackClick() },
        ) {
            Text(stringResource(id = R.string.navigate_to_home))
        }
        Text(
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    showDialog = showDialog.not()

                },

            text = stringResource(id = R.string.logout)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(nestedNavController = rememberNavController())
}