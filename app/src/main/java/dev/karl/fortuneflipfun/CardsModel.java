package dev.karl.fortuneflipfun;

public class CardsModel {
    public Integer resource, colorIndicator;
    public Boolean isFlippedOpen, done;


    public CardsModel(Integer resource, Boolean isFlippedOpen, Integer colorIndicator) {
        this.resource = resource;
        this.colorIndicator = colorIndicator;
        this.isFlippedOpen = isFlippedOpen;
        this.done = false;
    }
}
