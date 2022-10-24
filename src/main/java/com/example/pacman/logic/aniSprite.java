package com.example.pacman.logic;

import java.util.*;
import javafx.scene.image.Image;
import java.lang.Math;

public class aniSprite {

    private Image image;
    private double x;
    private double y;
    private double velocityX;
    private double velocityY;
    private double width;
    private double height;
    private Direction dir;

    public enum Direction {
        LEFT,RIGHT, UP, DOWN
    };

    public aniSprite(Image image, double x, double y) {
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.x = x;
        this.y = y;
        velocityX = 0;
        velocityY = 0;
    }

    public void setImage(Image i) {
        image = i;
        width = i.getWidth();
        height = i.getHeight();
    }
    public boolean collisioncheck(aniSprite sprite) {
        if ((x+width) > sprite.x) {
            return true;
        }
        if ((y+height) > sprite.y) {
            return true;
        }
        if ((sprite.x+sprite.width) > x) {
            return true;
        }
        if ((sprite.y + sprite.height) > y) {
            return true;
        }
        return false;
    }
    public void changeDirection(Direction d) {
        dir = d;
        if (dir == Direction.LEFT) {
            //change sprite image
            velocityY = 0;
            velocityX = -abs(velocityX);
        }
        if (dir == Direction.RIGHT) {
            //change sprite
            velocityY = 0;
            velocityX = abs(velocityX);
        }
        if (dir == Direction.UP) {
            //change sprite
            velocityX = 0;
            velocityY = -abs(velocityX);
        }
        if (dir == Direction.DOWN) {
            //change sprite
            velocityX = 0;
            velocityY = abs(velocityX);
        }
    }

    public void changeVelocity(double factor) {
        velocityX = velocityX * factor;
        velocityY = velocityY * factor;
    }
}
