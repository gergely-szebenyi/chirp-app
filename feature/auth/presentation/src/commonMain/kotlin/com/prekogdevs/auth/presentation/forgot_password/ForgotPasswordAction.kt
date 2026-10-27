package com.prekogdevs.auth.presentation.forgot_password

sealed interface ForgotPasswordAction {
    data object OnSubmitClick: ForgotPasswordAction
}