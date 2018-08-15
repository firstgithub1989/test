package com.app.trade.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cc_coin_list", catalog="cryptocurrency" )
public class CoinList {
	
	@Id
	@Column(name="SYMBOL", length=10)
	private String Symbol;
	
	@Column(name="PROOF_TYPE", length=40)
	private String ProofType;

	@Column(name="TOTAL_COIN_SUPPLY")
    private String TotalCoinSupply;

	@Column(name="COIN_NAME", length=20)
    private String CoinName;
	
	@Column(name="SORT_ORDER")
	private int SortOrder;

	@Column(name="IMAGE_URL", length=50)
    private String ImageUrl;

	@Column(name="ALGORITHM_NAME", length=20) 
    private String Algorithm;

	@Column(name="C_NAME", length=30)
    private String Name;

	@Column(name="URL", length=30)
    private String Url;

	@Column(name="FULL_NAME", length=30)
    private String FullName;

	@Column(name="SPONSORED", length=30)
    private String Sponsored;

	@Column(name="COIN_ID")
    private int Id;

	@Column(name="TOTAL_COIN_FREE_FLOAT")
    private String TotalCoinsFreeFloat;

	@Column(name="PRE_MINED_VALUE", length=40)
    private String PreMinedValue;

	@Column(name="FULLY_PRE_MINED", length=40)
    private String FullyPremined;

	public String getProofType() {
		return ProofType;
	}

	public String getTotalCoinSupply() {
		return TotalCoinSupply;
	}

	public String getCoinName() {
		return CoinName;
	}

	public int getSortOrder() {
		return SortOrder;
	}

	public String getImageUrl() {
		return ImageUrl;
	}

	public String getAlgorithm() {
		return Algorithm;
	}

	public String getName() {
		return Name;
	}

	public String getUrl() {
		return Url;
	}

	public String getSymbol() {
		return Symbol;
	}

	public String getFullName() {
		return FullName;
	}

	public String getSponsored() {
		return Sponsored;
	}

	public int getId() {
		return Id;
	}

	public String getTotalCoinsFreeFloat() {
		return TotalCoinsFreeFloat;
	}

	public String getPreMinedValue() {
		return PreMinedValue;
	}
	
	public String getFullyPremined() {
		return FullyPremined;
	}
}
