package com.example.manep.walmart;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.manep.walmart.models.ProductDetailsData;
import com.example.manep.walmart.networkcalls.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {

    int pageNumber = 0;
    ListView productListView;
    int visibleThreshold = 4;
    int currentProductPage = 0;
    int previousProductTotalItemCount = 0;
    boolean loading = true;
    int startingPageIndex = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        productListView = findViewById(R.id.product_list);
        loadData("1",getApplicationContext());



        productListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }
            @Override
            public void onScroll(AbsListView absListView, int firstProductVisibleItem, int visibleProductItemCount, int totalProductItemCount) {
                if (totalProductItemCount < previousProductTotalItemCount) {
                        currentProductPage = startingPageIndex;
                        previousProductTotalItemCount = totalProductItemCount;
                        if (totalProductItemCount == 0) {
                            loadData("1",getApplicationContext());
                        }
                    }
                if (loading && (totalProductItemCount >= previousProductTotalItemCount)) {
                    loading = false;
                    previousProductTotalItemCount = totalProductItemCount;
                    currentProductPage++;
                }

                if (!loading && (firstProductVisibleItem + visibleProductItemCount + visibleThreshold) > totalProductItemCount ) {
                        String s = String.valueOf(currentProductPage);
                    loadData(s,getApplicationContext());
                    loading = true;
                }


            }
        });
    }
    private void loadData(String pageNo, Context applicationContext) {
        ApiUtils.walmartServiceCall(applicationContext).getRetroProductDetails(pageNo,"30").enqueue(new Callback<ProductDetailsData>() {
            @Override
            public void onResponse(Call<ProductDetailsData> call, Response<ProductDetailsData> response) {
                if (response.isSuccessful()){
                    Integer x = response.body().getTotalProducts();

                    pageNumber = Math.round(x / 30) ;
                    ProductListViewAdapter  productListViewAdapter = new ProductListViewAdapter(response.body().getProducts(),true,getApplicationContext());
                    productListView.setAdapter(productListViewAdapter);

                }else{

                }

            }

            @Override
            public void onFailure(Call<ProductDetailsData> call, Throwable t) {

            }
        });
    }


}
