#!/bin/bash

#use set to enable verbose output
set -euo pipefail

readonly CONF=WEB-INF/classes/database.properties

echo "current directory: " $PWD
echo "writing to file: " $CONF


echo "host=${DATABASE_HOST}" > $CONF
echo "user=${DATABASE_USER}" >> $CONF
echo "password=${DATABASE_PASSWORD}" >> $CONF


#sed -i -e "host#s#=${DATABASE_HOST}#" "$CONF"
#sed -i -e "user#s#=${DATABASE_USER}#" "$CONF"
#sed -i -e "password#s#=${DATABASE_PASSWORD}#" "$CONF"



# DATABASE_HOST: The hostname to use to connect to the database
# DATABASE_USER: The root username for the database. You can connect as this user and create other users if you require
# DATABASE_PASSWORD: The password for the root database user



