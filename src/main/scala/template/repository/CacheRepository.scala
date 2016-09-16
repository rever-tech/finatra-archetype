package template.repository

import com.twitter.io.Buf.ByteArray

import scala.collection.mutable

/**
  * Created by SangDang on 9/16/16.
  */
trait CacheRepository[K, V] {
  def put(k: K, v: V)
  def get(k: K): V
}

class OnMemoryCacheRepository extends CacheRepository[AnyRef, AnyRef] {
  val cache = new mutable.HashMap[AnyRef, AnyRef]

  override def put(k: AnyRef, v: AnyRef): Unit = cache.put(k, v)

  override def get(k: AnyRef): AnyRef = cache.get(k)
}

abstract class RedisCacheRepository extends CacheRepository[ByteArray, ByteArray] {

}
