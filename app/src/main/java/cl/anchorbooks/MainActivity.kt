package cl.anchorbooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
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
    private val viewModel: BookViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLog()
        supportFragmentManager.beginTransaction().add(R.id.main_container, ListingFragment()).commit()
    }

    private fun initLog(){
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}