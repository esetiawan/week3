package id.ac.firstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.security.AccessController.getContext

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var txtNamaBarang: EditText
    private lateinit var txtHargaBarang:EditText
    private lateinit var txtHasil:EditText
    private lateinit var btnAdd: Button
    private lateinit var btnClear: Button
    private lateinit var btnLoad: Button
    private lateinit var tvDaftar: TextView
    val dataBarang: ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //menghubungkan class MainActivity dengan XML Layout
        txtNamaBarang=findViewById(R.id.editTextNamaBarang)
        txtHargaBarang=findViewById(R.id.editTextHargaBarang)
        txtHasil=findViewById(R.id.txtHasil)
        txtHasil.setText("")
        btnAdd=findViewById(R.id.btnAdd)
        btnClear=findViewById(R.id.btnClear)
        btnLoad=findViewById(R.id.btnLoad)
        btnAdd.setOnClickListener(this) //saat tombol di click akan memanggil onClick
        btnClear.setOnClickListener(this)
        tvDaftar = findViewById(R.id.textViewDaftar)
        tvDaftar.text = "0"

        btnLoad.setOnClickListener {
            txtHasil.setText("")
            for(b in dataBarang)
            {
                txtHasil.append("${b.uppercase()} \n")
            }
        }
    }
    fun addBarang(newItem: String) {
        dataBarang.add(newItem)
    }
    override fun onClick(p0: View?) {
        if (p0?.id==R.id.btnAdd) {
            //penanganan kalau ada yg di click
            var str = tvDaftar.text.toString()
            var total = str.toInt() + 1
            tvDaftar.text = total.toString()
            var newBarang = txtNamaBarang.text.toString().
                    trim().uppercase() + "," +
                    txtHargaBarang.text.toString()
            txtHasil.append("$newBarang \n")
            addBarang("Barang: $newBarang")
            Toast.makeText(this, "total:" + total, Toast.LENGTH_SHORT).show()
        }
        else if (p0?.id==R.id.btnClear)
        {
            txtHasil.setText("")
            tvDaftar.text = "0"
        }
    }
}