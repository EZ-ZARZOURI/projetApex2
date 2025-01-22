#!/bin/bash

# Save the starting directory
START_DIR=$(pwd)

# Check if the initialization is already complete
if [ ! -f /tmp/setup_complete ]; then
    echo "Waiting for Oracle DB to start..."
    sleep 20

    echo "Connecting to Oracle as SYSDBA and setting up the environment..."

    # Running SQL commands to create and configure the user
    sqlplus sys/oracle@localhost:1521/XE as sysdba <<EOF
    WHENEVER SQLERROR EXIT SQL.SQLCODE;
    CREATE USER DOSI IDENTIFIED BY DOSI;
    GRANT CONNECT, RESOURCE, DBA TO DOSI;
    ALTER USER SYS IDENTIFIED BY dosi;
    ALTER USER SYSTEM IDENTIFIED BY dosi;
    GRANT ALL PRIVILEGES TO SYS;
    EXIT;
EOF

    # Mark setup as complete to avoid re-execution
    touch /tmp/setup_complete
    echo "Database setup completed."
else
    echo "Database already initialized, skipping setup."
fi

# Return to the original directory
cd $START_DIR
