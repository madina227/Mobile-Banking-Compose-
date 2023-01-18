package uz.gita.mobilebankingcompose.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.mobilebankingcompose.navigation.AppNavigationManager
import uz.gita.mobilebankingcompose.navigation.AppNavigator
import uz.gita.mobilebankingcompose.navigation.NavigationHandler

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    fun bindAppNavigator(impl: AppNavigationManager): AppNavigator

    @Binds
    fun bindNavigationHandler(impl: AppNavigationManager): NavigationHandler
}