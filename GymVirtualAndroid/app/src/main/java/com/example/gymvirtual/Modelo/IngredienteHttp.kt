package Modelo

class IngredienteHttp(
    var id: Int,
    var nombre_ingred: String?,
    var receta: Any?
){
    override fun toString(): String {
        return "El id del ingrediente es: ${id} El nombre del ingrediente es: ${nombre_ingred} "
    }
}