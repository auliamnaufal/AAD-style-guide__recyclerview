package com.auliamnaufal.recyclerview.thirdrecyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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
        val stringContent = getJSONObject()

        try {
            val jsonArray = JSONArray(stringContent)

            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val jsonItemObject = jsonObject.getJSONObject("batters")
                val jsonArrayItem = jsonItemObject.getJSONArray("batter")

                for (j in 0 until jsonArrayItem.length()) {
                    val jsonObjectData = jsonArrayItem.getJSONObject(j)
                    val dataApi = ModelPahlawan()
                    dataApi.nama = jsonObjectData.getString("id")
                    dataApi.namaLengkap = jsonObjectData.getString("type")
                    dataApi.image = jsonObjectData.getString("type")
                    modelPahlawan.add(dataApi)
                }
            }


            pahlawanAdapter = PahlawanAdapter(modelPahlawan)
            binding.rvListPahlawan.adapter = pahlawanAdapter

        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    fun getJSONObject(): String {
        return try {
            assets.open("cake.json").bufferedReader().readText()
//            val size = stream.available()
//            val buffer = ByteArray(size)
//            stream.read(buffer)
//            stream.close()
//
//            String(buffer, StandardCharsets.UTF_8)

        } catch (e: JSONException) {
            Toast.makeText(this, "Opps, coba lagi", Toast.LENGTH_SHORT).show()
            ""
        }

    }
}