package kr.hs.dgsw.unionhackathon.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.hs.dgsw.unionhackathon.network.repository.ReviewRepository
import kr.hs.dgsw.unionhackathon.network.service.ReviewService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideReviewRepository(service: ReviewService): ReviewRepository =
        ReviewRepository(service)
}