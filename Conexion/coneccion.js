var mongoose=require('mongoose');
var connection=mongoose.connect('mongodb+srv://rafa:rafa@cluster0.2x1ud.mongodb.net/clases1?retryWrites=true&w=majority');
mongoose.connection.on('open',(ref)=>{
console.log("Conectado a Mongo Cloud y Ya esta listo");
});
module.exports=connection;
