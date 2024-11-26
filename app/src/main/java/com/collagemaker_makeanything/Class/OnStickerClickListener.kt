package com.collagemaker_makeanything.Class

interface OnStickerClickListener {
    fun onStickerClicked(imageUrls: List<String>)
}

interface StickerClickListener {
    fun onStickerSelected(imageUrl: String)
}

