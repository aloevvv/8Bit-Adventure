import pygame
import sys

# Initialize pygame
pygame.init()

# Set up display
WIDTH, HEIGHT = 640, 480
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("Move the Character!")

# Load character image
character_img = pygame.image.load("character.png")  # Make sure this file exists!
character_rect = character_img.get_rect(center=(WIDTH//2, HEIGHT//2))

# Set up movement speed
speed = 5

# Game loop
running = True
while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    keys = pygame.key.get_pressed()
    if keys[pygame.K_LEFT]:
        character_rect.x -= speed
    if keys[pygame.K_RIGHT]:
        character_rect.x += speed
    if keys[pygame.K_UP]:
        character_rect.y -= speed
    if keys[pygame.K_DOWN]:
        character_rect.y += speed

    screen.fill((255, 255, 255))  # Fill screen with white
    screen.blit(character_img, character_rect)  # Draw character image

    pygame.display.flip()
    pygame.time.Clock().tick(60)  # Limit to 60 FPS

pygame.quit()
sys.exit()