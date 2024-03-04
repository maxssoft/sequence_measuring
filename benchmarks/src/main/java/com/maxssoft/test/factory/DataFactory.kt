package com.maxssoft.test.factory

import java.util.Random

/**
 *
 *
 * @author Сидоров Максим on 08.02.2023
 */

data class ProductPhoto(val url: String, val isDefault: Boolean)

data class Product(val productUid: String, val photos: List<ProductPhoto>)

data class ProductCategory(val categoryName: String)

class ProductRepository(private val productMap: Map<String, List<Product>>) {
    fun getCategoryProducts(categoryName: String): List<Product>? = productMap[categoryName]
}

class SessionManager(val productCategories: List<ProductCategory>)

class DataFactory(countCategories: Int, countProducts: Int = 1000, maxCountCategoryProducts: Int = 10, private val maxCountPhotos: Int = 10) {

    private val random = Random()

    val productRepository: ProductRepository
    val sessionManager: SessionManager


    init {
        val categories = mutableListOf<ProductCategory>().apply {
            createNames(countCategories, "category").forEach { CategoryName ->
                add(ProductCategory(CategoryName))
            }
        }
        sessionManager = SessionManager(categories)

        val products = mutableListOf<Product>().apply {
            createNames(countProducts, "productUid").forEach { productUid ->
                add(Product(productUid, createPhotos(productUid)))
            }
        }

        val productMap = mutableMapOf<String, List<Product>>()
        categories.forEach { category ->
            val categoryProducts = mutableListOf<Product>()
            val count = random.nextInt(maxCountCategoryProducts)
            repeat((0..count).count()) {
                categoryProducts.add(products[random.nextInt(products.size)])
            }
            productMap[category.categoryName] = categoryProducts
        }
        productRepository = ProductRepository(productMap)
    }

    private fun createPhotos(productUid: String): List<ProductPhoto> {
        val result = mutableListOf<ProductPhoto>()
        val photos = createNames(random.nextInt(maxCountPhotos), "https://url-$productUid")
        if (photos.isNotEmpty()) {
            val defaultIndex = random.nextInt(photos.size)
            photos.forEachIndexed { index, photoUrl ->
                result.add(ProductPhoto(photoUrl, index == defaultIndex))
            }
        }
        return result
    }

    private fun createNames(count: Int, prefix: String): List<String> {
        return mutableListOf<String>().apply {
            (1..count).forEach { index -> add("$prefix-$index") }
        }
    }
}

/*
sessionManager.getCurrentSession().videoConfig.productCategories
.map { it.name }
.map { productRepository.getCurrentActiveProducts(it) }
.flatten()
.map { it.mainPhoto }
.let { mainPhotoUrls ->
    imageCacheUtils.warmUp(mainPhotoUrls)
}
*/
