#!/bin/bash

echo -n "Number? "
read number

if (($number % 2 == 0))
then
  echo "Even"
else
  echo "Odd"
fi
