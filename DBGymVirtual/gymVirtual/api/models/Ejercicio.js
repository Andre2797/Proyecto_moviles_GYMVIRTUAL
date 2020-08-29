/**
 * Ejercicio.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    id_ejercicio:{
      type: 'number',
      autoIncrement:true,
      columnName:'idEjercicio'
    },

    nombre_ejercicio:{
      type: 'string',
      required:true,
      columnName:'nombreEjercicio',
      maxLength:50
    },

    url_ejercicio:{
      type: 'string',
      defaultsTo: 'None',
      columnName:'urlEjercicio',
      maxLength:400
    }, 

    ejerciciosRutinas:{
      collection: 'ejercicioRutina',
      via:'ejercicio'
    }

  },

};

