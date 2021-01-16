package cl.anchorbooks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import cl.anchorbooks.databinding.FragmentDetailBinding
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
            Picasso.get().load(it.imageLink).into(binding.imageView2)
            //falta delivery
        })
        return binding.root
    }
}
