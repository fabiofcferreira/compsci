#!/bin/bash

echo -n "Number? "
read number

if (($number % 2 == 0))
then
  echo "par"
else
  echo "impar"
fi

exit 0