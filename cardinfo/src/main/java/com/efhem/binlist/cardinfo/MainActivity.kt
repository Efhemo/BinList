package com.efhem.binlist.cardinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.lifecycleScope
import com.efhem.binlist.cardinfo.databinding.ActivityMainBinding
import com.efhem.binlist.cardinfo.model.CardViewState
import com.efhem.binlist.cardinfo.presentation.MainViewModel
import com.efhem.binlist.core.ext.getColorResId
import com.efhem.binlist.core.view_binding.viewBinding
import com.efhem.binlist.domain.model.CardInfo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private val bind: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { uiState ->
                when (uiState) {
                    is CardViewState.Success -> bindView(uiState.cardInfo)
                    is CardViewState.Error -> handleError(uiState.message)
                    is CardViewState.Loading -> bind.progressBar.visibility = View.VISIBLE
                }
            }
        }

        bind.inputDigitTve.editText?.doAfterTextChanged { editable ->
            val text = editable.toString().trim()
            val input = text.toIntOrNull()
            if (input != null && text.length > 5) {
                viewModel.setCardDigit(input.toLong())
            }
        }
    }

    private fun handleError(message: String?){
        if (message != null){
            bind.displayError.text = message
            bind.displayError.visibility = View.VISIBLE
        } else bind.displayError.visibility = View.GONE

        bind.progressBar.visibility = View.GONE
    }

    private fun bindView(cardInfo: CardInfo?) {
        handleError(null)
        bind.apply {
            scheme.text = cardInfo?.scheme ?: "?"
            brand.text = cardInfo?.brand ?: "?"
            length.text = cardInfo?.length?.toString() ?: "?"
            country.text = getString(R.string.emoji_country, cardInfo?.emoji ?: "", cardInfo?.countryName ?: "?")
            location.text = getString(R.string.lat_lng, cardInfo?.latitude?: "?", cardInfo?.latitude?: "?")
            fullNameCity.text = getString(R.string.name_city, cardInfo?.bankName?: "?", cardInfo?.city?: "?")
            url.text = cardInfo?.url ?: "?"
            phone.text = cardInfo?.phone ?: "?"

            if(cardInfo?.type == null){
                debit.setTextColor(getColorResId(R.color.grey))
                credit.setTextColor(getColorResId(R.color.grey))
            }else {
                if (cardInfo.type == "debit" ) {
                    debit.setTextColor(getColorResId(R.color.black))
                    credit.setTextColor(getColorResId(R.color.grey))
                }else {
                    debit.setTextColor(getColorResId(R.color.grey))
                    credit.setTextColor(getColorResId(R.color.black))
                }
            }

            if(cardInfo?.prepaid == null){
                yes.setTextColor(getColorResId(R.color.grey))
                no.setTextColor(getColorResId(R.color.grey))
            }else {
                if (cardInfo.prepaid == true) {
                    yes.setTextColor(getColorResId(R.color.black))
                    no.setTextColor(getColorResId(R.color.grey))
                }else {
                    yes.setTextColor(getColorResId(R.color.grey))
                    no.setTextColor(getColorResId(R.color.black))
                }
            }

            if(cardInfo?.luhn == null){
                luhnYes.setTextColor(getColorResId(R.color.grey))
                luhnNo.setTextColor(getColorResId(R.color.grey))
            }else {
                if (cardInfo.luhn == true) {
                    luhnYes.setTextColor(getColorResId(R.color.black))
                    luhnNo.setTextColor(getColorResId(R.color.grey))
                }else {
                    luhnYes.setTextColor(getColorResId(R.color.grey))
                    luhnNo.setTextColor(getColorResId(R.color.black))
                }
            }
            progressBar.visibility = View.GONE
        }
    }
}