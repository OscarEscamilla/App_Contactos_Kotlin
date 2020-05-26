package com.example.contactosapp.Views.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.contactosapp.Models.Contacto
import com.example.contactosapp.R
import kotlinx.android.synthetic.main.item_list_contacto.view.*

class ContactosAdapter(contexto: Context, items: ArrayList<Contacto>): BaseAdapter(){

    var items: ArrayList<Contacto>? = null
    var contexto: Context? = null

    init {
        this.items = items
        this.contexto = contexto
    }


    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder: ViewHolder? = null
        var vista: View? = convertView

        if (vista == null){
            vista = LayoutInflater.from(contexto).inflate(R.layout.item_list_contacto, null)
            holder = ViewHolder(vista)
            vista.tag = holder
        }else{
            holder = vista.tag as ViewHolder?
        }

        val item = getItem(position) as Contacto

        // ASIGNACION DE VALORES A ELEMNTOS GRAFICOS DE ITEM
        holder!!.tv_nombre!!.text = """${item.nombre} ${item.apellidos}"""
        holder!!.tv_empresa!!.text = item.empresa
        holder!!.Image_contacto?.setImageResource(item.foto)

        return vista!!
    }

    override fun getItem(position: Int): Any {
        return this.items!!.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return this.items!!.count()
    }

    private class ViewHolder(v: View){

        var Image_contacto: ImageView? = null
        var tv_nombre: TextView? = null
        var tv_empresa: TextView? = null

        init {
            this.Image_contacto = v.findViewById(R.id.image_contacto)
            this.tv_nombre = v.findViewById(R.id.tv_nombre)
            this.tv_empresa = v.findViewById(R.id.tv_empresa)
        }
    }
}