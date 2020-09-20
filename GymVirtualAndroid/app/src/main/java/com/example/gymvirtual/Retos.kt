package com.example.gymvirtual

class Retos(
     var titulo:String,
     var descripcion:String,
     var imagen:Int,
){
     override fun toString(): String {
          return "Retos(titulo='$titulo', descripcion='$descripcion', imagen=$imagen)"
     }

     override fun equals(other: Any?): Boolean {
          if (this === other) return true
          if (javaClass != other?.javaClass) return false

          other as Retos

          if (titulo != other.titulo) return false
          if (descripcion != other.descripcion) return false
          if (imagen != other.imagen) return false

          return true
     }

     override fun hashCode(): Int {
          var result = titulo.hashCode()
          result = 31 * result + descripcion.hashCode()
          result = 31 * result + imagen
          return result
     }


}