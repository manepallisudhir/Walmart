package com.example.manep.walmart;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.manep.walmart.models.Product;

import java.io.Serializable;
import java.util.List;

public class ProductListViewAdapter extends BaseAdapter{
    List<Product> products;
    boolean isListView;
    LayoutInflater inflater;
    Context context;
    String TAG;
    public ProductListViewAdapter(List<Product> products, boolean isListView, Context applicationContext) {
        this.products = products;
        this.isListView = isListView;
        context = applicationContext;
        inflater = LayoutInflater.from(applicationContext);
    }

    @Override
    public int getCount() {
        if (products.size()>0){
            return products.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return products.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            viewHolder = new ViewHolder();



            //inflate the layout on basis of boolean
            if (isListView)
                view = inflater.inflate(R.layout.prodcutitem_custom_layout, viewGroup, false);

            viewHolder.productPrice = view.findViewById(R.id.product_price);
            viewHolder.productTitle = view.findViewById(R.id.product_title);
            viewHolder.productImage = view.findViewById(R.id.product_image);
            viewHolder.productTitle.setText(products.get(i).getProductName());
            viewHolder.productPrice.setText(products.get(i).getPrice());
            Glide.with(context).load("https://mobile-tha-server.appspot.com" + products.get(i).getProductImage()).diskCacheStrategy(DiskCacheStrategy.ALL).into(viewHolder.productImage);

        }
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent =  new Intent(context,ProductSpecificationDetail.class);
                    AppData.addTransitionData(products.get(i));
                    context.startActivity(intent);
                }
            });
        }
        return view;

    }
    private class ViewHolder {
        private TextView productTitle,productPrice;
        private ImageView productImage;
    }
}
