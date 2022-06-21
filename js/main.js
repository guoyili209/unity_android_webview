const express = require('express')
const app = express()
app.use(express.static('F:\/works\/money new\/moneyh5\/MoneyNew\/bin'))
const server = app.listen(8080, () => {
    console.log('Example app listening on port 8080!')
})

const os = require('os');
function getIPAdress() {
    var interfaces = os.networkInterfaces();
    for (var devName in interfaces) {
        var iface = interfaces[devName];
        for (var i = 0; i < iface.length; i++) {
            var alias = iface[i];
            if (alias.family === 'IPv4' && alias.address !== '127.0.0.1' && !alias.internal) {
                return alias.address;
            }
        }
    }
}
const myHost = getIPAdress();
console.log("your ip:", myHost+":8080")

const app1=express()
app1.use(express.static('F:\/works\/unity_h5\/unity_android_webview\/unity_android_webview\/js/bin'))
// app1.use(express.static('F:\/works\/money new\/moneyh5\/MoneyNew\/bin'))
const server1 = app1.listen(3000, () => {
    console.log('Example app listening on port 3000!')
})