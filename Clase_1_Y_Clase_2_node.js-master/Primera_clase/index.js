var http=require('http');
var server = http.createServer();
function mensaje (peticion , respuesta){
    respuesta.writeHead(200 , {'content-type':'text/plain'})
    respuesta.write("Hola Mundo")
    respuesta.end();
}
server.on('request' , mensaje);
server.listen(3000 , function(){
    console.log("El servidor se inicio correctamente");
});