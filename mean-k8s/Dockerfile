# This Docker image uses the latest version of the Bitnami Node 7 Docker image
# and uses Docker multistage builds

# Use bitnami/node:7 for the build stage
FROM bitnami/node:7 as builder

# Install additional dependencies required by the app
RUN install_packages libkrb5-dev

# Copy application source code to /app directory
# of  your container
COPY app-code /app

# Install dependencies of your app, defined into package.json
RUN npm install

# Use bitnami/node:7-prod for the target image
FROM bitnami/node:7-prod

# Copy the application and installed modules from the previous build stage
COPY --from=builder /app /app

# Actions will be performed by a non-root user id '1001', so it's good
# practice to explicitly set the required permissions
RUN chown -R 1001:1001 /app

# Change the effective UID from 'root' to '1001'
# Never run application code as 'root'!
USER 1001

# The application's directory will be the working directory
WORKDIR /app

# Run your app!
CMD ["npm", "start"]
