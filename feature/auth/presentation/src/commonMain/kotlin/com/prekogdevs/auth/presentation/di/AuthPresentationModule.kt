package com.prekogdevs.auth.presentation.di

import com.prekogdevs.auth.presentation.email_verification.EmailVerificationViewModel
import com.prekogdevs.auth.presentation.forgot_password.ForgotPasswordViewModel
import com.prekogdevs.auth.presentation.login.LoginViewModel
import com.prekogdevs.auth.presentation.register.RegisterViewModel
import com.prekogdevs.auth.presentation.register_success.RegisterSuccessViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val authPresentationModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::RegisterSuccessViewModel)
    viewModelOf(::EmailVerificationViewModel)
    viewModelOf(::LoginViewModel)
    viewModelOf(::ForgotPasswordViewModel)
}