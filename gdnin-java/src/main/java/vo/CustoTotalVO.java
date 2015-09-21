package vo;

import java.util.List;

import model.Custo;

public class CustoTotalVO {
	
	private List<Custo> custos;
	
	private Float total;

	public CustoTotalVO(List<Custo> custos, Float total){
		this.custos = custos;
		this.total = total;
	}
	
	public List<Custo> getCustos() {
		return custos;
	}

	public void setCustos(List<Custo> custos) {
		this.custos = custos;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}
	
	

}
