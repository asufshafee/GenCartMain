package b2infosoft.gencart.com.pojo;

import android.content.Context;
import android.util.Log;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Microsoft on 6/2/2017.
 */

public class MyOrderPojo {

    public String OrderID = "";
    public String OrderTime = "";
    public String Mobileno = "";
    public String delivery_address = "";
    public String delivery_amount = "";
    public String item_total = "";
    public String item_total_amount = "";
    public String tax_amount = "";
    public String discount = "";
    public String discount_type = "";
    public String pay_mode = "";
    public String order_id = "";
    public String product_id = "";
    public String quantity = "";
    public String name = "";
    public String unit_price = "";
    public String container_charge = "";
    public String product_total = "";
    public String restaurant_id = "";
    public String OrderItem_id = "";
    public String status = "";
    public String Restaurant_name = "";
    public String half_label = "";
    public String half_qty = "";
    public String half_price = "";
    public String medium_label = "";
    public String medium_qty = "";
    public String medium_price = "";
    public String full_label = "";
    public String full_qty = "";
    public String full_price = "";
    public String large_label = "";
    public String large_qty = "";
    public String large_price = "";
    public String cart_total = "";
    public String order_review_status = "";
    public String after_dis_total = "";
    public String after_gst_total = "";

    public MyOrderPojo(String orderItem_id, String order_id, String product_id, String quantity, String name, String unit_price, String container_charge, String product_total, String restaurant_id,
                       String half_label,
                       String half_qty,
                       String half_price,
                       String medium_label,
                       String medium_qty,
                       String medium_price,
                       String full_label,
                       String full_qty,
                       String full_price,
                       String large_label,
                       String large_qty,
                       String large_price, String OrderTime) {
        OrderItem_id = orderItem_id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.name = name;
        this.unit_price = unit_price;
        this.container_charge = container_charge;
        this.product_total = product_total;
        this.restaurant_id = restaurant_id;
        this.half_label = half_label;
        this.half_qty = half_qty;
        this.half_price = half_price;
        this.medium_label = medium_label;
        this.medium_qty = medium_qty;
        this.medium_price = medium_price;
        this.full_label = full_label;
        this.full_qty = full_qty;
        this.full_price = full_price;
        this.large_label = large_label;
        this.large_qty = large_qty;
        this.large_price = large_price;
        this.OrderTime = OrderTime;

    }


    public MyOrderPojo(String orderID, String mobileno, String delivery_address, String delivery_amount, String item_total, String item_total_amount, String tax_amount, String discount, String discount_type, String pay_mode, String status, String rstName, String restaurant_id
            , String cart_total, String order_review_status, String after_dis_total, String after_gst_total) {
        OrderID = orderID;
        Mobileno = mobileno;
        this.delivery_address = delivery_address;
        this.delivery_amount = delivery_amount;
        this.item_total = item_total;
        this.item_total_amount = item_total_amount;
        this.tax_amount = tax_amount;
        this.discount = discount;
        this.discount_type = discount_type;
        this.pay_mode = pay_mode;
        this.status = status;
        this.Restaurant_name = rstName;
        this.restaurant_id = restaurant_id;
        this.cart_total = cart_total;
        this.order_review_status = order_review_status;
        this.after_dis_total = after_dis_total;
        this.after_gst_total = after_gst_total;


    }


    public MyOrderPojo(String orderID, String orderTime, String orderStatus) {
        OrderID = orderID;
        OrderTime = orderTime;
    }}


  /*  public static void getOrderList(final Context mContext, String UserID, final String FromWhere) {
        final ArrayList<MyOrderPojo> orderList = new ArrayList<>();
        final ArrayList<MyOrderPojo> productList = new ArrayList<>();
        WebServiceCaller webServiceCaller = new WebServiceCaller(WebServiceCaller.POST_TASK, mContext, "Please wait...", false) {
            @Override
            public void handleResponse(String response) {
                Log.d("response", response);
                try {
                    JSONObject mainObject = new JSONObject(response);
                    JSONArray dataArray = mainObject.getJSONArray("data");
                    for (int i = 0; i < dataArray.length(); i++) {
                        JSONObject dataObject = dataArray.getJSONObject(i);
                        JSONObject Order = dataObject.getJSONObject("Order");
                        JSONArray OrderItem = dataObject.getJSONArray("OrderItem");
                        JSONObject restData = dataObject.getJSONObject("Restaurant");
                        // for (int j = 0; j<Order.length(); j++){
                        orderList.add(new MyOrderPojo(
                                Order.getString("id"),
                                Order.getString("cel"),
                                Order.getString("delivery_address"),
                                Order.getString("delivery_amount"),
                                Order.getString("item_total"),
                                Order.getString("item_total_amount"),
                                Order.getString("tax_amount"),
                                Order.getString("discount_amount"),
                                Order.getString("discount_type"),
                                Order.getString("pay_mode"),
                                Order.getString("status"),
                                restData.getString("name"),
                                Order.getString("restaurant_id"),
                                Order.getString("cart_total"),
                                Order.getString("order_review_status"),
                                Order.getString("after_dis_total"),
                                Order.getString("after_gst_total")
                        ));

                        for (int j = 0; j < OrderItem.length(); j++) {
                            JSONObject jsonObject = OrderItem.getJSONObject(j);
                            productList.add(new MyOrderPojo(
                                    jsonObject.getString("id"),
                                    jsonObject.getString("order_id"),
                                    jsonObject.getString("product_id"),
                                    jsonObject.getString("quantity"),
                                    jsonObject.getString("name"),
                                    jsonObject.getString("unit_price"),
                                    jsonObject.getString("container_charge"),
                                    jsonObject.getString("product_total"),
                                    jsonObject.getString("restaurant_id"),
                                    jsonObject.getString("half_label"),
                                    jsonObject.getString("half_qty"),
                                    jsonObject.getString("half_price"),
                                    jsonObject.getString("medium_label"),
                                    jsonObject.getString("medium_qty"),
                                    jsonObject.getString("medium_price"),
                                    jsonObject.getString("full_label"),
                                    jsonObject.getString("full_qty"),
                                    jsonObject.getString("full_price"),
                                    jsonObject.getString("large_label"),
                                    jsonObject.getString("large_qty"),
                                    jsonObject.getString("large_price"),
                                    jsonObject.getString("created")));
                        }
                    }

                    if (!orderList.isEmpty()) {
                        if (FromWhere.equals("OrderStatus")) {
                            ((OrderStatusActivity) mContext).setOrderAdapter(orderList, productList);

                        } else {
                            ((MyOrdersActivity) mContext).setOrderAdapter(orderList, productList);
                        }
                    }

                } catch (JSONException e) {
                    if (FromWhere.equals("OrderStatus")) {
                        ((OrderStatusActivity) mContext).setOrderAdapter(orderList, productList);
                    } else {
                        ((MyOrdersActivity) mContext).setOrderAdapter(orderList, productList);
                    }
                    e.printStackTrace();
                }
            }
        };
        webServiceCaller.addNameValuePair("user_id", UserID);
        String url = AppGlobal.GetOrdersList;
        Log.d("url>>", url);
        webServiceCaller.execute(url);

    }*/



