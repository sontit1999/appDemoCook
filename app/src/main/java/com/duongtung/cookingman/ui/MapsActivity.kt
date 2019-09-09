package com.duongtung.cookingman.ui
import androidx.lifecycle.Observer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.duongtung.cookingman.R
import com.duongtung.cookingman.adapter.PostAdapter
import com.duongtung.cookingman.model.*

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        setImage()
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(21.030870, 105.801420)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Cầu giấy"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,14f))
    }
    fun setImage(){
        var iv1:ImageView = findViewById<ImageView>(R.id.iv_imagefood)
        var iv2:ImageView = findViewById<ImageView>(R.id.iv_imagefood2)
        var iv3:ImageView = findViewById<ImageView>(R.id.iv_imagefood3)
        Glide.with(this).load("http://s3.amazonaws.com/img.kh-labs.com/YCkKyw5c5db1162a2011.16707076").into(iv1)
        Glide.with(this).load("https://www.dilettante.com/resize/images/cafe/MenuDessertsIceCream/Classic-Dilettante-Coupe.jpg?bw=575&w=575").into(iv2)
        Glide.with(this).load("https://previews.123rf.com/images/hansgeel/hansgeel1801/hansgeel180100165/92630477-artisan-chocolate-ice-cream-with-sauce-truffles-and-scrapings.jpg").into(iv3)
    }
}
