package com.auliamnaufal.recyclerview.fifthrecyclerview

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.auliamnaufal.recyclerview.databinding.ActivityFifthBinding
import com.auliamnaufal.recyclerview.databinding.ActivityThirdBinding
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.StandardCharsets

class FifthActivity : AppCompatActivity() {


    private var modelCake = ArrayList<BatterItem>()

    private var _binding: ActivityFifthBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityFifthBinding.inflate(layoutInflater)

        setContentView(binding.root)

        getModelCake()

        binding.rvCake.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@FifthActivity)
            adapter = CakeAdapter(modelCake)
        }

    }

    fun getModelCake() {
        val json = getJSONObject()
        try {
            val getRootJson = JSONArray(json)
            for (i in 0 until getRootJson.length()) {
                val getBatter = getRootJson.getJSONObject(i)
                    .getJSONObject("batters")
                    .getJSONArray("batter")

                for (j in 0 until getBatter.length()) {
                    val batterItem = getBatter.getJSONObject(j)
                    val dataJson = BatterItem(
                        id = batterItem.getString("id"),
                        type = batterItem.getString("type")
                    )
                    modelCake.add(dataJson)
                }
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun getJSONObject(): String? {
        return try {
            assets.open("cake.json").bufferedReader().readText()

        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

}