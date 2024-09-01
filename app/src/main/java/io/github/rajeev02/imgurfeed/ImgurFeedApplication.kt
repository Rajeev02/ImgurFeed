package io.github.rajeev02.imgurfeed

import android.app.Application
import android.os.Build.VERSION.SDK_INT
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.decode.SvgDecoder
import coil.decode.VideoFrameDecoder

class ImgurFeedApplication : Application() {

    lateinit var imageLoader: ImageLoader

    override fun onCreate() {
        super.onCreate()
        imageLoader = ImageLoader.Builder(this@ImgurFeedApplication)
            .components {
//                if (SDK_INT >= 28) {
//                    add(ImageDecoderDecoder.Factory()) // Supports GIF, PNG, animated WebP, etc.
//                } else {
//                    add(GifDecoder.Factory()) // Fallback for older versions
//                }
                add(ImageDecoderDecoder.Factory()) // Supports GIF, PNG, animated WebP, etc.
                add(SvgDecoder.Factory()) // If you want to support SVGs
                add(VideoFrameDecoder.Factory()) // For video frames
            }
            .build()
    }
}

