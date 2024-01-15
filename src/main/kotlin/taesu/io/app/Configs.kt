package taesu.io.app

import com.typesafe.config.ConfigFactory
import io.ktor.server.config.*

/**
 * Created by itaesu on 2024/01/15.
 *
 * @author Lee Tae Su
 * @version ktor-exposed-demo
 * @since ktor-exposed-demo
 */
object Configs {
    private val config = HoconApplicationConfig(ConfigFactory.load())
    fun property(key: String): String = config.property(key).getString()
}

object DatasourceConfig {
    val url: String = Configs.property("database.datasource.url")
    val username: String = Configs.property("database.datasource.username")
    val password: String = Configs.property("database.datasource.password")
    val driverClassName: String = Configs.property("database.datasource.driver-class-name")
    val maximumPoolSize: Int = Configs.property("database.datasource.max-pool-size").toInt()
}
