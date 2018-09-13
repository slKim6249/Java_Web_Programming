const http = require('http');
const fs = require('fs');
const url = require('url')

// 웹 서버 생성
const server = http.createServer((req, res) => {
    res.writeHead(100, {'Content-Type' : 'text/html'});

    const path = url.parse(req.url).pathname

    if ( path == '/index' && req.method == 'GET' ) {
        fs.readFile('./hello.html', 'utf-8', (error, data) => {
            if( !error ) {
                res.end(data)
            }
            else {};
        })
        
    }
    else if ( path == '/login' && req.method == 'GET') {
        fs.readFile('./view/login.html', 'utf-8', (error, data) => {
            if( !error ) {
                res.end(data);
            }
            else {
                console.log('파일을 읽지 못했습니다.')
            }
        })
    }
    else {
        res.writeHead(404, {'Content-Type' : 'text/html'})
        res.end()
    }

    
})

// 웹 서버 실행
server.listen(3000, () => {
    console.log('http://localhost:3000으로 서버가 실행')
})