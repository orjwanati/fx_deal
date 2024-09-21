# Variables
DOCKER_IMAGE_NAME = fx_deal_app
DOCKER_COMPOSE_FILE = docker-compose.yml

.PHONY: build run start stop logs clean

# Build the Docker image for the app
build:
	@echo "Building Docker image..."
	docker build -t $(DOCKER_IMAGE_NAME) .

# Run the app using Docker Compose
run: build
	@echo "Starting services with Docker Compose..."
	docker-compose -f $(DOCKER_COMPOSE_FILE) up --build

# Start the app in detached mode
start:
	@echo "Starting services in detached mode..."
	docker-compose -f $(DOCKER_COMPOSE_FILE) up
# Stop the running containers
stop:
	@echo "Stopping running services..."
	docker-compose -f $(DOCKER_COMPOSE_FILE) down

# Display logs of running containers
logs:
	@echo "Fetching logs..."
	docker-compose -f $(DOCKER_COMPOSE_FILE) logs -f

# Clean up Docker images and containers
clean:
	@echo "Cleaning up containers and images..."
	docker-compose -f $(DOCKER_COMPOSE_FILE) down --rmi all --volumes --remove-orphans
	docker system prune -f
