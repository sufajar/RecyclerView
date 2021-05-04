package com.sufajar.myrecyclerview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.sufajar.myrecyclerview.adapter.RecyclearviewAdapter
import com.sufajar.myrecyclerview.databinding.ActivityMainBinding
import com.sufajar.myrecyclerview.databinding.DetailDataPemainBinding
import com.sufajar.myrecyclerview.model.PemainBola
import kotlinx.android.synthetic.main.detail_data_pemain.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root);

        val ListPemain = ArrayList<PemainBola>()
        ListPemain.add(PemainBola("Thibaut Courtois",R.drawable.courtois,"Penjaga Gawang","2.00 m","Bree (Belgia)","11 Mei 1992"))
        ListPemain.add(PemainBola("Karim Benzema",R.drawable.benzema,"Penyerang","1,85 m","Lyon (Perancis)","19 Desember 1987"))
        ListPemain.add(PemainBola("Marcelo Vieira da Silva",R.drawable.marcello,"Belakang","1,74 m","Rio de Janeiro (Brasil)","12 Mei 1988"))
        ListPemain.add(PemainBola("Sergio Ramos García",R.drawable.ramos,"Belakang","1,84 m","Camas (Sevilla)","30 Maret 1986"))
        ListPemain.add(PemainBola("Zinedine Yazid Zidane",R.drawable.zidan,"Pelatih","1,85 m","Marseille (Prancis)","23 Juni 1972"))

        binding.List.adapter = RecyclearviewAdapter(this,ListPemain,object : RecyclearviewAdapter.OnClickListener{
            override fun detailData(item: PemainBola?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                      val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama  = this.findViewById<TextView>(R.id.txt_namapemain)
                    val posisi = this.findViewById<TextView>(R.id.txt_posisi)
                    val tinggi = this.findViewById<TextView>(R.id.txt_tinggibadan)
                    val tempatlahir = this.findViewById<TextView>(R.id.txt_tempatlahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txt_tanggallahir)




                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"

                    btnClose.setOnClickListener{
                        this.dismiss()
                    }

                }.show()
            }
        })


    }
}