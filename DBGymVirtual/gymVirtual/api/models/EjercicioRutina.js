/**
 * EjercicioRutina.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    id_ejercicioRutina:{
      type: 'number',
      autoIncrement:true,
      columnName:'idEjerRut'
    },
    repeticiones_EjeRut:{
      type: 'number',
      defaultsTo: 2,
      columnName:'repetEjerRut'
    },

    rutina:{
      model: 'rutina'
    }, 

    ejercicio:{
      model: 'ejercicio'
    },

    usuarioRutinasEjercicios:{
      collection: 'usuarioRutinaEjercicio',
      via: 'ejercicioRutina'
    }

    

  },

};

