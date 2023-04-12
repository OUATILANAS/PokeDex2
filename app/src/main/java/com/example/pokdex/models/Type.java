package com.example.pokdex.models;

import com.google.gson.annotations.SerializedName;

public class Type {



    @SerializedName("type")
    private TypeInfo type;

    public TypeInfo getType() {
        return type;
    }

    public void setType(TypeInfo type) {
        this.type = type;
    }
}
