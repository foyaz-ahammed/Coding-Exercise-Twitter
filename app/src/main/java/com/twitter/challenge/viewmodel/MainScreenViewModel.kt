package com.twitter.challenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.twitter.challenge.repository.Repository
import com.twitter.challenge.repository.entities.DataResult
import com.twitter.challenge.repository.entities.LoadResult
import com.twitter.challenge.repository.entities.WeatherInfo
import kotlinx.coroutines.launch

class MainScreenViewModel(private val repository: Repository): ViewModel() {
    private val _currentWeatherLiveData = MutableLiveData<WeatherInfo>()
    private val _currentWeatherLoading = MutableLiveData(LoadResult.Initial)
    private val _deviationLiveData = MutableLiveData<Float>()
    private val _deviationLoading = MutableLiveData(LoadResult.Initial)

    val currentWeatherLiveData: LiveData<WeatherInfo>
        get() = _currentWeatherLiveData
    val currentWeatherLoading: LiveData<LoadResult>
        get() = _currentWeatherLoading
    val deviationLiveData: LiveData<Float>
        get() = _deviationLiveData
    val deviationLoading: LiveData<LoadResult>
        get() = _deviationLoading

    fun fetchCurrentWeather() {
        _currentWeatherLoading.value = LoadResult.LOADING
        viewModelScope.launch {
            when(val result = repository.getCurrentWeather()) {
                is DataResult.Success -> {
                    _currentWeatherLiveData.value = result.data
                    _currentWeatherLoading.value = LoadResult.SUCCESS
                }
                is DataResult.Failure -> {
                    _currentWeatherLoading.value = LoadResult.FAILURE
                }
            }
        }
    }

    fun getDeviation() {
        viewModelScope.launch {
            _deviationLoading.value = LoadResult.LOADING
            when(val result = repository.getDeviation()) {
                is DataResult.Success -> {
                    _deviationLiveData.value = result.data
                    _deviationLoading.value = LoadResult.SUCCESS
                }
                is DataResult.Failure -> {
                    _deviationLoading.value = LoadResult.FAILURE
                }
            }
        }
    }
}