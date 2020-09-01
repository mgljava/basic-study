#! /bin/bash
if [ test 3 -gt 2 ]; then
  echo ok
else
  echo fail
fi

local a=1
while test $a -le 5; do
  echo $a
  ((a++))
done

for ((i = 0; i < 10; i++)); do
  echo $i
done

for i in {{1,2,3,4,5}}; do
  echo $i
done


for i in `seq 5` ; do
    echo $i
done