package com.sopt.daisomall.core.di

/**
 * 수동 주입용 Service 모음
 *
 * Service를 추가할 때 아래처럼 선언해서 사용합니다.
 * val productService: ProductService by lazy { ApiFactory.create<ProductService>() }
 */
object ServicePool
