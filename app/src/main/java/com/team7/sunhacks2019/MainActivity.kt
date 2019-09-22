package com.team7.sunhacks2019

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.esri.arcgisruntime.mapping.ArcGISMap
import com.esri.arcgisruntime.mapping.Basemap
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create an ArcGISMap with the BasemapType topographic
        val map = ArcGISMap(Basemap.Type.TOPOGRAPHIC,
                34.056295,
                -117.195800,
                16)

        // set the map to be displayed in the layout's MapView
        mapView.map = map
    }

    override fun onPause() {
        //override pause behavior to include pausing mapView
        super.onPause()
        mapView.pause()
    }
    override fun onResume() {
        //override resume behavior to include resuming mapView
        super.onResume()
        mapView.resume()
    }
    override fun onDestroy() {
        //override destroy behavior to include destroying mapView
        super.onDestroy()
        mapView.dispose()
    }
}
