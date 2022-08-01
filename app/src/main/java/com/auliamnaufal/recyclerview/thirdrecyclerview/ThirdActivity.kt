package com.auliamnaufal.recyclerview.thirdrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.auliamnaufal.recyclerview.R
import com.auliamnaufal.recyclerview.databinding.ActivityThirdBinding
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.nio.charset.StandardCharsets

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    private var modelPahlawan: MutableList<ModelPahlawan> = ArrayList()
    lateinit var pahlawanAdapter: PahlawanAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.rvListPahlawan.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ThirdActivity)

        }

        getList()

    }

    fun getList() {
        try {
            //membuka file JSON
            val stream = assets.open("pahlawan_nasional.json")
            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            val stringContent = String(buffer, StandardCharsets.UTF_8)

            try {
                val jsonObject = JSONObject(stringContent)
                val jsonArray = jsonObject.getJSONArray("daftar_pahlawan")
                for (i in 0 until jsonArray.length()) {
                    val jsonObjectData = jsonArray.getJSONObject(i)
                    val dataApi = ModelPahlawan()
                    dataApi.nama = jsonObjectData.getString("nama")
                    dataApi.namaLengkap = jsonObjectData.getString("nama2")
                    dataApi.image = jsonObjectData.getString("img")
                    modelPahlawan.add(dataApi)
                }
                pahlawanAdapter = PahlawanAdapter(modelPahlawan)
                binding.rvListPahlawan.adapter = pahlawanAdapter

            } catch (e: JSONException) {
                e.printStackTrace()
            }

        } catch (e: JSONException) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()

        }
    }
}