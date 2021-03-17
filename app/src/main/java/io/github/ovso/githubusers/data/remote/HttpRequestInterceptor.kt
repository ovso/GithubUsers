package io.github.ovso.githubusers.data.remote

import com.orhanobut.logger.Logger
import okhttp3.Interceptor
import okhttp3.Response

class HttpRequestInterceptor : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val originalRequest = chain.request()
    val request = originalRequest.newBuilder().url(originalRequest.url).build()
    Logger.d(request.toString())
    return chain.proceed(request)
  }
}
