package com.example.pinboardassignment.viewmodels

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pinboardassignment.model.PinBoardResponse
import com.example.pinboardassignment.network.GenericRepository
import com.example.pinboardassignment.network.HandleResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * @author: SundravelS
 *
 * @desc: Below shared View model is used to hold pin board response
 */

@HiltViewModel
class PinBoardViewModel @Inject constructor(private val repository: GenericRepository) : ViewModel() {

    private val _arrPinBoardResponse = MutableLiveData<HandleResponse<PinBoardResponse>>()
    var arrPinBoardResponse: LiveData<HandleResponse<PinBoardResponse>> = _arrPinBoardResponse


    val _bitmap = MutableLiveData<Bitmap>()
    val bitmap: LiveData<Bitmap> = _bitmap

    //Exception handler to catch any exception thrown while calling API
    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        _arrPinBoardResponse.value =
            HandleResponse.parseResponse(null, tClass = PinBoardResponse::class.java)
    }


    fun callAPI(sUrl: String) {
        viewModelScope.launch(exceptionHandler) {
            _arrPinBoardResponse.value = repository.callAPI(
                sUrl = sUrl,
                tClass = PinBoardResponse::class.java,
                bJsonArray = true
            )
        }
    }


}