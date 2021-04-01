package com.dicoding.programminglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(){
    private var list: ArrayList<Lang> = arrayListOf()
    private var title: String = "Programming List"
    private lateinit var rviewProglang: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rviewProglang = findViewById(R.id.rView_ProgLang)
        rviewProglang.setHasFixedSize(true)

        list.addAll(LangData.listData)
        showRecyclerCardView()
    }

    private fun setActionBarTitle(title: String){
        supportActionBar?.title = title
    }

    private fun showSelectedLang(lang: Lang) {
        Toast.makeText(this, lang.name, Toast.LENGTH_SHORT).show()
    }

    //==============================================================================================
    // Bagian show Recycler Card
    private fun showRecyclerCardView() {
        rviewProglang.layoutManager = GridLayoutManager(this, 2)
        val cardViewHeroAdapter = CardHeroAdapter(list)
        rviewProglang.adapter = cardViewHeroAdapter

        cardViewHeroAdapter.setOnItemClickCallback(object : CardHeroAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Lang) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.EXTRA_PHOTO, data.photo)
                    putExtra(DetailActivity.EXTRA_NAME, data.name)
                    putExtra(DetailActivity.EXTRA_DESIGNED, data.designed)
                    putExtra(DetailActivity.EXTRA_VERSION, data.currentVer)
                    putExtra(DetailActivity.EXTRA_RELEASED, data.firstReleased)
                    putExtra(DetailActivity.EXTRA_NAMEEXTENSION, data.nameExtens)
                    putExtra(DetailActivity.EXTRA_WEBSITE, data.webSite)
                    putExtra(DetailActivity.EXTRA_DESCRIPTION, data.descript)
                }

                startActivity(intent)

                showSelectedLang(data)
            }
        })
    }
    //==============================================================================================

    //==============================================================================================
    // Bagian Menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean{
        menuInflater.inflate(R.menu.menu_layout, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int?) {
        when(selectedMode){
            R.id.action_card -> {
                title = "Programming List"
                showRecyclerCardView()
            }
            R.id.action_about -> {
                showAbout()
            }
        }
        setActionBarTitle(title)
    }
    //==============================================================================================
//     Bagian About
    private fun showAbout() {
        val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(moveIntent)
    }
}