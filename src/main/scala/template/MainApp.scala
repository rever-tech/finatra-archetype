package template


import com.twitter.finagle.thrift
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.CommonFilters
import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.finatra.thrift.ThriftServer
import com.twitter.finatra.thrift.routing.ThriftRouter
import template.controller.http
import template.controller.thrift.CacheController
import template.module.UserCacheModule

/**
  * Created by SangDang on 9/8/
  **/
object MainApp extends HttpServer with ThriftServer {
  override val modules = Seq(UserCacheModule)

  override protected def configureHttp(router: HttpRouter): Unit = {
    router.filter[CommonFilters]
      .add[http.CacheController]
  }

  override protected def configureThrift(router: ThriftRouter): Unit = {
    router.filter[CommonFilters]
      .add[CacheController]
  }
}
