package com.arksana.clubo.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.arksana.clubo.model.Leagues
import com.arksana.clubo.model.Matches
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

@Suppress("UNCHECKED_CAST")
class RepositoryTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var repository: Repository


    @Before
    fun before() {
        repository = mock(Repository::class.java)

    }

    @Test
    fun listLeague() {
        val fakeLiveData = MutableLiveData<Leagues>(GetData.listLeagues())
        val observer: Observer<Leagues> = mock(Observer::class.java) as Observer<Leagues>

        `when`(repository.leagues).thenReturn(fakeLiveData)
        repository.listLeague()
        repository.leagues.observeForever(observer)
        verify(observer).onChanged(GetData.listLeagues())
    }

    @Test
    fun prevMatch() {
        val fakeLiveData = MutableLiveData<Matches>(GetData.prevMatch())
        val observer: Observer<Matches> = mock(Observer::class.java) as Observer<Matches>

        `when`(repository.matches).thenReturn(fakeLiveData)
        repository.prevMatch("1234")
        repository.matches.observeForever(observer)
        verify(observer).onChanged(GetData.prevMatch())
    }

    @Test
    fun nextMatch() {
        val fakeLiveData = MutableLiveData<Matches>(GetData.nextMatch())
        val observer: Observer<Matches> = mock(Observer::class.java) as Observer<Matches>

        `when`(repository.matches).thenReturn(fakeLiveData)
        repository.nextMatch("1234")
        repository.matches.observeForever(observer)
        verify(observer).onChanged(GetData.nextMatch())
    }

    @Test
    fun detailMatch() {
        val fakeLiveData = MutableLiveData<Matches>(GetData.lookUpEvent())
        val observer: Observer<Matches> = mock(Observer::class.java) as Observer<Matches>

        `when`(repository.matches).thenReturn(fakeLiveData)
        repository.detailMatch("603995")
        repository.matches.observeForever(observer)
        verify(observer).onChanged(GetData.lookUpEvent())
    }

    @Test
    fun search() {
        val fakeLiveData = MutableLiveData<Matches>(GetData.searchEvents())
        val observer: Observer<Matches> = mock(Observer::class.java) as Observer<Matches>

        `when`(repository.matches).thenReturn(fakeLiveData)
        repository.searchMatch("Japan")
        repository.matches.observeForever(observer)
        verify(observer).onChanged(GetData.searchEvents())
    }

    @Test
    fun detailLeague() {
        val fakeLiveData = MutableLiveData<Leagues>(GetData.lookUpLeagues())
        val observer: Observer<Leagues> = mock(Observer::class.java) as Observer<Leagues>

        `when`(repository.leagues).thenReturn(fakeLiveData)
        repository.detailLeague("4406")
        repository.leagues.observeForever(observer)
        verify(observer).onChanged(GetData.lookUpLeagues())
    }
}