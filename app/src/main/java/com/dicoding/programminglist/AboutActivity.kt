package com.dicoding.programminglist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mehdi.sakout.aboutpage.AboutPage
import mehdi.sakout.aboutpage.Element


class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("About")
        val aboutPage = AboutPage(this)
            .isRTL(false)
            .enableDarkMode(false)
            .setImage(R.drawable.my_image)
            .addItem(Element().setTitle("Belajar Fundamental Aplikasi Android"))
            .addEmail("syahriful@ummi.ac.id","Email: syahriful@ummi.ac.id")
            .setDescription("Name : Syahriful H")
            .create()
        setContentView(aboutPage)
    }
}