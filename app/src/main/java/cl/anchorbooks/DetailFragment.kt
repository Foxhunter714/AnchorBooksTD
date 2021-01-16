package cl.anchorbooks

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import cl.anchorbooks.databinding.FragmentDetailBinding
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    private val viewModel: BookViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater)

        viewModel.getDetail().observe(viewLifecycleOwner, {
            binding.idView2.text = it.id.toString()
            binding.authorView2.text = it.author
            binding.countryView2.text = it.country
            binding.languageView2.text = it.language
            binding.lastPriceView6.text = it.lastPrice.toString()
            binding.priceView.text = it.price.toString()
            binding.yearView11.text = it.year.toString()
            binding.linkView.text = it.link
            binding.pageView.text = it.pages.toString()
            binding.titleView3.text = it.title
            binding.textView5.text = it.delivery.toString()
            Picasso.get().load(it.imageLink).into(binding.imageView2)

            fun email() {

                val intent = Intent(Intent.ACTION_SEND)
                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("ventas@anchoBook.cl"))
                intent.putExtra(Intent.EXTRA_SUBJECT, "Consulta por Libro ${it.title} , ID : ${it.id} ")
                intent.putExtra(
                        Intent.EXTRA_TEXT, " “Hola\n" +
                        "Vi el Libro ${it.title} de código ${it.id} y me gustaría que me contactaran a este correo o al\n" +
                        "siguiente número ___________")
                intent.type = "message/rfc822"
                startActivity(Intent.createChooser(intent, "Escoja el mail del cliente"))
            }

            binding.floatingActionButton.setOnClickListener { view ->
                Snackbar.make(view, "Email", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show()
                email()
            }
        })
        return binding.root
    }
}
