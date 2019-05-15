package com.zhiliang.persistence.entity;

import java.io.Serializable;

import com.repast.core.annotation.Column;
import com.repast.core.annotation.Entity;
import com.repast.core.annotation.ID;
import com.repast.core.annotation.Transient;
import com.repast.core.system.BaseEntity;
 
/**
 * 
 * Company:
 * 表zl_b_trading_recode 的实体类
 * @author superma
 */
@Entity(name = "zl_b_trading_recode")
public class ZlBTradingRecode extends BaseEntity implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 2771520536458495846L;
	
	public ZlBTradingRecode clone() {
		ZlBTradingRecode o = null;
		try {
			o = (ZlBTradingRecode) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}
	
    @ID
	@Column(name = "tradingid", comment = "主键id")
	private String tradingid;
	
	@Column(name = "tradename", comment = "交易商姓名")
	private String tradename;
	
	
	@Column(name = "settlement", comment = "交收地")
	private String settlement;
	
	@Column(name = "tradevolume", comment = "成交量")
	private String tradevolume;
	
	@Column(name = "planttype", comment = "种植种类")
	private String planttype;
	
	@Column(name = "price", comment = "价格")
	private String price;
	
	@Column(name = "recodetime", comment = "交收日期")
	private String recodetime;
	
	@Column(name = "ctime", comment = "生成时间")
	private String ctime;
	
	@Column(name = "spareone", comment = "产地")
	private String spareone;
	
	@Column(name = "sparetwo", comment = "价格类型")
	private String sparetwo;
	
	@Column(name = "spareth", comment = "订单编号")
	private String spareth;
	
	@Column(name = "levelcode", comment = "货品等级")
	private String levelcode;
	@Column(name = "newsid", comment = "新闻id")
	private String newsid;
	@Column(name = "userid", comment = "访问者id")
	private String userid;
	@Column(name = "num", comment = "累积浏览次数")
	private String num;
	@Transient
	@Column(name = "newstitle", comment = "新闻标题")
	private String newstitle;
	@Transient
	@Column(name = "username", comment = "浏览者")
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNewstitle() {
		return newstitle;
	}

	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}

	public String getNewsid() {
		return newsid;
	}

	public void setNewsid(String newsid) {
		this.newsid = newsid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getLevelcode() {
		return levelcode;
	}

	public void setLevelcode(String levelcode) {
		this.levelcode = levelcode;
	}

	public String getTradingid() {
		return tradingid;
	}

	public String getTradename() {
		return tradename;
	}

	public String getSettlement() {
		return settlement;
	}

	public String getTradevolume() {
		return tradevolume;
	}

	public String getPlanttype() {
		return planttype;
	}

	public String getPrice() {
		return price;
	}

	public String getRecodetime() {
		return recodetime;
	}

	public String getCtime() {
		return ctime;
	}

	public String getSpareone() {
		return spareone;
	}

	public String getSparetwo() {
		return sparetwo;
	}

	public String getSpareth() {
		return spareth;
	}

	public void setTradingid(String tradingid) {
		this.tradingid = tradingid;
	}

	public void setTradename(String tradename) {
		this.tradename = tradename;
	}

	public void setSettlement(String settlement) {
		this.settlement = settlement;
	}

	public void setTradevolume(String tradevolume) {
		this.tradevolume = tradevolume;
	}

	public void setPlanttype(String planttype) {
		this.planttype = planttype;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setRecodetime(String recodetime) {
		this.recodetime = recodetime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public void setSpareone(String spareone) {
		this.spareone = spareone;
	}

	public void setSparetwo(String sparetwo) {
		this.sparetwo = sparetwo;
	}

	public void setSpareth(String spareth) {
		this.spareth = spareth;
	}

	
}