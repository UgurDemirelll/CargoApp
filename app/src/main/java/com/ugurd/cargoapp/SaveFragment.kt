package com.ugurd.cargoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_save.*
import kotlinx.android.synthetic.main.fragment_save.view.*

class SaveFragment : Fragment() {

    private val kargolar = ArrayList<String>()
    private lateinit var veriadapter:ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val view = inflater.inflate(R.layout.fragment_save, container, false)
        kargolar.add("hepsijet")
        kargolar.add("mngKargo")
        kargolar.add("pttKargo")
        kargolar.add("suratKargo")
        context?.let {
            veriadapter = ArrayAdapter(it,android.R.layout.simple_list_item_1,android.R.id.text1,kargolar)
            view.spinnerCargo.adapter = veriadapter

        }


        view.buttonSave.setOnClickListener {
            //butona tıklandığında firebase kaydı yapılacak

            var kargoAdi = kargolar[view.spinnerCargo.selectedItemPosition]
            var takipNo = view.textCargoNo.text.toString()
            val database = FirebaseDatabase.getInstance()
            val refCargo = database.getReference(kargoAdi)

            //firebase kaydı
            try {
                if(kargoAdi == "hepsijet"){
                    println("hepsijet kaydı")
                    val kargo = hepsijet(takipNo,0,0,"","","")
                    refCargo.push().setValue(kargo)
                }
                if(kargoAdi == "mngKargo"){
                    val kargo = mngKargo(takipNo,0,0,"","","")
                    refCargo.push().setValue(kargo)
                }
                if(kargoAdi == "pttKargo"){
                    val kargo = pttKargo(takipNo,0,0,"","","")
                    refCargo.push().setValue(kargo)
                }
                if(kargoAdi == "suratKargo"){
                    val kargo = suratKargo(takipNo,0,0,"","","")
                    refCargo.push().setValue(kargo)
                }
            }catch (e : Exception){
                e.printStackTrace()
            }






        }
        return view
    }


}