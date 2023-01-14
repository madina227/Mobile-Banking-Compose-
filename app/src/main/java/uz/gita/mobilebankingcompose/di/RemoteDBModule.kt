package uz.gita.mobilebankingcompose.di

import android.content.Context
import com.mocklets.pluto.Pluto
import com.mocklets.pluto.PlutoInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import uz.gita.mobilebankingcompose.data.source.local.SharedPref
import uz.gita.mobilebankingcompose.data.source.remote.dto.service.AuthApi
import uz.gita.mobilebankingcompose.util.BASE_URL
import java.net.URL
import javax.inject.Singleton

/**
 * Created by Madina Agzamova
 * on 09,January,2023
 */

@Module
@InstallIn(SingletonComponent::class)
class RemoteDBModule {

    @Provides
    @Singleton
    fun loggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun client(
        @ApplicationContext context: Context,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        Pluto.initialize(context)
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain
                    .request()
                    .newBuilder()
                    .addHeader(
                        "authorization",
                        "Bearer ${SharedPref(context).accessToken}"
                    ).build()

                chain.proceed(request)

            }
            .addInterceptor(loggingInterceptor)
            .addInterceptor(PlutoInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    @Provides
    fun authApi(retrofit: Retrofit): AuthApi =
        retrofit.create(AuthApi::class.java)
}