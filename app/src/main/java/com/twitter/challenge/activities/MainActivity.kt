package com.twitter.challenge.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.twitter.challenge.R
import com.twitter.challenge.databinding.ActivityMainBinding
import com.twitter.challenge.helpers.TemperatureConverter
import com.twitter.challenge.repository.entities.LoadResult
import com.twitter.challenge.repository.entities.WeatherInfo
import com.twitter.challenge.viewmodel.MainScreenViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModel<MainScreenViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.currentWeatherLiveData.observe(this) {
            if(it != null) updateCurrentWeatherViews(it)
        }
        viewModel.currentWeatherLoading.observe(this) {
            binding.todayWeatherViews.isVisible = it == LoadResult.SUCCESS
            binding.currentWeatherProgressBar.isVisible = it == LoadResult.LOADING
            binding.showDeviation.isEnabled = it == LoadResult.SUCCESS
            binding.errorLoadingCurrentWeather.isVisible = it == LoadResult.FAILURE
        }
        viewModel.deviationLiveData.observe(this) {
            if(it != null) updateDeviationViews(it)
        }
        viewModel.deviationLoading.observe(this) {
            binding.deviationViews.isVisible = it == LoadResult.SUCCESS
            binding.deviationProgressBar.isVisible = it == LoadResult.LOADING
            binding.errorLoadingDeviation.isVisible = it == LoadResult.FAILURE
        }

        binding.showDeviation.setOnClickListener { viewModel.getDeviation() }

        if(savedInstanceState == null) viewModel.fetchCurrentWeather()
    }

    private fun updateCurrentWeatherViews(info: WeatherInfo) {
        binding.temperature.text = getString(R.string.temperature, info.temperature, TemperatureConverter.celsiusToFahrenheit(info.temperature))
        binding.windSpeed.text = getString(R.string.wind_speed, info.windSpeed)
        binding.imageCloud.isVisible = info.showCloudIcon()
    }

    private fun updateDeviationViews(deviationValue: Float) {
        binding.deviation.text = String.format("%.2f", deviationValue)
    }
}