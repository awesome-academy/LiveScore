package com.sun.livescore.di

import com.sun.livescore.data.local.LeagueDatabase
import com.sun.livescore.data.local.ScheduleDatabase
import com.sun.livescore.data.local.TeamDatabase
import com.sun.livescore.data.local.source.FavoriteLocalDataSource
import com.sun.livescore.data.local.source.LeagueLocalDataSource
import com.sun.livescore.data.local.source.ScheduleLocalDataSource
import com.sun.livescore.data.remote.country.CountryRemoteDataSource
import com.sun.livescore.data.remote.league.LeagueRemoteDataSource
import com.sun.livescore.data.remote.live.LiveEventRemoteDataSource
import com.sun.livescore.data.remote.score.ScoreRemoteDataSource
import com.sun.livescore.data.remote.standing.StandingRemoteDataSource
import com.sun.livescore.data.repository.CountryRepository
import com.sun.livescore.data.repository.FavoriteLocalRepository
import com.sun.livescore.data.repository.LeagueLocalRepository
import com.sun.livescore.data.repository.LeagueRepository
import com.sun.livescore.data.repository.LiveEventRepository
import com.sun.livescore.data.repository.ScheduleRepository
import com.sun.livescore.data.repository.ScoreRepository
import com.sun.livescore.data.repository.StandingRepository
import com.sun.livescore.ui.country.CountryViewModel
import com.sun.livescore.ui.favorite.FavoriteViewModel
import com.sun.livescore.ui.leagues.LeagueViewModel
import com.sun.livescore.ui.live_event.LiveEventViewModel
import com.sun.livescore.ui.scores.child.ScoreChildViewModel
import com.sun.livescore.ui.scores.live.LiveScoreViewModel
import com.sun.livescore.ui.scores.parent.ScoreViewModel
import com.sun.livescore.ui.standing.StandingViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ScoreViewModel() }
    viewModel { CountryViewModel(get()) }
    viewModel { ScoreChildViewModel(get(), get(), get()) }
    viewModel { LeagueViewModel(get()) }
    viewModel { StandingViewModel(get()) }
    viewModel { LiveScoreViewModel(get()) }
    viewModel { LiveEventViewModel(get()) }
    viewModel { FavoriteViewModel(get(), get()) }
    single { ScoreRemoteDataSource(get()) }
    single { ScoreRepository(get()) }
    single { CountryRemoteDataSource(get()) }
    single { CountryRepository(get()) }
    single { LeagueRemoteDataSource(get()) }
    single { LeagueRepository(get()) }
    single { StandingRepository(get()) }
    single { StandingRemoteDataSource(get()) }
    single { LiveEventRepository(get()) }
    single { LiveEventRemoteDataSource(get()) }
    single { FavoriteLocalRepository(get()) }
    single { FavoriteLocalDataSource(get()) }
    single { ScheduleRepository(get()) }
    single { ScheduleLocalDataSource(get()) }
    single { LeagueLocalRepository(get()) }
    single { LeagueLocalDataSource(get()) }
    single { ScheduleDatabase.getInstance(androidContext()) }
    factory { get<ScheduleDatabase>().scheduleDao() }
    single { TeamDatabase.getInstance(androidContext()) }
    factory { get<TeamDatabase>().teamDao() }
    single { LeagueDatabase.getInstance(androidContext()) }
    factory { get<LeagueDatabase>().leagueDao() }
}
