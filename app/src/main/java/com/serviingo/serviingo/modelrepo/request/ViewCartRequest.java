package com.serviingo.serviingo.modelrepo.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ViewCartRequest {
    @SerializedName("cart")
    @Expose
    private List<Cart> cart = null;

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }



    public class Cart {

        @SerializedName("food_id")
        @Expose
        private String foodId;
        @SerializedName("quantity")
        @Expose
        private Integer quantity;
        @SerializedName("varient_id")
        @Expose
        private String varientId;
        @SerializedName("required_item_id")
        @Expose
        private Object requiredItemId;
        @SerializedName("cooking_levels")
        @Expose
        private Object cookingLevels;
        @SerializedName("ingredients")
        @Expose
        private List<Integer> ingredients = null;
        @SerializedName("addons")
        @Expose
        private List<Addon> addons = null;
        @SerializedName("special_request")
        @Expose
        private String specialRequest;

        public String getFoodId() {
            return foodId;
        }

        public void setFoodId(String foodId) {
            this.foodId = foodId;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public String getVarientId() {
            return varientId;
        }

        public void setVarientId(String varientId) {
            this.varientId = varientId;
        }

        public Object getRequiredItemId() {
            return requiredItemId;
        }

        public void setRequiredItemId(Object requiredItemId) {
            this.requiredItemId = requiredItemId;
        }

        public Object getCookingLevels() {
            return cookingLevels;
        }

        public void setCookingLevels(Object cookingLevels) {
            this.cookingLevels = cookingLevels;
        }

        public List<Integer> getIngredients() {
            return ingredients;
        }

        public void setIngredients(List<Integer> ingredients) {
            this.ingredients = ingredients;
        }

        public List<Addon> getAddons() {
            return addons;
        }

        public void setAddons(List<Addon> addons) {
            this.addons = addons;
        }

        public String getSpecialRequest() {
            return specialRequest;
        }

        public void setSpecialRequest(String specialRequest) {
            this.specialRequest = specialRequest;
        }



        public class Addon {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("quantity")
            @Expose
            private Integer quantity;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getQuantity() {
                return quantity;
            }

            public void setQuantity(Integer quantity) {
                this.quantity = quantity;
            }

        }

    }

}