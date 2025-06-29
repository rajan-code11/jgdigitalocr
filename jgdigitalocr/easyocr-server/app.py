from flask import Flask, request, jsonify
import easyocr
import os

app = Flask(__name__)
reader = easyocr.Reader(['en'])

@app.route('/ocr', methods=['POST'])
def ocr():
    if 'image' not in request.files:
        return jsonify({'error': 'No image file'}), 400
    img = request.files['image']
    img_path = os.path.join('/tmp', img.filename)
    img.save(img_path)
    result = reader.readtext(img_path, detail=0, paragraph=True)
    os.remove(img_path)
    return jsonify({'text': "\n".join(result)})

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=5000)