/*
 * Created on 2 Oct 2017 ( Time 15:15:02 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.demo.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "cc_currency_purchases"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="cc_currency_purchases", catalog="cryptocurrency" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="CcCurrencyPurchasesEntity.countAll", query="SELECT COUNT(x) FROM CcCurrencyPurchasesEntity x" )
} )
public class CcCurrencyPurchasesEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="ID", nullable=false)
    private Integer    id           ;

    @Column(name="USER_ID")
    private Integer    userId       ;

    @Column(name="CURRENCY_NAME", length=20)
    private String     currencyName ;

    @Column(name="QUANTITY")
    private Integer    quantity     ;

    @Column(name="PRICE")
    private BigDecimal price        ;

    @Column(name="TOTAL_AMT")
    private BigDecimal totalAmt     ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="PURCHASE_DATE")
    private Date       purchaseDate ;

    @Column(name="IS_SOLD", length=1)
    private String     isSold       ;

    @Column(name="SELL_PRICE")
    private BigDecimal sellPrice    ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="SELL_DATE")
    private Date       sellDate     ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public CcCurrencyPurchasesEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : ID ( INT ) 
    public void setId( Integer id ) {
        this.id = id;
    }
    public Integer getId() {
        return this.id;
    }

    //--- DATABASE MAPPING : USER_ID ( INT ) 
    public void setUserId( Integer userId ) {
        this.userId = userId;
    }
    public Integer getUserId() {
        return this.userId;
    }

    //--- DATABASE MAPPING : CURRENCY_NAME ( VARCHAR ) 
    public void setCurrencyName( String currencyName ) {
        this.currencyName = currencyName;
    }
    public String getCurrencyName() {
        return this.currencyName;
    }

    //--- DATABASE MAPPING : QUANTITY ( INT ) 
    public void setQuantity( Integer quantity ) {
        this.quantity = quantity;
    }
    public Integer getQuantity() {
        return this.quantity;
    }

    //--- DATABASE MAPPING : PRICE ( DECIMAL ) 
    public void setPrice( BigDecimal price ) {
        this.price = price;
    }
    public BigDecimal getPrice() {
        return this.price;
    }

    //--- DATABASE MAPPING : TOTAL_AMT ( DECIMAL ) 
    public void setTotalAmt( BigDecimal totalAmt ) {
        this.totalAmt = totalAmt;
    }
    public BigDecimal getTotalAmt() {
        return this.totalAmt;
    }

    //--- DATABASE MAPPING : PURCHASE_DATE ( DATETIME ) 
    public void setPurchaseDate( Date purchaseDate ) {
        this.purchaseDate = purchaseDate;
    }
    public Date getPurchaseDate() {
        return this.purchaseDate;
    }

    //--- DATABASE MAPPING : IS_SOLD ( CHAR ) 
    public void setIsSold( String isSold ) {
        this.isSold = isSold;
    }
    public String getIsSold() {
        return this.isSold;
    }

    //--- DATABASE MAPPING : SELL_PRICE ( DECIMAL ) 
    public void setSellPrice( BigDecimal sellPrice ) {
        this.sellPrice = sellPrice;
    }
    public BigDecimal getSellPrice() {
        return this.sellPrice;
    }

    //--- DATABASE MAPPING : SELL_DATE ( DATETIME ) 
    public void setSellDate( Date sellDate ) {
        this.sellDate = sellDate;
    }
    public Date getSellDate() {
        return this.sellDate;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append("]:"); 
        sb.append(id);
        sb.append("|");
        sb.append(userId);
        sb.append("|");
        sb.append(currencyName);
        sb.append("|");
        sb.append(quantity);
        sb.append("|");
        sb.append(price);
        sb.append("|");
        sb.append(totalAmt);
        sb.append("|");
        sb.append(purchaseDate);
        sb.append("|");
        sb.append(isSold);
        sb.append("|");
        sb.append(sellPrice);
        sb.append("|");
        sb.append(sellDate);
        return sb.toString(); 
    } 

}