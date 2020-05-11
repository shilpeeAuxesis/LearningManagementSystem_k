package com.learningmanagement.parent_account.myspace

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MySpaceParentViewModel : ViewModel() {
    private lateinit var mDisposible: Disposable
    var name: MutableLiveData<ArrayList<String>> = MutableLiveData()
    private val mTypeOfDuration: ArrayList<String> = arrayListOf<String>(
        "Type of level",
        "Level 1",
        "Level 2",
        "Level 3",
        "Level 4",
        "Level 5",
        "Level 6"
    )

  /*  private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
*/
    fun getTypeOfDuration() {
        Flowable.just(mTypeOfDuration)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { value -> name.value = value }, // onNext println("Received: $value")
                { error -> println("Error: $error") },    // onError
                { println("Completed!") }                 // onComplete
            )
    }

    val mName: LiveData<ArrayList<String>> = name


}



