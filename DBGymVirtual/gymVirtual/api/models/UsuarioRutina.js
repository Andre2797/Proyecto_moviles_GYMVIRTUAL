/**
 * UsuarioRutina.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    id_rolUsuario:{
      type: 'number',
      autoIncrement:true,
      columnName:'idUsuarioRutina'
    },
    fechaRealizacion:{
      type: 'string',
      defaultsTo: '2020-08-26',
      columnName: 'FechaRealizacion'
    },
    tiempoRutina:{
      type: 'number',
      defaultsTo: 120,
      columnName: 'tiempoRutina'
    },

    usuario:{
      model: 'usuario'
    },

    rutina:{
      model: 'rutina'
    },

    usuarioRutinasEjercicios:{
      collection: 'usuarioRutinaEjercicio',
      via: 'usuarioRutina'
    },
  },

};

