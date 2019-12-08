package com.arksana.clubo.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class RepositoryTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val repository = mock(Repository::class.java)

    @Test
    fun listLeague() {

    }

    @Test
    fun prevMatch() {
    }

    @Test
    fun nextMatch() {
    }

    @Test
    fun detailMatch() {
    }

    @Test
    fun search() {
    }

    @Test
    fun detailLeague() {
    }

    @Test
    fun allDetailTeam() {

    }
}