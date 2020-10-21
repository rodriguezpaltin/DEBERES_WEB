var mongoose = require ('mongoose');
var connection = mongoose.connection('mongodb+srv://<username>:123456cluster0.lp6d6.mongodb.net/ClasePractica?retryWrites=true&w=majority');

mongoose.connection.on('open' , (ref)=>{
    console.log('Conectado a mongo cloud');
})