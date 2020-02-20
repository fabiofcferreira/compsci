#!/bin/bash

if [ $# -lt 2 -o $# -gt 2 ]
then
  echo "Invalid arguments"
  exit 126
fi

if [ $1 -gt $2 ]
then
  echo "$1"
else
  echo "$2"
fi

echo "Sum: $(($1 + $2))"
echo "Subtraction: $(($1 - $2))"
echo "Product: $(($1 * $2))"
echo "Division: $(($1 / $2))"
echo "Division rest: $(($1 % $2))"


exit 0