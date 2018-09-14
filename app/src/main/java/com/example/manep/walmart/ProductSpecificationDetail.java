package com.example.manep.walmart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.manep.walmart.models.Product;

import java.io.Serializable;

public class ProductSpecificationDetail extends AppCompatActivity {

    TextView productTitle,productPrice,productReview,shrtDescription,longDescription,productStock;
    ImageView productImage;
    RatingBar productRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_specification_detail);
        productImage = findViewById(R.id.product_image);
        productPrice = findViewById(R.id.product_price);
        productRating = findViewById(R.id.reviewRating);
        productReview = findViewById(R.id.reviewCount);
        shrtDescription = findViewById(R.id.shortDescription);
        longDescription = findViewById(R.id.longDescription);
        productStock = findViewById(R.id.inStock);
        productTitle = findViewById(R.id.product_title);
        Product recievedData = (Product) AppData.getTransitionData();
        AppData.clearTransitionData();


        Glide.with(this).load("https://mobile-tha-server.appspot.com" + recievedData.getProductImage()).diskCacheStrategy(DiskCacheStrategy.ALL).into(productImage);

        Spanned text1 = Html.fromHtml(recievedData.getShortDescription());
        Spanned text2 = Html.fromHtml(recievedData.getShortDescription());
        productTitle.setText(recievedData.getProductName());
        productPrice.setText("Price "+recievedData.getPrice());
        productRating.setRating(recievedData.getReviewRating());
        productReview.setText(recievedData.getReviewCount().toString());
        if (recievedData.getInStock()){
            productStock.setText("InStock");
        }else {
            productStock.setText("Out of Stock");
        }

        shrtDescription.setText(text1);
        longDescription.setText(text2);






    }
}
