package com.collagemaker_makeanything.Activity

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.collagemaker_makeanything.Adapter.StickerActivityAdapter
import com.collagemaker_makeanything.Adapter.Sticker_Group_Images_Adapter
import com.collagemaker_makeanything.Adapter.Sticker_Sub_Image_Adapter
import com.collagemaker_makeanything.Api.OkHttpHelpers
import com.collagemaker_makeanything.Api.stData
import com.collagemaker_makeanything.Api.stGroup
import com.collagemaker_makeanything.Class.OnStickerClickListener
import com.collagemaker_makeanything.Class.StickerClickListener
import com.collagemaker_makeanything.R
import com.collagemaker_makeanything.StickerView.CustomStickerView
import com.collagemaker_makeanything.StoreFragment.StickerBottomSheetDialogFragment
import com.collagemaker_makeanything.databinding.ActivityStickerBinding
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

class StickerActivity : BaseActivity(), OnStickerClickListener, StickerClickListener {

    private lateinit var imageUri: String
    private var croppedImageUri: String? = null
    private var currentStickerView: CustomStickerView? =
        null // Track the currently displayed sticker


    //    private lateinit var viewModel: StickerViewModel
    private lateinit var adapter: StickerActivityAdapter
    private lateinit var adapters: Sticker_Sub_Image_Adapter
    private val groupsList = mutableListOf<stGroup>()
    private var data: List<String?>? = null
    private lateinit var datas: String
    private lateinit var mainImageUrl: String

    companion object {
        lateinit var binding: ActivityStickerBinding

        private const val ARG_DATA = "data"
        private const val ARG_COLOR = "navigation_bar_color"
        private const val ARG_MAIN_IMAGE_URL = "main_image_url"
        private const val ARG_TEXT_CATEGORY =
            "https://s3.eu-north-1.amazonaws.com/photoeditorbeautycamera.com/collagemaker/sticker/"

        fun newInstance(
            data: List<String?>?,
            navigationBarColor: Int,
            mainImageUrl: String,
            textCategory: String?
        ): StickerBottomSheetDialogFragment {
            val fragment = StickerBottomSheetDialogFragment()
            val args = Bundle()
            args.putStringArrayList(ARG_DATA, ArrayList(data))
            args.putInt(ARG_COLOR, navigationBarColor)
            args.putString(ARG_MAIN_IMAGE_URL, mainImageUrl)
            args.putString(ARG_TEXT_CATEGORY, textCategory)
            fragment.arguments = args
            return fragment
        }
    }


    fun updateStickersList(subImageUrls: List<String?>) {
        // Update the secondary RecyclerView adapter
        adapters.updateData(subImageUrls)
        adapters.notifyDataSetChanged()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStickerBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // initializeEmojiCompat()
        initView()
        initLoadApi()
    }

//    private fun initializeEmojiCompat() {
//        val config = BundledEmojiCompatConfig(this)
//        EmojiCompat.init(config)
//    }


    private fun initView() {
        // Retrieve the imageUri from the intent
        imageUri = intent.getStringExtra("imageUri") ?: ""

        // Load the image using a function
        if (imageUri.isNotEmpty()) {
            loadSelectedImage() // Call the function to load the image
        } else {
            Log.d("StickerActivity", "No image URI received.")
        }
    }

