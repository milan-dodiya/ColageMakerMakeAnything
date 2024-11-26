package com.collagemaker_makeanything.Activity

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.canhub.cropper.CropImageView
import com.collagemaker_makeanything.Adapter.TabAdapter
import com.collagemaker_makeanything.Fragment.RatioFragment
import com.collagemaker_makeanything.R
import com.collagemaker_makeanything.databinding.ActivityImageCollageBinding
import com.google.android.material.tabs.TabLayout

class ImageCollageActivity : BaseActivity(), RatioFragment.OnLayoutSelectedListener {

    lateinit var binding: ActivityImageCollageBinding

    private lateinit var imageUris: ArrayList<String>
  //  private var layoutRes: Int = R.layout.item_gallery_image

    private lateinit var selectedImages: ArrayList<String>
  private var seletedLayout: Int = R.layout.collage2_1

    companion object{
        var imageCount : Int? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageCollageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Receive the data from the previous activity
        imageUris = intent.getStringArrayListExtra("imageUris") ?: arrayListOf()
   //    layoutRes = intent.getIntExtra("layoutRes", R.layout.item_gallery_image)
        imageCount = intent.getIntExtra("imageCount", 0)


        selectedImages = intent.getStringArrayListExtra("selectedImages") ?: arrayListOf()
//        seletedLayout = intent.getIntExtra("selectedLayout", R.layout.default_layout)

        // Get default layout based on image count
        seletedLayout = getDefaultLayoutForImageCount(imageCount ?: 0)


        val selectedImageStrings = intent.getStringArrayListExtra("selectedImages") ?: arrayListOf()
        val selectedImageUris = selectedImageStrings.map { Uri.parse(it) }

        Log.e("selectedImageUris", "selectedImageUrisss: "+selectedImageStrings )

        // Load default collage layout
        loadCollageLayouts(seletedLayout,selectedImageUris)

        initView()
    }

    private fun getDefaultLayoutForImageCount(count: Int): Int {
        return when (count) {
            2 -> R.layout.collage2_1
            3 -> R.layout.collage3_1
            4 -> R.layout.collage4_1
            5 -> R.layout.collage5_1
            6 -> R.layout.collage6_1
            7 -> R.layout.collage7_1
            8 -> R.layout.collage8_1
            9 -> R.layout.collage9_1
            10 -> R.layout.collage10_1
            else -> R.layout.collage2_1 // Default fallback layout
        }
    }

    private fun initView() {



        val ratioFragment = RatioFragment.newInstance(imageUris.toString())
        ratioFragment.listener = this

        binding.imgDone.setOnClickListener {
            onBackPressed()
        }

        binding.imgDone.setOnClickListener {
            // If the user is in collage mode, go to CollagePhotoEditingActivity
            val intent = Intent(this, CollagePhotoEditingActivity::class.java)
            //intent.putStringArrayListExtra("imageUris", ArrayList(selectedImagesList.map { it.toString() }))
            startActivity(intent)
            finish()
        }



        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.tab_ratio))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.tab_layout))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.tab_margin))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText(R.string.tab_border))

        binding.viewpager.addOnPageChangeListener(object :
            TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout) {})

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    binding.viewpager.currentItem = tab.position
                }

                // Show ImageView and hide CropImageView for `Layout`, `Margin`, and `Border` tabs
                if (tab!!.position == 1 || tab.position == 2 || tab.position == 3) {
                    binding.imglayoutSelectImages.visibility = View.VISIBLE
                    binding.collageContainer.visibility = View.GONE
                } else {
                    binding.imglayoutSelectImages.visibility = View.GONE
                    binding.collageContainer.visibility = View.VISIBLE
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
        loadImageIntoCropView()
        val myAdapter = TabAdapter(supportFragmentManager, imageUris.toString(), imageCount!!)
        binding.viewpager.adapter = myAdapter
    }

    // New method to update layout
    fun updateCollageLayout(newLayout: Int, selectedImageUrisAsStrings: List<String>) {
        seletedLayout = newLayout
        val selectedImageUris = selectedImageUrisAsStrings.map { Uri.parse(it) }
        loadCollageLayouts(seletedLayout, selectedImageUris)
    }


    private fun loadCollageLayouts(seletedLayout: Int, selectedImageUris: List<Uri>) {
        try {
            // Inflate the selected layout
            val stub = layoutInflater.inflate(seletedLayout, null)

            // Clear any existing views
            binding.imglayoutSelectImages.removeAllViews()

            // Add the inflated layout
            binding.imglayoutSelectImages.addView(stub)

            // Arrange the selected images in the layout
            arrangeImagesInLayout(selectedImageUris, stub)

            // Make sure the layout is visible
            binding.imglayoutSelectImages.visibility = View.VISIBLE
            binding.collageContainer.visibility = View.GONE

        } catch (e: Exception) {
            Log.e("ImageCollageActivity", "Error loading collage layout: ${e.message}")
        }
    }

    private fun arrangeImagesInLayout(imageUris: List<Uri>, view: View) {
        try {
            val imageViews = listOf(
                view.findViewById<ImageView>(R.id.imageView1),
                view.findViewById<ImageView>(R.id.imageView2),
                view.findViewById<ImageView>(R.id.imageView3),
                view.findViewById<ImageView>(R.id.imageView4),
                view.findViewById<ImageView>(R.id.imageView5),
                view.findViewById<ImageView>(R.id.imageView6),
                view.findViewById<ImageView>(R.id.imageView7),
                view.findViewById<ImageView>(R.id.imageView8),
                view.findViewById<ImageView>(R.id.imageView9),
                view.findViewById<ImageView>(R.id.imageView10)
            )

            imageViews.forEachIndexed { index, imageView ->
                if (imageView != null && index < imageUris.size) {
                    Glide.with(this)
                        .load(imageUris[index])
                        .centerCrop()
                        .into(imageView)
                }
            }
        } catch (e: Exception) {
            Log.e("ImageCollageActivity", "Error arranging images: ${e.message}")
        }
    }


    private fun loadImageIntoCropView() {
        imageUris?.let { uri ->
            Glide.with(this)
                .asBitmap()
                .load(imageUris)
                .into(object : CustomTarget<Bitmap>() {
                    override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap>?
                    ) {
                        // Set the Bitmap into CropImageView
                        binding.collageContainer.setImageBitmap(resource)
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {
                        // Handle any cleanup here
                    }
                })
        }
    }


    override fun onLayoutSelected(aspectX: Int, aspectY: Int) {
        if (aspectX == 0 && aspectY == 0) {
            // Free cropping
            binding.collageContainer.setFixedAspectRatio(false)
        } else {
            binding.collageContainer.setAspectRatio(aspectX, aspectY)
        }
        Log.e("LayoutActivity", "Aspect Ratio Set: $aspectX:$aspectY")
    }



}
