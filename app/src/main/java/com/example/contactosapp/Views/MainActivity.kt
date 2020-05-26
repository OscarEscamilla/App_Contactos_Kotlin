package com.example.contactosapp.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.contactosapp.Models.Contacto
import com.example.contactosapp.R
import com.example.contactosapp.Views.Adapters.ContactosAdapter

class MainActivity : AppCompatActivity() {

    var toolbar : Toolbar? = null

    var contactos: ArrayList<Contacto>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init Toolbar
        toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        initListView()


    }

    fun initListView(){
        contactos = ArrayList()
        contactos?.add(Contacto("Oscar", "Escamilla", "Xiimbal",
            "Jaltepec", "7751306548","escamilla@gmail.com", 22, 70.25f, R.drawable.foto_01))
        contactos?.add(Contacto("Martin", "Diaz", "INE",
            "Tulancingo", "7751694525","diaz@gmail.com", 23, 75.25f, R.drawable.foto_02))
        contactos?.add(Contacto("Eduardo", "Ortega", "Ninguna",
            "Huasca", "7751306548","ortega@gmail.com", 22, 80.25f, R.drawable.foto_03))

        var adapter_contatos = ContactosAdapter(this, contactos!!)

        var lv_contactos: ListView = findViewById(R.id.lv_contactos)

        lv_contactos.adapter = adapter_contatos
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar_main, menu)

        //val search = menu?.findItem(R.id.item_app_bar_search) as SearchView

        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.item_nuevo -> {
                Toast.makeText(this, "clicked add", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)

    }
}
