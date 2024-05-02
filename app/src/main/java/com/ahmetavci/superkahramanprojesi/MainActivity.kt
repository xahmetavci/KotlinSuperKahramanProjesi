package com.ahmetavci.superkahramanprojesi

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //Scope - Kapsam
    var numara = 0
    private var isim = ""
    private var yas : Int? = null
    private var meslek = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        numara = 15
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    fun SuperKahramanYap(view: View){ //SuperKahramanYap fonskiyonumu onCreate fonksiyonu içinde çağırmadım sebebi ise layout(Tasarım) kısmından "onClik" özelliğini kullanıdğımız için

        numara = 45

        var isimgirdisi = findViewById<EditText>(R.id.isimText)
        var yasgirdisi = findViewById<EditText>(R.id.yasText)
        var meslekgirdisi = findViewById<EditText>(R.id.meslekText)
        var sonuc = findViewById<TextView>(R.id.sonucText)


        isim = isimgirdisi.text.toString()
        yas = yasgirdisi.text.toString().toIntOrNull()
        meslek = meslekgirdisi.text.toString()

        if(yas==null){
             sonuc.text = "Doğru Yaşı Giriniz"
        }else{
            val superkahraman = SuperKahraman(isim,yas!!,meslek)

            sonuc.text = "İsim: ${superkahraman.isim}, Yaş: ${superkahraman.yas}, Meslek: ${superkahraman.meslek}"

        }

    }

}