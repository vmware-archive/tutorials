# This Docker image uses the latest version of the Bitnami Node 7 Docker image
FROM bitnami/node:7

# Install additional dependencies required by the app
RUN install_packages libkrb5-dev

# Copy application source code to /app directory 
# of  your container
COPY app-code /app

# Actions will be performed by the user 'bitnami', so it's good practice
# to explicitly set the required permissions
RUN chown -R bitnami:bitnami /app /home/bitnami 

# Change the effective UID from 'root' to 'bitnami'
# Never run application code as 'root'!
USER bitnami

# The application's directory will be the working directory
WORKDIR /app

# Install dependencies of your app, defined into package.json
RUN npm install 

# Run your app!
CMD ["npm", "start"] 

