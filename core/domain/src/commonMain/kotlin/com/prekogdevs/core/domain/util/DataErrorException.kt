package com.prekogdevs.core.domain.util

class DataErrorException(
    val error: DataError
): Exception()