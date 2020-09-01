#! /bin/bash

#循环遍历文件每一行:流程控制语句
# 定义一个计数器num
# 打印num正好是文件行数

echo "------第1种写法-------"
oldIFS=$IFS
IFS=$'\n'
num=0
for i in $(cat "$1") ; do
    echo "$i";
    ((num++))
done
echo "num:$num"
IFS=oldIFS

echo -e "\n------第2种写法-------"
num=0
lines=$(cat "$1" | wc -l)
for (( i = 1; i <= lines; i++ )); do
    line=$(head -$i "$1" |tail -1)
    echo "$line"
    ((num++))
done
echo "num:$num"

echo -e "\n------第3种写法-------"
num=0
while read line; do
    echo "$line"
    ((num++))
done <"$1"
echo "num:$num"