package template.module

import javax.inject.{Inject, Singleton}

import com.twitter.inject.TwitterModule
import template.repository.OnMemoryCacheRepository
import template.service.{UserCacheService, UserCacheServiceImpl}

/**
  * Created by SangDang on 9/16/16.
  */
object UserCacheModule extends TwitterModule {
  @Singleton
  def providesUserCacheService(): UserCacheService =
    new UserCacheServiceImpl(new OnMemoryCacheRepository())

}
