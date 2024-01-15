package taesu.io.plugins

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.*
import org.jetbrains.exposed.sql.*
import taesu.io.app.Configs
import taesu.io.app.DatasourceConfig
import java.sql.*

fun Application.configureDatabases() {
    HikariExposedDatabaseConnector().connect(DatasourceConfig)
    log.info("Database is successfully connected.")
}

interface ExposedDatabaseConnector {
    fun connect(datasourceConfig: DatasourceConfig)
}

class HikariExposedDatabaseConnector : ExposedDatabaseConnector {
    override fun connect(datasourceConfig: DatasourceConfig) {
        val hikari = HikariDataSource(
            HikariConfig().apply {
                jdbcUrl = datasourceConfig.url
                username = datasourceConfig.username
                password = datasourceConfig.password
                driverClassName = datasourceConfig.driverClassName
                maximumPoolSize = datasourceConfig.maximumPoolSize
                isAutoCommit = false
                transactionIsolation = "TRANSACTION_READ_COMMITTED"
                validate()
            }
        )
        Database.connect(hikari)
    }
}
