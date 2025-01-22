# Use the official Oracle XE 11g image
FROM oracleinanutshell/oracle-xe-11g

# Set environment variables
ENV ORACLE_ALLOW_REMOTE=true

# Copy the initialization script into the container
COPY ./init.sh /docker-entrypoint-initdb.d/init.sh

# Ensure the script has execution permissions
RUN chmod +x /docker-entrypoint-initdb.d/init.sh

# Expose Oracle and any additional ports
EXPOSE 1521 8080

# Default command to start Oracle and then run the initialization script
CMD /usr/sbin/startup.sh && /docker-entrypoint-initdb.d/init.sh && tail -f /dev/null
