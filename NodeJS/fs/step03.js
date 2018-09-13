const fs = require('fs')

fs.readFile('./cpus.txt', 'utf-8', (error, data) => {
    if( !error ) {
        console.log(data)
    }
    else {
        console.log(error)
    }
})