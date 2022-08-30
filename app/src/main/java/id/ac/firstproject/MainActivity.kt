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
    private lateinit var tvDaftar: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //menghubungkan class MainActivity dengan XML Layout
        txtNamaBarang=findViewById(R.id.editTextNamaBarang)
        txtHargaBarang=findViewById(R.id.editTextHargaBarang)
        txtHasil=findViewById(R.id.txtHasil)
        txtHasil.setText("")
        btnAdd=findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener(this) //saat tombol di click akan memanggil onClick
        tvDaftar = findViewById(R.id.textViewDaftar)
        tvDaftar.text = "0"
    }
    override fun onClick(p0: View?) {
        //penanganan kalau ada yg di click
        var str = tvDaftar.text.toString()
        var total = str.toInt()+1
        tvDaftar.text  = total.toString()
        txtHasil.append(txtNamaBarang.text.toString().trim().uppercase()+","+txtHargaBarang.text.toString()+"\n")
        Toast.makeText(this,"total:"+total,Toast.LENGTH_SHORT).show()
    }
}