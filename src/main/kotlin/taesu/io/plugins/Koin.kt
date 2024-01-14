package taesu.io.plugins

import io.ktor.server.application.*
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.SLF4JLogger
import taesu.io.user.application.UserRetrieveService
import taesu.io.user.domain.UserRepository
import taesu.io.user.domain.UserRepositoryImpl

/**
 * Created by taesu on 2024/01/14.
 *
 * @author Lee Tae Su
 * @version ktor-exposed-demo
 * @since ktor-exposed-demo
 */
val dependencyInjectionModule = module {
    single { UserRetrieveService(get()) }
    single<UserRepository> { UserRepositoryImpl() }
}

fun Application.configureDependencyInjection() {
    install(Koin) {
        SLF4JLogger()
        modules(dependencyInjectionModule)
    }
}
