package com.maxssoft.test.factory.large

import java.util.Date
import java.util.Random

/**
 *
 *
 * @author Сидоров Максим on 08.02.2023
 */

data class AppWidget(
    val providerId: String,
    val type: AppWidgetType,
    val weight: Int,
    val deepLink: String? = null,
    val applicationId: String? = null,
    val packageName: String? = null,
    val showDate: Date? = null,
    val startShowDate: Date? = null,
    val endShowDate: Date? = null,
    val shouldMoveToEndId: Boolean = false,
    val shouldHideInOtherSession: Boolean = false,
    val subCategoryProviderId: String? = null,
    val appPackageName: String = providerId,
    val mark: String? = null,
    val guid: String? = null,
    val isPromo: Boolean = false,
    val isAdvertisement: Boolean = false,
    val businessType: WidgetBusinessType =
        WidgetBusinessType.COMMON,
    val attributes: String? = null,
    val adsClickUrl: String? = null,
    val backgroundImage: ImageModel? = null,
    val additionalBackgroundImage: ImageModel? = null,
    val backdropInfo: BackdropInfo? = null,
    val leftTag: TagInfo? = null,
    val rightTag: TagInfo? = null,
    val rightAdditionalTag: TagInfo? = null,
    val icon: ImageModel? = null,
    val isOnAir: Boolean = false,
    val innerText: String? = null,
    val localeInnerText: String? = null,
    val progressValue: Int? = null,
    val title: String,
    val localeTitle: String? = null,
    val subtitle: String? = null,
    val localeSubtitle: String? = null,
    val disabledSurfacesTag: String? = null,
    val source: String? = null,
    val hiddenName: String = "",
)

data class ImageModel(
    val uri: String,
    val transformation: Transformation = Transformation.NONE,
    val placeholder: Placeholder = Placeholder.NONE,
    val thumbnail: Thumbnail = Thumbnail.NONE,
    val scaleType: ScaleType = ScaleType.CROP,
    val displayMode: ImageModelDisplayMode = ImageModelDisplayMode.STATIC,
)
data class BackdropInfo(
    val backgroundImage: ImageModel? = null,
    val logoImage: ImageModel? = null,
    val logoText: String? = null,
    val localeLogoText: String? = null,
    val rating: Float? = null,
    val labels: List<String>? = null,
    val descriptionText: String? = null
)

data class TagInfo(
    val text: String,
    val localeText: String? = null,
    val backgroundColor: Int
)

enum class AppWidgetType {
    COMMON, LARGE, SHORT
}
enum class WidgetBusinessType {
    COMMON, PROMO, PAYMENT
}
enum class ScaleType { CROP, FIT, }
enum class Transformation(val id: String) {
    NONE("none"),
    CIRCLE_CROP("circleCrop"),
    DEFAULT_CORNERS("defaultCorners"),
    ROUND_16PX_CORNERS("round_16px_corners"),
    DEFAULT_RECT("defaultRect"),
    ;
}
enum class Placeholder { NONE, AVATAR }
enum class Thumbnail { NONE, BASE64 }
enum class ImageModelDisplayMode { STATIC, ANIMATION }

class WidgetDataFactory() {

    private val random = Random()

    fun imageModel() = ImageModel(
        uri = generateString(),
        transformation = Transformation.values().generateEnum(),
        placeholder = Placeholder.values().generateEnum(),
        thumbnail = Thumbnail.values().generateEnum(),
        scaleType = ScaleType.values().generateEnum(),
        displayMode = ImageModelDisplayMode.values().generateEnum()
    )

    fun backdropInfo() = BackdropInfo(
        backgroundImage = imageModel(),
        logoImage = imageModel(),
        logoText = generateString(),
        localeLogoText = generateString(),
        rating = randomInt().toFloat(),
        labels = listOf(generateString(), generateString(), generateString()),
        descriptionText = generateString()
    )

    fun tagInfo() = TagInfo(
        text = generateString(),
        localeText = generateString(),
        backgroundColor = randomInt()
    )

    fun widget(): AppWidget = AppWidget(
        providerId = generateString(),
        type = AppWidgetType.values().generateEnum(),
        weight = randomInt(),
        deepLink = generateString(),
        applicationId = generateString(),
        packageName = generateString(),
        showDate = randomDate(),
        startShowDate = randomDate(),
        endShowDate = randomDate(),
        shouldMoveToEndId = randomBool(),
        shouldHideInOtherSession = randomBool(),
        subCategoryProviderId = generateString(),
        appPackageName = generateString(),
        mark = generateString(),
        guid = generateString(),
        isPromo = randomBool(),
        isAdvertisement = randomBool(),
        businessType = WidgetBusinessType.values().generateEnum(),
        attributes = generateString(),
        adsClickUrl = generateString(),
        backgroundImage = imageModel(),
        additionalBackgroundImage = imageModel(),
        backdropInfo = backdropInfo(),
        leftTag = tagInfo(),
        rightTag = tagInfo(),
        rightAdditionalTag = tagInfo(),
        icon = imageModel(),
        isOnAir = randomBool(),
        innerText = generateString(),
        localeInnerText = generateString(),
        progressValue = randomInt(),
        title = generateString(),
        localeTitle = generateString(),
        subtitle = generateString(),
        localeSubtitle = generateString(),
        disabledSurfacesTag = generateString(),
        source = generateString(),
        hiddenName = generateString()
    )

    private fun generateString(): String = StringBuilder()
        .apply {
            repeat(32) { append(random.nextInt(10)) }
        }
        .toString()
    private fun <T> Array<T>.generateEnum(): T {
        val index = random.nextInt(this.size)
        return this[index]
    }
    private fun randomDate(): Date = Date(System.currentTimeMillis() - random.nextInt(10000000))
    private fun randomBool(): Boolean = random.nextInt(1) == 1
    private fun randomInt() = random.nextInt(1000)
}
