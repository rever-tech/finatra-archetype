#@namespace scala template.domain.thrift

struct TUserID{
    1:string id
}
struct TUserInfo{
    1:TUserID userId
    2:string username
    3:i32   age
    4:string sex
}
