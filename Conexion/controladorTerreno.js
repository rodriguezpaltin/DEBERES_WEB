const { request, response } = require('express');

var terreno=require('./modelosTerreno'),
express=require('express'),
rutas=express.Router();

rutas.post('/obtenerTodos',(request,response)=>{

    terreno.find({},(err,datos)=>{
        if(err){
            console.log(err);
            throw err;

        }
        response.status(200).json(datos)
    })
})
rutas.post('/crear',(request,response)=>{
     var body=request.body;
     terreno.insertMany({
         idTerreno:body.idTerreno,
         dimension:body.dimension,
         barrio:body.barrio,
         calleprincipal:body.calleprincipal
     },(err,resp)=>{
         if(err){
             console.log(err);
             throw err;

         }
        response.status(200).json(resp);

    })
    rutas.post('/editar',(request,response)=>{
        var body=request.body;
        terreno.updateOne(
        {
            idTerreno:body.idTerreno
        },{
            dimension:body.dimension,
            barrio:body.barrio,
            calleprincipal:body.calleprincipal
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

})
rutas.post('/eliminar',(request,response)=>{


    var body=request.body;
    terreno.deleteOne(
        {
            idTerreno:body.idTerreno
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

     