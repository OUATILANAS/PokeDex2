package com.example.pokdex.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pokemon {
    private int number;
    private String name;
    private String url;
    @SerializedName("stats")
    private List<Stat> stats;

    @SerializedName("types")
    private List<Type> types;
    private int height;
    private int weight;
    private int order;


    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumber() {
        String[] urlPartes = url.split("/");
        return Integer.parseInt(urlPartes[urlPartes.length - 1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
