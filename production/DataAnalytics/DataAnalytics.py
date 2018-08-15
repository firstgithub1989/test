from flask import Flask,jsonify,json,request

app = Flask(__name__)

@app.route("/health")
def health():
    return jsonify(status='UP')

@app.route("/")
def hello():
    return "Hello World!!" + request.headers.get("user")
if __name__ == "__main__":
    app.run()