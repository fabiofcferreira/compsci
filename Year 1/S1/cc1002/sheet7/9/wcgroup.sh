#!/bin/bash

# verify if there is at least 1 file argument
if [ $# -lt 1 ]
then
  echo "Needs at least 1 file"
  exit 126
fi

# calculate each file's line count and sum
let c=0
for arg in "$@"; do
  c=$(($c + $(wc -l $arg | cut -b 1) ))
done
echo $c

exit 0