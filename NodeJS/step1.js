// 모듈 Import 하는 방법
const os = require("os");

let hostname = os.hostname();
let cpus = os.cpus();
console.log(hostname);
console.log(cpus);
