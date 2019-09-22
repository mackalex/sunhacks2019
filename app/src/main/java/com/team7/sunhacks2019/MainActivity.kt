package com.team7.sunhacks2019

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.esri.arcgisruntime.mapping.ArcGISMap
import com.esri.arcgisruntime.mapping.ArcGISScene
import com.esri.arcgisruntime.mapping.Basemap
import kotlinx.android.synthetic.main.activity_main.*
import com.esri.arcgisruntime.portal.PortalItem
import com.esri.arcgisruntime.portal.Portal



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create an ArcGISMap with the BasemapType topographic
        // val scene3d = ArcGISScene("https://sunhacks2019.maps.arcgis.com/home/webscene/viewer.html?webscene=bbab9e7966f8444c8d5a79a807e34124")

        // Initialize the portal with ArcGIS Online
        val portal = Portal("http://www.arcgis.com")

        // Get the portal item
        val portalItem = PortalItem(portal, "bbab9e7966f8444c8d5a79a807e34124")

        // Create the scene from the portal item
        val scene3d = ArcGISScene(portalItem)

        sceneView.setScene(scene3d);
    }

    override fun onPause() {
        //override pause behavior to include pausing mapView
        super.onPause()
        sceneView.pause()
    }
    override fun onResume() {
        //override resume behavior to include resuming mapView
        super.onResume()
        sceneView.resume()
    }
    override fun onDestroy() {
        //override destroy behavior to include destroying mapView
        super.onDestroy()
        sceneView.dispose()
    }
}
