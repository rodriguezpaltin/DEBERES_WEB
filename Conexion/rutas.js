
const express=require('express'),
rutas=express.Router(),
equipo=require('./controladorTerreno'),
edificio=require('./controladorEdificio');
rutas.use('/equipo',equipo);
rutas.use('/edificio',edificio);
module.exports=rutas;