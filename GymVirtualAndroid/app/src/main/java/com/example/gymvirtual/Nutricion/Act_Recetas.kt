package Activities_MenusOpciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.gymvirtual.R

class Act_Recetas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act__recetas)
        getIncomingIntent()
    }

    fun getIncomingIntent(){
        if(intent.hasExtra("imagenURL")){
            var imagenURL = intent.getStringExtra("imagenURL")
            setImage(imagenURL)
        }
    }

    fun setImage(imagenURL: String){
            var imagen: ImageView = findViewById(R.id.imageView13)
        Glide.with(this)
            .asBitmap()
            .load(imagenURL)
            .into(imagen)
    }
}