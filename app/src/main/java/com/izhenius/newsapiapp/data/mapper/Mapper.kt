package com.izhenius.newsapiapp.data.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}