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

class OnMemoryCacheRepository[K,V] extends CacheRepository[K, V] {
  val cache = new mutable.HashMap[K, V]

  override def put(k: K, v: V): Unit = cache.put(k, v)

  override def get(k: K): V = cache.get(k).get
}

abstract class RedisCacheRepository extends CacheRepository[ByteArray, ByteArray] {

}
