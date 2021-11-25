package kr.hs.dgsw.unionhackathon.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.unionhackathon.network.`object`.RetrofitInstance
import kr.hs.dgsw.unionhackathon.network.service.ClovaService
import kr.hs.dgsw.unionhackathon.network.service.ReviewService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Singleton
    @Provides
    fun provideReviewService(): ReviewService =
        RetrofitInstance.reviewService

    @Singleton
    @Provides
    fun provideClovaService(): ClovaService =
        RetrofitInstance.clovaService
}