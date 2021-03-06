package com.sun.livescore.data.remote.country

import com.sun.livescore.data.model.country.CountryResponse
import io.reactivex.Single

interface CountryDataSource {
    interface Remote {
        fun getLeagueCountry(): Single<CountryResponse>
    }
}
