package in.anubhav.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
//@Table(name = "route_ebix")
@Table(name = "anubhav_route_ebix")
public class Result {

	@Id
	@Column(name = "route_id")
	private Integer routeId;
	
	@Column(name = "route_no")
	private String routeNo;
	
	@Column(name = "route_name")
	private String routeName;
	

    @Column(name = "rt_id")
	private Integer rtId;
    
    @Column(name = "from_stop")
	private Integer fromStopId;
    
    @Column(name = "till_stop")
	private Integer tillStopId;
    
    @Column(name = "route_type")
	private String routeType;
    
    @Column(name = "intra_state_distance")
	private Double intraStateDistance;
    
    @Column(name = "inter_state_distance")
	private Double interStateDistance;
    
    @Column(name = "route_km")
	private Double routekm;
    
    @Column(name = "up_down_ind")
	private String updownInd;
    
    @Column(name = "pl_cd")
	private String plCd;

    @Column(name = "md_date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime mdDate;

    /*
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	*/
	public Integer getRouteId() {
		return routeId;
	}

	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	public String getRouteNo() {
		return routeNo;
	}

	public void setRouteNo(String routeNo) {
		this.routeNo = routeNo;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public Integer getRtId() {
		return rtId;
	}

	public void setRtId(Integer rtId) {
		this.rtId = rtId;
	}

	public Integer getFromStopId() {
		return fromStopId;
	}

	public void setFromStopId(Integer fromStopId) {
		this.fromStopId = fromStopId;
	}

	public Integer getTillStopId() {
		return tillStopId;
	}

	public void setTillStopId(Integer tillStopId) {
		this.tillStopId = tillStopId;
	}

	public String getRouteType() {
		return routeType;
	}

	public void setRouteType(String routeType) {
		this.routeType = routeType;
	}

	public Double getInterStateDistance() {
		return interStateDistance;
	}

	public void setInterStateDistance(Double interStateDistance) {
		this.interStateDistance = interStateDistance;
	}

	public Double getRoutekm() {
		return routekm;
	}

	public void setRoutekm(Double routekm) {
		this.routekm = routekm;
	}

	public String getUpdownInd() {
		return updownInd;
	}

	public void setUpdownInd(String updownInd) {
		this.updownInd = updownInd;
	}

	public String getPlCd() {
		return plCd;
	}

	public void setPlCd(String plCd) {
		this.plCd = plCd;
	}

	public Double getIntraStateDistance() {
		return intraStateDistance;
	}

	public void setIntraStateDistance(Double intraStateDistance) {
		this.intraStateDistance = intraStateDistance;
	}

	public LocalDateTime getMdDate() {
		return mdDate;
	}

	public void setMdDate(LocalDateTime mdDate) {
		this.mdDate = mdDate;
	}

	@Override
	public String toString() {
		return "Result [, routeId=" + routeId + ", routeNo=" + routeNo + ", routeName=" + routeName
				+ ", rtId=" + rtId + ", fromStopId=" + fromStopId + ", tillStopId=" + tillStopId + ", routeType="
				+ routeType + ", intraStateDistance=" + intraStateDistance + ", interStateDistance="
				+ interStateDistance + ", routekm=" + routekm + ", updownInd=" + updownInd + ", plCd=" + plCd
				+ ", mdDate=" + mdDate + "]";
	}

}
