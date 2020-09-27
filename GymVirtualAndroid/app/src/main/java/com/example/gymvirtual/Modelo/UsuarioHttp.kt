package Modelo

import android.os.Parcel
import android.os.Parcelable

class UsuarioHttp(
    var nombre:String?,
    var edad:String?,
    var peso:String?,
    var altura: String?,
    var correo: String?,
    var sexo: String?
): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(edad)
        parcel.writeString(peso)
        parcel.writeString(altura)
        parcel.writeString(correo)
        parcel.writeString(sexo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UsuarioHttp> {
        override fun createFromParcel(parcel: Parcel): UsuarioHttp {
            return UsuarioHttp(parcel)
        }

        override fun newArray(size: Int): Array<UsuarioHttp?> {
            return arrayOfNulls(size)
        }
    }

}