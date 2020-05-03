package com.suru.oobasics.exercises

trait MyTransformer[-A, B] {
    def transform(a: A): B
}
