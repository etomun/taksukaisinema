package com.taksuinterview.kaisinema.data.remote.api

import com.taksuinterview.kaisinema.common.util.constant.Api
import com.taksuinterview.kaisinema.data.remote.base.BaseResponse
import com.taksuinterview.kaisinema.data.remote.request.auth.LoginEmailRequest
import com.taksuinterview.kaisinema.data.remote.request.auth.SignUpRequest
import com.taksuinterview.kaisinema.data.remote.response.auth.LoginResponse
import io.reactivex.Observable
import retrofit2.http.*

interface AuthApi {

    @POST("Auth/SignIn")
    @Headers(Api.HEADER_NO_AUTHENTICATION + ": true")
    fun loginEmail(@Body loginEmailRequest: LoginEmailRequest): Observable<BaseResponse<LoginResponse>>

    @POST("Auth/SignUp")
    @Headers(Api.HEADER_NO_AUTHENTICATION + ": true")
    fun signUp(@Body signUpRequest: SignUpRequest): Observable<BaseResponse<Any>>

    @FormUrlEncoded
    @POST("Auth/ResetPassword")
    @Headers(Api.HEADER_NO_AUTHENTICATION + ": true")
    fun resetPassword(
        @Field("otpCode") token: String,
        @Field("newPassword") newPassword: String,
        @Field("newPasswordConfirm") confirmPassword: String
    ): Observable<BaseResponse<Any>>

    @FormUrlEncoded
    @POST("Auth/ForgetPassword")
    @Headers(Api.HEADER_NO_AUTHENTICATION + ": true")
    fun requestResetPassword(@Field("userEmail") email: String): Observable<BaseResponse<Any>>

    @FormUrlEncoded
    @POST("Auth/VerifyOtp")
    @Headers(Api.HEADER_NO_AUTHENTICATION + ": true")
    fun checkResetPasswordToken(@Field("otpCode") token: String): Observable<BaseResponse<Any>>
}