#@namespace scala template.service
include "UserCacheDT.thrift"

service TUserCacheService {
    void addUser(1: required UserCacheDT.TUserInfo userInfo)
    UserCacheDT.TUserInfo getUser(1:required UserCacheDT.TUserID userId)
}

