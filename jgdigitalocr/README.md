# Android OCR Batch App

Batch OCR Android app to process images, crop, and extract data using Google ML Kit (on-device) and (optionally) EasyOCR (server-side).
Includes GitHub Actions workflow for CI/CD and APK artifacts.

## Features

- Upload a folder of images or a zip file.
- Crop the first image, apply crop to all.
- Run OCR (ML Kit on-device, EasyOCR via API).
- Extraction options: all text, only text, only numbers, 7+ digit numbers.
- Expandable UI for extraction options.
- Output: CSV (filename, extracted text), sorted by filename.
- Select output path and file name.
- TXT file "fix": upload txt, extract 7+ digit numbers.

## Usage

- Edit files and push to GitHub.
- GitHub Actions will build the APK and provide a download link under Actions/Artifacts.

---