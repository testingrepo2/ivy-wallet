package com.ivy.impl.export.json

import com.ivy.core.persistence.dao.trn.TransactionDao
import com.ivy.core.persistence.dao.trn.TrnLinkRecordDao
import com.ivy.core.persistence.dao.trn.TrnMetadataDao
import com.ivy.core.persistence.dao.trn.TrnTagDao
import org.json.JSONArray

internal suspend fun exportTransactionsJson(
    transactionDao: TransactionDao
): JSONArray = exportJson(
    findAll = transactionDao::findAllBlocking,
    toJson = {
        put("id", it.id)
        put("accountId", it.accountId)
        put("type", it.type.code)
        put("amount", it.amount)
        put("currency", it.currency)
        put("time", it.time.epochSecond)
        put("timeType", it.timeType.code)
        put("title", it.title)
        put("description", it.description)
        put("categoryId", it.categoryId)
        put("state", it.state)
        put("purpose", it.purpose?.code)
        putLastUpdated(it.lastUpdated)
    }
)

internal suspend fun exportTrnMetadataJson(
    trnMetadataDao: TrnMetadataDao
): JSONArray = exportJson(
    findAll = trnMetadataDao::findAllBlocking,
    toJson = {
        put("id", it.id)
        put("trnId", it.trnId)
        put("key", it.key)
        put("value", it.value)
        putLastUpdated(it.lastUpdated)
    }
)

internal suspend fun exportTrnLinkRecordsJson(
    trnLinkRecordDao: TrnLinkRecordDao
): JSONArray = exportJson(
    findAll = trnLinkRecordDao::findAllBlocking,
    toJson = {
        put("id", it.id)
        put("trnId", it.trnId)
        put("batchId", it.batchId)
        putLastUpdated(it.lastUpdated)
    }
)

internal suspend fun exportTrnTagsJson(
    trnTagDao: TrnTagDao
): JSONArray = exportJson(
    findAll = trnTagDao::findAllBlocking,
    toJson = {
        put("trnId", it.trnId)
        put("tagId", it.tagId)
        putLastUpdated(it.lastUpdated)
    }
)