let ws;
const DISCONNECT = "Disconnect";
const CONNECT = "Connect";

function connect() {
    let username = document.getElementById("username").value;
    let host = document.location.host;

                         /* ws://localhost:8080/chat/user */
    ws = new WebSocket("ws://" + host + "/chat/" + username);
    console.log(ws)
    ws.onmessage = function(event) {
        let log = document.getElementById("log");
        console.log(event.data);

        let message = JSON.parse(event.data);
        log.innerHTML += message.from + " : " + message.content + "\n";
    };
}

function send() {
    let content = document.getElementById("msg").value;
    let json = JSON.stringify({
        "content":content,
        "type":"content"
    });

    ws.send(json);

    /* Clear massage input area */
    document.getElementById("msg").value = "";
}

function disconnect () {
    let json = JSON.stringify({
        "content": "disconnect",
        "type":"disconnect"
    });

    ws.send(json)
}

function connectionCall() {
    let content = document.getElementById("conBtn").textContent;

    if (content === DISCONNECT) {
        /* Change button's text to Connect */
        document.getElementById("conBtn").textContent = CONNECT;
        /* Enable write function & erase the old username */
        document.getElementById("username").disabled = false;
        document.getElementById("username").value = "";
        this.disconnect();
    }
    else {
        /* Change button's text to Disconnected and disable the field */
        document.getElementById("conBtn").textContent = DISCONNECT;
        document.getElementById("username").disabled = true;
        this.connect();
    }
}
