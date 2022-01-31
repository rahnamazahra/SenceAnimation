package com.example.senceanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Scene
import android.transition.Transition
import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.security.AccessController.getContext

class MainActivity : AppCompatActivity() {

    private  lateinit var  transition:Transition
    private  lateinit var  scene1:Scene
    private  lateinit var  scene2:Scene
    private  lateinit var  currentScene:Scene

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scene1=Scene.getSceneForLayout(scene_root,R.layout.scene1,this)
        scene2=Scene.getSceneForLayout(scene_root,R.layout.scene2,this)

        transition=TransitionInflater.from(this).inflateTransition(R.transition.linear)

        scene1.enter()

        currentScene=scene1
    }

    fun clickScene(view: View){
        currentScene= if(currentScene==scene1){
               TransitionManager.go(scene2,transition)
                scene2
        }else{
               TransitionManager.go(scene1,transition)
                scene1
        }
    }
}