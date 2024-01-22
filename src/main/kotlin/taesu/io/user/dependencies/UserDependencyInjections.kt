package taesu.io.user.dependencies

import org.koin.core.module.Module
import taesu.io.user.application.UserRetrieveService
import taesu.io.user.application.UserSaveService
import taesu.io.user.domain.UserRepository
import taesu.io.user.domain.UserRepositoryImpl

fun Module.userDependencyInjections() {
    single { UserRetrieveService(get()) }
    single { UserSaveService(get()) }
    single<UserRepository> { UserRepositoryImpl() }
}
