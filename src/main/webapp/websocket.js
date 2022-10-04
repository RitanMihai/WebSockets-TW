let ws;
const DISSCONECT = "Disconnect";
const CONNECT = "Connect";

function connect() {
    var username = document.getElementById("username").value;
    var host = document.location.host;

                         /* ws://localhost:8080/chat/user */
    ws = new WebSocket("ws://" + host + "/chat/" + username);
    console.log(ws)
    ws.onmessage = function(event) {
        var log = document.getElementById("log");
        console.log(event.data);
        var message = JSON.parse(event.data);
        log.innerHTML += message.from + " : " + message.content + "\n";
    };
}

function send() {
    var content = document.getElementById("msg").value;
    var json = JSON.stringify({
        "content":content,
        "type":"content"
    });

    ws.send(json);

    /* Clear massage input area */
    document.getElementById("msg").value = "";
}

function dissconect () {
    var json = JSON.stringify({
        "content": "disconnect",
        "type":"disconnect"
    });

    ws.send(json)
}

function connectionCall() {
    var content = document.getElementById("conBtn").textContent;

    if (content === DISSCONECT) {
        /* Change button's text to Connect */
        document.getElementById("conBtn").textContent = CONNECT;
        /* Enable write function & erase the old username */
        document.getElementById("username").disabled = false;
        document.getElementById("username").value = "";
        this.dissconect();
    }
    else {
        /* Change button's text to Disconnected and disable the field */
        document.getElementById("conBtn").textContent = DISSCONECT;
        document.getElementById("username").disabled = true;
        this.connect();
    }
}
