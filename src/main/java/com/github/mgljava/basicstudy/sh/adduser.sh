#! /bin/bash
[ ! $# -eq 1 ] && echo "参数错误！" && exit 2
id "$1" >&/dev/null && echo "用户已经存在！" && exit 3
useradd "$1" >&/dev/null && echo "$1" | passwd --stdin "$1" >&/dev/null && echo "用户添加成功！" && exit 4
echo "我不知道怎么办！" && exit 5
# echo "$1" | passwd --stdin "$1"
# echo "$1" | passwd --stdin "$1" >&/dev/null # 将日志输出到 /dev/null
# echo "user add success"