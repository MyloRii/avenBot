# AvenBot
A Discord bot is created as a personal project to provide links and tips for games I play

Pull docker image to host machine: docker pull mylorii/avenbot
Run docker container with: docker run -e TOKEN(discord bot token) mylorii/avenbot

Note: I use 'screen' to detach window with application. So it is usefull to run 'screen' command before running docker container.
ctrl+a then ctrl+d to detach from window

Usefull docker commands:
- docker build {image} . - to build docker image inside project
- docker image ls - to see available images
- docker ps - to see running containers
- docker ps -a - to see all containers
- docker system prune -a - to delete all images and stopped containers
