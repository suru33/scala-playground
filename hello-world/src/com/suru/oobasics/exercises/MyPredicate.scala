package com.suru.oobasics.exercises

trait MyPredicate[-T] {
    def test(t: T): Boolean
}
