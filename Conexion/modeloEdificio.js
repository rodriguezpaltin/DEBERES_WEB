var mongoose= require('mongoose'),
Schemas=mongoose.Schema;
var atributos=new Schemas({
 idEdificio:{type:Number,trim:true},
 dimension:{type:Number,trim:true},
 barrio:{type:String, trim:true},
 calleprincipal:{type:String,trim:true},
  color:{type:String, trim:true},
  pisos:{type:String, trim:true}

});
var edificio=mongoose.model('edificio',atributos);
module.exports=edificio;