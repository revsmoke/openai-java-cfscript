@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.api.services.blocking

import com.openai.api.core.RequestOptions
import com.openai.api.models.Image
import com.openai.api.models.ImageCreateVariationParams
import com.openai.api.models.ImageEditParams
import com.openai.api.models.ImageGenerateParams

interface ImageService {

    /** Creates a variation of a given image. */
    @JvmOverloads
    fun createVariation(
        params: ImageCreateVariationParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Image

    /** Creates an edited or extended image given an original image and a prompt. */
    @JvmOverloads
    fun edit(params: ImageEditParams, requestOptions: RequestOptions = RequestOptions.none()): Image

    /** Creates an image given a prompt. */
    @JvmOverloads
    fun generate(
        params: ImageGenerateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): Image
}
