/**
 * Rutina.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    id_rutina:{
      type: 'number',
      autoIncrement:true,
      columnName:'idRutina'
    },
    nombre_rutina:{
      type: 'string',
      required: true,
      columnName: 'nombreRutina',
      maxLength:70
    },
    descripcion_rutina:{
      type: 'string',
      columnName: 'descripcionRutina',
      maxLength:150, 
      defaultsTo: 'N/A'
    },
    categoria_rutina:{
      type: 'string',
      columnName: 'categoriaRutina',
      maxLength:150, 
      defaultsTo: 'TotalBody'
    },

    usuarioRutinas:{
      collection: 'usuarioRutina',
      via: 'rutina'
    },

    ejerciciosRutinas:{
      collection: 'ejercicioRutina',
      via:'rutina'
    }
  },

};