    private fun initLoadApi() {


        val url =
            "https://s3.ap-south-1.amazonaws.com/photoeditorbeautycamera.app/collagemaker/stickernew.json"
        var baseurl =
            "https://s3.ap-south-1.amazonaws.com/photoeditorbeautycamera.app/photoeditor/sticker/"


        OkHttpHelpers.fetchSticker(url) { stickerApi ->
            runOnUiThread {

                if (stickerApi != null) {
                    Log.e("StoreFragment", "Fetched data: ${stickerApi.data}")

                    stickerApi.data?.let {
                        populateGroupsList(it)
                        adapter.updateData(groupsList)
                    } ?: Log.e("StoreFragment", "Data is null")
                } else {
                    Log.e("StoreFragment", "Failed to fetch data")
                }
            }
        }

        adapter = StickerActivityAdapter(this, groupsList, this, this)
        binding.rcvStiker.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        data = intent.getStringArrayListExtra(StickerBottomSheetDialogFragment.ARG_DATA)
        adapters = Sticker_Sub_Image_Adapter(data ?: emptyList())
        binding.rcvStiker.adapter = adapter


        val imageUrls = intent.getStringArrayListExtra("imageUrls") ?: arrayListOf()

        // Set up the RecyclerView
        binding.rcvStikers.layoutManager = GridLayoutManager(this, 4)
        adapters =
            Sticker_Sub_Image_Adapter(imageUrls) // Make sure this adapter is set to handle the images
        binding.rcvStikers.adapter = adapter


//        adapter = Sticker_Activity_Adapter(this,groupsList)
//        binding.rcvStikers.layoutManager = LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false)
//        data = intent.getStringArrayListExtra(StickerBottomSheetDialogFragment.ARG_DATA)
//        adapters = Sticker_Sub_Image_Adapter(data ?: emptyList())
//        binding.rcvStikers.adapter = adapter
    }


    private fun populateGroupsList(data: stData) {
        val items = mutableListOf<stGroup>()

        // Use Kotlin reflection to iterate over the properties of the Dataas class
        data::class.memberProperties.forEach { property ->
            val prop = property as? KProperty1<stData, *>
            val value = prop?.get(data)

            // Check if the value is an instance of a class containing a Groupas
            if (value != null) {
                // Use reflection to find the Groupas property within the nested class
                val groupProperty = value::class.memberProperties
                    .firstOrNull { it.returnType.classifier == stGroup::class }
                        as? KProperty1<Any, stGroup>

                val nestedGroup = groupProperty?.get(value)

                if (nestedGroup != null) {
                    val categoryName = property.name.replace("_", " ").capitalizeWords()

                    nestedGroup.let {
                        if (it.subImageUrl != null || it.mainImageUrl != null) {
                            items.add(
                                stGroup(
                                    subImageUrl = it.subImageUrl,
                                    mainImageUrl = it.mainImageUrl,
                                    premium = it.premium,
                                    textCategory = categoryName

                                )
                            )
                        }
                    }
                }
            }
        }

        groupsList.clear()
        groupsList.addAll(items)
    }

    private fun String.capitalizeWords(): String = split(" ").joinToString(" ") { it.capitalize() }

    // This method will be called when an item is clicked in the first RecyclerView
    override fun onStickerClicked(imageUrls: List<String>) {
        // Create a new adapter for the second RecyclerView to display the selected group of images
        val groupAdapter = Sticker_Group_Images_Adapter(imageUrls, this)

        // Set up the second RecyclerView with a GridLayoutManager (3 columns for images)
        binding.rcvStikers.layoutManager = GridLayoutManager(this, 4)
        binding.rcvStikers.adapter = groupAdapter

        // Make the second RecyclerView visible
        binding.rcvStikers.visibility = View.VISIBLE
    }

    // This method will be called when an item is clicked in the second RecyclerView
    override fun onStickerSelected(imageUrl: String) {
//      Remove the existing sticker view if it exists
        currentStickerView?.let {
            val stickerLayout = findViewById<FrameLayout>(R.id.stickerLayout)
            stickerLayout.removeView(it)
        }

        // Create a new instance of your CustomStickerView
        val newStickerView = CustomStickerView(this)

        val layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )

        newStickerView.layoutParams = layoutParams

        // Make the CustomStickerView visible if needed
        binding.stvStickerView.visibility = View.VISIBLE

        Glide.with(this)
            .load(imageUrl)
            .into(newStickerView.findViewById(R.id.stickerImageView))


        //      Add the new sticker view to your sticker layout
        val stickerLayout = findViewById<FrameLayout>(R.id.stvStickerView)
        stickerLayout.addView(newStickerView)
    }

    private fun loadSelectedImage() {
        val uriToLoad = croppedImageUri ?: imageUri
        if (uriToLoad.isNotEmpty()) {
            Log.d("EditActivity", "Loading image URI: $uriToLoad")
            Glide.with(this)
                .load(uriToLoad)
                .into(binding.imgContainer)
        } else {
            Log.d("EditActivity", "No image URI found.")
            Toast.makeText(this, "No image found to load", Toast.LENGTH_SHORT).show()
        }
    }
}