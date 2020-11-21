package com.example.pulseanimation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    private lateinit var startBtn: Button
    private lateinit var stopBtn: Button
    private lateinit var animationImage: ImageView
    private lateinit var animationImage2: ImageView
    private lateinit var animationHandler: Handler
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        startBtn = findViewById(R.id.startBtn)
        stopBtn = findViewById(R.id.stopBtn)
        animationImage = findViewById(R.id.backgroundCircle)
        animationImage2 = findViewById(R.id.backgroundCircle2)
        animationHandler = Handler(Looper.getMainLooper())

        startBtn.setOnClickListener {
            startSchedulerAnimation()
        }

        stopBtn.setOnClickListener {
            compositeDisposable.clear()
        }
    }

    private fun startSchedulerAnimation() {
        val disposable = Observable.interval(1500, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { runAnimation() }
            .subscribe(
                {
                    Log.d("animationSuccess","success")
                }, {
                    Log.e("animationError","Error"+it.message)
                }
            )
        compositeDisposable.add(disposable)
    }

    private fun runAnimation() {
        animationImage.animate().scaleX(4f).scaleY(4f).alpha(0f).setDuration(1000).withEndAction {
            with(animationImage) {
                scaleX = 1f
                scaleY = 1f
                alpha = 1f
            }
        }
        animationImage2.animate().scaleX(4f).scaleY(4f).alpha(0f).setDuration(700).withEndAction {
            with(animationImage2) {
                scaleX = 1f
                scaleY = 1f
                alpha = 1f
            }
        }
    }
}