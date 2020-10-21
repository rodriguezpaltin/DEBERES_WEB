const { request, response } = require('express');

var edificio=require('./modeloEdificio'),
express=require('express'),
rutas=express.Router();
rutas.post('/obtenerEdificio',(request,response)=>{

  edificio.find({},(err,datos)=>{
        if(err){
            console.log(err);
            throw err;

        }
        response.status(200).json(datos)
    })
})
rutas.post('/crearEdificio',(request,response)=>{
     var body=request.body;
     edificio.insertMany({
         idEdificio:body.idEdificio,
         dimension:body.dimension,
         barrio:body.barrio,
         calleprincipal:body.calleprincipal,
         color:body.color,
         pisos:body.pisos
     },(err,resp)=>{
         if(err){
             console.log(err);
             throw err;

         }
        response.status(200).json(resp);

    })
})
rutas.post('/editarEdificio',(request,response)=>{
    var body=request.body;
   edificio.updateOne(
    {
        idEdificio:body.idEdificio
    },{
        dimension:body.dimension,
        barrio:body.barrio,
        calleprincipal:body.calleprincipal,
        color:body.color,
        pisos:body.pisos
    },(err,res)=>{
        if(err){
            console.log(err);
            throw err;
        }
        response.status(200).json(res);
    }
  )
}
)
rutas.post('/eliminarEdificio',(request,response)=>{


    var body=request.body;
    edificio.deleteOne(
        {
            idEdificio:body.idEdificio
        },(err,res)=>{
            if(err){
                console.log(err);
                throw err;
            }
            response.status(200).json(res);
        }
    )
}
)
module.exports=rutas;
