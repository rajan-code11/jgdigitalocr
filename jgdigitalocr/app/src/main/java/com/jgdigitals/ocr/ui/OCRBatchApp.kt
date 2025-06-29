package com.jgdigitals.ocr.ui

import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun OCRBatchApp() {
    var images by remember { mutableStateOf<List<Uri>>(emptyList()) }
    var zipFile by remember { mutableStateOf<Uri?>(null) }
    var txtFile by remember { mutableStateOf<Uri?>(null) }
    var cropRect by remember { mutableStateOf<android.graphics.Rect?>(null) }
    var extractionType by remember { mutableStateOf(0) }
    var expanded by remember { mutableStateOf(false) }
    var outputPath by remember { mutableStateOf("") }
    var outputFileName by remember { mutableStateOf("output.txt") }
    var outputText by remember { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {
        Text("OCR Batch App", style = MaterialTheme.typography.h5)
        Spacer(Modifier.height(16.dp))
        Text("Step 1: Upload Images or Zip")
        Row {
            Button(onClick = { /* TODO: implement folder picker */ }) {
                Text("Pick Folder")
            }
            Spacer(Modifier.width(8.dp))
            Button(onClick = { /* TODO: implement zip picker */ }) {
                Text("Pick Zip")
            }
        }
        Spacer(Modifier.height(16.dp))
        Text("Step 2: Crop Images")
        Button(onClick = { /* TODO: Show first image, let user crop, save cropRect */ }) {
            Text("Crop First Image")
        }
        Spacer(Modifier.height(16.dp))
        Text("Step 3: Extraction Options")
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                value = when (extractionType) {
                    0 -> "Extract all text"
                    1 -> "Only text"
                    2 -> "Only numbers"
                    3 -> "7+ digit numbers"
                    else -> ""
                },
                onValueChange = {},
                readOnly = true,
                label = { Text("Extraction Type") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) }
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(onClick = {
                    extractionType = 0
                    expanded = false
                }) { Text("Extract all text") }
                DropdownMenuItem(onClick = {
                    extractionType = 1
                    expanded = false
                }) { Text("Only text") }
                DropdownMenuItem(onClick = {
                    extractionType = 2
                    expanded = false
                }) { Text("Only numbers") }
                DropdownMenuItem(onClick = {
                    extractionType = 3
                    expanded = false
                }) { Text("7+ digit numbers") }
            }
        }
        Spacer(Modifier.height(16.dp))
        Text("Step 4: Output Options")
        Row {
            BasicTextField(
                value = outputPath,
                onValueChange = { outputPath = it },
                modifier = Modifier.weight(1f),
                decorationBox = { innerTextField -> Box(Modifier.padding(8.dp)) { innerTextField() } }
            )
            Spacer(Modifier.width(8.dp))
            BasicTextField(
                value = outputFileName,
                onValueChange = { outputFileName = it },
                modifier = Modifier.weight(1f),
                decorationBox = { innerTextField -> Box(Modifier.padding(8.dp)) { innerTextField() } }
            )
        }
        Spacer(Modifier.height(16.dp))
        Button(onClick = { /* TODO: Run OCR and extraction */ }) {
            Text("Start Extraction")
        }
        Spacer(Modifier.height(16.dp))
        Text("Step 5: Fix TXT (7+ digit numbers)")
        Button(onClick = { /* TODO: implement txt file picker and processing */ }) {
            Text("Pick TXT File")
        }
        Spacer(Modifier.height(16.dp))
        Text("Output Preview:")
        Text(outputText)
    }
}