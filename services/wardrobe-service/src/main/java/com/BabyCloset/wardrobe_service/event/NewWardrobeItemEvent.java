package com.BabyCloset.wardrobe_service.event;

public class NewWardrobeItemEvent {
    private String itemId;
    private String name;
    private String size;
    private String category;

    public NewWardrobeItemEvent() {}

    public NewWardrobeItemEvent(String itemId, String name, String size, String category) {
        this.itemId = itemId;
        this.name = name;
        this.size = size;
        this.category = category;
    }

    public String getItemId() { return itemId; }
    public void setItemId(String itemId) { this.itemId = itemId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}