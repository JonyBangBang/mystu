package com.gn.stu.athink;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @program mystu
 * @description:
 * @author: gaoning
 * @create: 2019/11/04 15:19
 */
public class AlDemo2 {

    public  List<Product> shareCaculate(Long total,List<Product> productList){
        //总价
        Long perseAll = 0L;
        for(Product p:productList){
            //每种商品总价格、和所有商品的总价
            long ap = p.getQuantity()*p.getUnitPrice();
            perseAll+=ap;
            p.setAmount(ap);
        }
        //第一遍
        int index=0;
        for(int i=0;i<productList.size()-1;i++){
            if(productList.get(i).getAmount()>productList.get(i+1).getAmount()){
                index = i;
            }
        }
        //控制精度整数
        DecimalFormat format = new DecimalFormat("#");
        for(Product p:productList){
            double per = p.getAmount()/perseAll;
            double shareFee = total*per;
            long realAmount = (Long.valueOf(format.format(shareFee)));
            p.setAmount(realAmount);
        }
        //舍弃掉的小数相加到最大价值的商品上
        long wTotal =  productList.stream().mapToLong(Product::getAmount).sum();
        long wc = total-wTotal;
        productList.get(index).setAmount(productList.get(index)  .getAmount()+wc);  ;
        return productList;
    }

    public static void main(String[] args) {

       List<Product> productList1 = new ArrayList<>();
        for(int i=0;i<3;i++){
            Product p = new Product();
            p.setQuantity(10);
            p.setUnitPrice(4L);
            productList1.add(p);
        }
        AlDemo2 a = new AlDemo2();
        a.shareCaculate(100L,productList1);
        for(Product p:productList1){
            System.out.println(p.getAmount());
        }
    }
}
class Product{
    /**
     *产品单价
     */
    private Long unitPrice;
    /**
     *产品数量
     */
    private int quantity;
    /**
     *产品分摊所得金额
     */
    private Long amount;

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
