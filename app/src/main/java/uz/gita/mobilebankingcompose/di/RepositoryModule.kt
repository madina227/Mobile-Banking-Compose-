package uz.gita.mobilebankingcompose.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.mobilebankingcompose.data.repository.AuthRepositoryImpl
import uz.gita.mobilebankingcompose.domain.repo.AuthRepository
import javax.inject.Singleton

/**
 * Created by Madina Agzamova
 * on 09,January,2023
 */

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
fun repositoryModule(impl:AuthRepositoryImpl):AuthRepository
}