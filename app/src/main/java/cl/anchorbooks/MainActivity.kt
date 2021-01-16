package cl.anchorbooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewbinding.BuildConfig
import timber.log.Timber

/*
[] Modelo (data class)
[] Consumo API (retrofit)
[] Repositorio
[] ViewModel
[] ViewBinding
[] Fragmento de listado (listing)
[] RecyclerView + Adapter + ViewHolder
[] Fragmento de detalle (detail)
[] Testing unitario para mappers
[] Intent implícito para compartir
[] Persistencia de datos locales (ROOM)
[] Testing para la base de datos*/


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun initLog(){
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}