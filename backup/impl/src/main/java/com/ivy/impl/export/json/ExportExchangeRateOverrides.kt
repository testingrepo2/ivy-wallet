package com.ivy.impl.export.json

import com.ivy.core.persistence.dao.exchange.ExchangeRateOverrideDao
import org.json.JSONArray

internal suspend fun exportExchangeRatesOverridesToJson(
    exchangeRateOverrideDao: ExchangeRateOverrideDao
): JSONArray = exportJson(
    findAll = exchangeRateOverrideDao::findAllBlocking,
    toJson = {
        put("baseCurrency", it.baseCurrency)
        put("currency", it.currency)
        put("rate", it.rate)
        putLastUpdated(it.lastUpdated)
    }
)