const http = require('http');
const fs = require('fs');

// 웹 서버 생성
const server = http.createServer((req, res) => {
    res.writeHead(100, {'Content-Type' : 'text/html'});
    fs.readFile('./hello.html', 'utf-8', (error, data) => {
        if( !error ) {
            res.end(data);
        }
        else {
            console.log('파일을 읽지 못했습니다.')
        }
    })
})

// 웹 서버 실행
server.listen(3000, () => {
    console.log('http://localhost:3000으로 서버가 실행')
})