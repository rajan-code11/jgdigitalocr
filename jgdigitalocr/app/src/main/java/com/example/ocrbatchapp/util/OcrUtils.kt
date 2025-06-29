package com.example.ocrbatchapp.util

import android.content.Context
import android.graphics.Bitmap
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import kotlinx.coroutines.tasks.await

object OcrUtils {
    suspend fun recognizeText(
        context: Context,
        bitmap: Bitmap,
        extractionType: Int
    ): String {
        val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
        val image = InputImage.fromBitmap(bitmap, 0)
        val result = recognizer.process(image).await()
        val text = result.text

        return when (extractionType) {
            0 -> text // all text
            1 -> text.replace(Regex("[0-9]+"), "") // only text
            2 -> Regex("\\d+").findAll(text).joinToString(" ") { it.value } // only numbers
            3 -> Regex("\\d{7,}").findAll(text).joinToString(" ") { it.value } // 7+ digit numbers
            else -> text
        }
    }
}