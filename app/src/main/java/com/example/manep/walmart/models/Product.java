
package com.example.manep.walmart.models;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "productId",
    "productName",
    "shortDescription",
    "longDescription",
    "price",
    "productImage",
    "reviewRating",
    "reviewCount",
    "inStock"
})
public class Product {

    @JsonProperty("productId")
    private String productId;
    @JsonProperty("productName")
    private String productName;
    @JsonProperty("shortDescription")
    private String shortDescription;
    @JsonProperty("longDescription")
    private String longDescription;
    @JsonProperty("price")
    private String price;
    @JsonProperty("productImage")
    private String productImage;
    @JsonProperty("reviewRating")
    private Integer reviewRating;
    @JsonProperty("reviewCount")
    private Integer reviewCount;
    @JsonProperty("inStock")
    private Boolean inStock;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("productId")
    public String getProductId() {
        return productId;
    }

    @JsonProperty("productId")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @JsonProperty("productName")
    public String getProductName() {
        return productName;
    }

    @JsonProperty("productName")
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @JsonProperty("shortDescription")
    public String getShortDescription() {
        return shortDescription;
    }

    @JsonProperty("shortDescription")
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @JsonProperty("longDescription")
    public String getLongDescription() {
        return longDescription;
    }

    @JsonProperty("longDescription")
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonProperty("productImage")
    public String getProductImage() {
        return productImage;
    }

    @JsonProperty("productImage")
    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    @JsonProperty("reviewRating")
    public Integer getReviewRating() {
        return reviewRating;
    }

    @JsonProperty("reviewRating")
    public void setReviewRating(Integer reviewRating) {
        this.reviewRating = reviewRating;
    }

    @JsonProperty("reviewCount")
    public Integer getReviewCount() {
        return reviewCount;
    }

    @JsonProperty("reviewCount")
    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    @JsonProperty("inStock")
    public Boolean getInStock() {
        return inStock;
    }

    @JsonProperty("inStock")
    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
