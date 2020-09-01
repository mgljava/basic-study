#! /bin/bash
# 练习题：
#  用户给定路径
#  输出文件大小最大的文件
#  递归子目录

oldIFS=$IFS
IFS=$'\n'
for i in $(du -a "$1" | sort -nr);do
  filename=$(echo "$i" | awk -F' ' '{print $2}')
  if [ -f "$filename" ]; then
      echo "$filename"
      break;
  fi
done
IFS=oldIFS